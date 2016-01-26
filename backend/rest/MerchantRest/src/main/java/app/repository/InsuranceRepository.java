package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Insurance;


public interface InsuranceRepository extends MongoRepository<Insurance,String>{
	
}
