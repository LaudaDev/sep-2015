package app.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Transaction;
import app.repository.TransactionRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

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
		if (id == null) {
			throw new BadRequestException("transaction id is null");
		}
		Transaction transaction = transactionRepository.findOne(id);

		if (transaction == null) {
			throw new NotFoundException("transaction with id " + id + " doesn't exist.");
		}

		return transaction;

	}

	public void remove(String id) {

		if (id == null) {
			throw new BadRequestException("Transaction id is null");
		}
		transactionRepository.delete(id);
	}

	public Transaction update(Transaction transaction) {

		if (transaction == null) {
			throw new BadRequestException("Transaction is null");
		}
		return transactionRepository.save(transaction);
	}

	public Transaction findByPaymentID(int paymentID) {

		Transaction transaction = transactionRepository.findByPaymentID(paymentID);
		if (transaction == null) {
			throw new NotFoundException("transaction with paymentID " + paymentID + " doesn't exist.");
		}

		return transaction;
	}

	public Transaction findByMerchantOrderIdAndTimestamp(int merchantOrderId, Date merchantTimestamp) {

		if (merchantTimestamp == null) {
			throw new BadRequestException("merchantTimestamp is null");

		}
		Transaction transaction = transactionRepository.findByMerchantOrderIdAndTimestamp(merchantOrderId,
				merchantTimestamp);
		if (transaction == null) {
			throw new NotFoundException("transaction with merchantOrderId " + merchantOrderId
					+ " and merchantTimestamp " + merchantTimestamp + " doesn't exist.");
		}

		return transaction;

	}

	public Transaction findByMerchantOrderAndPaymentId(int merchantOrderId, int paymentID) {
		Transaction transaction = transactionRepository.findByMerchantOrderAndPaymentId(merchantOrderId, paymentID);
		if (transaction == null) {
			throw new NotFoundException("transaction with merchantOrderId " + merchantOrderId + " and paymentID "
					+ paymentID + " doesn't exist.");
		}

		return transaction;

	}
}
