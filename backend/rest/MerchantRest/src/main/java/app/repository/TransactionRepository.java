package app.repository;

import java.util.Date;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String>{

	  @Query(value="{ 'paymentID' : ?0 }")
	  Transaction findByPaymentID(int paymentID);
	  
	  @Query(value="{ 'merchantOrderId' : ?0, 'merchantTimestamp': ?1}")
	  Transaction findByMerchantOrderIdAndTimestamp(int merchantOrderId, Date merchantTimestamp);

	  @Query(value="{ 'merchantOrderId' : ?0, 'paymentID': ?1}")
	  Transaction findByMerchantOrderAndPaymentId(int merchantOrderId, int paymentID);

}
