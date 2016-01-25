package app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Transaction;
import app.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionRepository transactionRepository;

	
	public Transaction save(Transaction transaction) {
	
		return transactionRepository.save(transaction);
	}

	public List<Transaction> findAll() {
		
		return (List<Transaction>) transactionRepository.findAll();
	}

	public Transaction findById(String id) {

		return transactionRepository.findOne(id);
	}

	
	public void remove(String id) {

		transactionRepository.delete(id);		
	}

	public Transaction update(Transaction transaction) {
		
		return transactionRepository.save(transaction);
	}
	
	public Transaction findByPaymentID(int paymentID)
	{
		return transactionRepository.findByPaymentID(paymentID);
	}
	
	 public Transaction findByMerchantOrderIdAndTimestamp(int merchantOrderId, Date merchantTimestamp)
	 {
			return transactionRepository.findByMerchantOrderIdAndTimestamp(merchantOrderId, merchantTimestamp);
	 }
	 
	 public Transaction findByMerchantOrderAndPaymentId(int merchantOrderId, int paymentID)
	 {
		 return transactionRepository.findByMerchantOrderAndPaymentId(merchantOrderId, paymentID);
	 }
}
