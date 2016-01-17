package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Insurance;


public interface InsuranceLocalRepository extends MongoRepository<Insurance,String>{
	
}
