package app.services;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.commons.Consts;
import app.commons.RandomGenerator;
import app.commons.TransactionStatus;
import app.model.Insurance;
import app.model.Transaction;
import app.transferData.PaymentRequest;
import app.transferData.PaymentResponse;
import app.transferData.TransactionResults;

@Service
public class PaymentService {
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private InsuranceService insuranceService;
	@Autowired
	PaymentLookupService lookupService;
	

	
	public PaymentResponse buyInsurance(Insurance insurance)
	{
		Insurance newInsurance = (Insurance) insuranceService.create(insurance).get("insurance");
		PaymentRequest paymentRequest = createPaymentRequest(newInsurance.getAmountToPay());
		
		PaymentResponse instructions = lookupService.getPaymentInstructions(paymentRequest);
		
		Transaction transaction = createTransaction(paymentRequest.getMerchantOrderId(), newInsurance.getId(),
				instructions.getPaymentID());
		transactionService.save(transaction);	
		
		return instructions;
	}
	
	public PaymentRequest createPaymentRequest(double amount)
	{
		
		String merchantId = String.valueOf(RandomGenerator.generateMerchantId());
		int transactionId = RandomGenerator.getTransactionId();
		Date timestamp = new Date();
		PaymentRequest newPaymentRequest = new PaymentRequest(merchantId,
				Consts.MERCHANT_PASSWORD, amount,transactionId, timestamp,Consts.ERROR_URL);
		
		return newPaymentRequest;
		
	}
	
	public Transaction createTransaction(int merchantOrderId, String insuranceId, int paymentID)
	{
		Transaction transaction = new Transaction();
		transaction.setMerchantOrderId(merchantOrderId);
		transaction.setInsuranceId(insuranceId);
		transaction.setPaymentID(paymentID);
		transaction.setTransactionResult(TransactionStatus.PROCCESSING);
		return transaction;
		
	}
	
	
	
	public String updateTransaction( TransactionResults transactionResults)
	{
		Transaction transaction = transactionService.findByMerchantOrderId(transactionResults.getMerchantOrderId());
	
		if(transactionResults.isSuccess())
		{
			transaction.setTransactionResult(TransactionStatus.SUCCESS);
		}
		else
		{
			transaction.setTransactionResult(TransactionStatus.FAILED);
		}
		transaction.setAcquirerOrderId(transactionResults.getAcquirerOrderId());
		transaction.setAcquirerTimestamp(transactionResults.getAcquirerTimestamp());
		transactionService.update(transaction);
		
		//promijeniti
		return "";
	}

}
