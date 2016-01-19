package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Transaction;
import app.repository.local.TransactionLocalRepository;

@Service
public class TransactionService {

	@Autowired
	private TransactionLocalRepository transactionRepository;

	
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
	
	 public Transaction findByMerchantOrderId(int merchantOrderId)
	 {
			return transactionRepository.findByMerchantOrderId(merchantOrderId);
	 }
}
