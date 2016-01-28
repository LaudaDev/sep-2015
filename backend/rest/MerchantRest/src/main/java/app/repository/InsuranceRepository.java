package app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import app.model.Insurance;


public interface InsuranceRepository extends MongoRepository<Insurance,String>{
	
	@Query(value="{ 'id' : ?0}", fields = "{'carrier.email': 1, 'carrier.name':1, 'carrier.surname':1}")
	Insurance getCarrierEmailInfo(String insuranceId);
}
