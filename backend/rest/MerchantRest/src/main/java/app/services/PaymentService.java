package app.services;

import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import app.commons.Consts;
import app.commons.RandomGenerator;
import app.model.Insurance;
import app.model.Transaction;
import app.model.transferData.MerchantPaymentRequest;
import app.model.transferData.PaymentInstructionsAcquirerResponse;
import app.model.transferData.TransactionResults;
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

		Transaction transaction = createTransaction(paymentRequest.getMerchantOrderId(),
				paymentRequest.getMerchantTimestamp(), newInsurance.getId(), instructions.getPaymentID());

		transactionService.save(transaction);
		return instructions;
	}

	public ResponseEntity<?> saveTransactionResult(TransactionResults transactionResults) {

		URL resultURL = null;
		String userMessage = "";

		Transaction transaction = transactionService.findByMerchantOrderAndPaymentId(transactionResults.getMerchantOrderId(), transactionResults.getPaymentId());
		transaction.setAcquirerOrderId(transactionResults.getAcquirerOrderId());
		transaction.setAcquirerTimestamp(transactionResults.getAcquirerTimestamp());
		transaction.setTransactionSucceded(transactionResults.isTransactionSucceded());
		transaction.setCardAuthenticated(transactionResults.isCardAuthenticated());
		transaction.setCardAuthorized(transactionResults.isCardAuthorized());

		if (transactionResults.isTransactionSucceded() && transactionResults.isCardAuthorized()
				&& transactionResults.isCardAuthenticated()) {

			resultURL = Consts.SUCCESS_URL;
			userMessage = Consts.SUCCESS_MESSAGE;
		} else {

			resultURL = Consts.FAILED_URL;
			userMessage = Consts.CARD_PROBLEM_MESSAGE;

		}

		transactionService.update(transaction);

		HttpHeaders headers = new HttpHeaders();
		try {
			headers.setLocation(resultURL.toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		mailService.send(userMessage, "zdeuric@gmail.com", "Zorana Deuric");

		return new ResponseEntity<>(headers, HttpStatus.CREATED);

	}

	public PaymentInstructionsAcquirerResponse getPaymentInstructions(MerchantPaymentRequest request) {
		PaymentInstructionsAcquirerResponse instructions = null;

		try {
			instructions = restTemplate.postForObject(Consts.ACQUIRER_URL.toString(), request,
					PaymentInstructionsAcquirerResponse.class);
		} catch (RestClientException e) {
			logger.error(e.getStackTrace().toString());
		}

		return instructions;
	}

	public MerchantPaymentRequest createPaymentRequest(BigDecimal amount) {

		int transactionId = RandomGenerator.getTransactionId();
		Date timestamp = new Date();
		MerchantPaymentRequest newPaymentRequest = new MerchantPaymentRequest(Consts.MERCHANT_ID,
				Consts.MERCHANT_PASSWORD, amount, transactionId, timestamp, Consts.ERROR_URL);
		logger.info("Payment request successfully created");
		logger.info(newPaymentRequest.toString());
		return newPaymentRequest;

	}

	public Transaction createTransaction(int merchantOrderId, Date merchantTimestamp, String insuranceId,
			int paymentID) {
		Transaction transaction = new Transaction();
		transaction.setMerchantOrderId(merchantOrderId);
		transaction.setMerchantTimestamp(merchantTimestamp);
		transaction.setInsuranceId(insuranceId);
		transaction.setPaymentID(paymentID);
		transaction.setTransactionSucceded(false);
		transaction.setCardAuthenticated(false);
		transaction.setCardAuthorized(false);

		return transaction;

	}

}
