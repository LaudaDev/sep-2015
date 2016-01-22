package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.VehicleInsurance;


public interface VehicleInsuranceRepository  extends MongoRepository<VehicleInsurance,String>  {
	

}
