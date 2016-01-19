package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.model.Transaction;

public interface TransactionLocalRepository extends MongoRepository<Transaction, String>{

	  @Query(value="{ 'paymentID' : ?0 }")
	  Transaction findByPaymentID(int paymentID);
	  
	  @Query(value="{ 'merchantOrderId' : ?0 }")
	  Transaction findByMerchantOrderId(int merchantOrderId);
}
