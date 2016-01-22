package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.InsuredAmount;

public interface InsuredAmountRepository extends MongoRepository<InsuredAmount,String> {

	public InsuredAmount findInsuredAmountByAmount(double amount);
}
