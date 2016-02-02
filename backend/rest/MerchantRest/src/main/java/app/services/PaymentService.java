package app.services;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.commons.Consts;
import app.commons.CustomIdGenerator;
import app.commons.Messages;
import app.commons.TransactionStatusCodes;
import app.commons.UrlRegister;
import app.model.Insurance;
import app.model.Transaction;
import app.model.transferData.MerchantInfo;
import app.model.transferData.MerchantPaymentRequest;
import app.model.transferData.PaymentInstructionsAcquirerResponse;
import app.model.transferData.TransactionResults;
import app.model.transferData.TransactionStatus;
import app.services.exceptions.CustomRestClientException;

@Service
public class PaymentService {
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private InsuranceService insuranceService;
	@Autowired
	private MailSenderService mailService;

	private static final Logger logger = Logger.getLogger(PaymentService.class);
	final RestTemplate restTemplate = new RestTemplate();

	public PaymentInstructionsAcquirerResponse buyInsurance(Insurance insurance) {

		Insurance newInsurance = (Insurance) insuranceService.create(insurance).get("insurance");

		MerchantPaymentRequest paymentRequest = createPaymentRequest(newInsurance.getAmountToPay());

		PaymentInstructionsAcquirerResponse instructions = getPaymentInstructions(paymentRequest);
		if (instructions == null) {
			throw new CustomRestClientException(
					"There was an error communicating with the paying app server.  Instructions for payment have not been received.");
		}

		logger.info("PaymentInstructions received");

		Transaction transaction = createTransaction(paymentRequest.getMerchantInfo(), newInsurance.getId(),
				instructions.getPaymentID());

		transactionService.save(transaction);
		return instructions;
	}

	public ResponseEntity<?> saveTransactionResult(TransactionResults transactionResults, BindingResult bindingResult) {

		URL resultURL = null;
		String userMessage = "";
		boolean isStatusNull = false;
		boolean isTransactionNull = false;
		boolean isStatusServerError = false;
		Transaction transaction = null;

		logger.info("transaction results " + transactionResults.toString());
		TransactionStatus status = transactionResults.getTransactionStatus();
		if (bindingResult.hasErrors()) {
			if (status == null)
				isStatusNull = true;

		}

		if (transactionResults.getMerchantOrderId() != null && transactionResults.getPaymentId() != null) {
			transaction = transactionService.findByMerchantOrderAndPaymentId(transactionResults.getMerchantOrderId(),
					transactionResults.getPaymentId());
		}

		if (transaction == null)
			isTransactionNull = true;

		if (!isStatusNull) {
			if (status.getCode() == null) {
				resultURL = UrlRegister.ERROR_URL;
				isStatusServerError = true;
			} else {

				if (status.getCode().equals(TransactionStatusCodes.SUCCESS.getValue())) {

					resultURL = UrlRegister.SUCCESS_URL;
					userMessage = Messages.SUCCESS_MESSAGE;

				} else if (status.getCode().equals(TransactionStatusCodes.SERVER_ERROR.getValue())) {

					resultURL = UrlRegister.ERROR_URL;
					isStatusServerError = true;
					// userMessage = Messages.SERVER_PROBLEM_MESSAGE;

				} else {

					resultURL = UrlRegister.FAILED_URL;
					userMessage = Messages.CARD_PROBLEM_MESSAGE;

				}
			}
		} else {
			resultURL = UrlRegister.ERROR_URL;
		}

		if (!isTransactionNull) {
			transaction.setAcquirerInfo(transactionResults.getAcquirerInfo());
			transaction.setTransactionStatus(transactionResults.getTransactionStatus());

			transactionService.update(transaction);

			if (!isStatusServerError) {
				if (transaction.getInsuranceId() != null) {
					Map<String, String> carrierMailInfo = insuranceService
							.getCarrierEmailInfo(transaction.getInsuranceId());
					String carrierEmail = carrierMailInfo.get("email");
					String carrierNameAndSurname = carrierMailInfo.get("name") + " " + carrierMailInfo.get("surname");
					if (carrierEmail != null) {

						mailService.send(userMessage, carrierEmail, carrierNameAndSurname);
					} else {
						logger.info("Carrier mail is null.");
					}
				} else {
					logger.error("Insurance id is null,  transaction with id " + transaction.getId());
				}
			}

		}
		HttpHeaders headers = new HttpHeaders();
		try {

			headers.setLocation(resultURL.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}

	public PaymentInstructionsAcquirerResponse getPaymentInstructions(MerchantPaymentRequest request) {

		PaymentInstructionsAcquirerResponse instructions = null;
		try {
			instructions = restTemplate.postForObject(UrlRegister.ACQUIRER_URL.toString(), request,
					PaymentInstructionsAcquirerResponse.class);
		} catch (RestClientException e) {


			logger.info("rest exception");
			e.printStackTrace();

		}
		return instructions;
	}

	public MerchantPaymentRequest createPaymentRequest(BigDecimal amount) {

		int transactionId = CustomIdGenerator.getTransactionId();
		Date timestamp = new Date();
		MerchantPaymentRequest newPaymentRequest = new MerchantPaymentRequest(Consts.MERCHANT_ID,
				Consts.MERCHANT_PASSWORD, amount, new MerchantInfo(transactionId, timestamp), UrlRegister.ERROR_URL);
		logger.info("Payment request successfully created");
		logger.info(newPaymentRequest.toString());
		return newPaymentRequest;

	}

	public Transaction createTransaction(MerchantInfo merchantInfo, String insuranceId, int paymentID) {
		Transaction transaction = new Transaction();
		transaction.setMerchantInfo(merchantInfo);
		transaction.setInsuranceId(insuranceId);
		transaction.setPaymentID(paymentID);
		transaction.setTransactionStatus(null);
		return transaction;

	}

}
