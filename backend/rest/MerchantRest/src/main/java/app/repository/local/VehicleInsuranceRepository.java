package app.repository.local;

import org.springframework.data.mongodb.repository.MongoRepository;

import app.model.Vehicle;


public interface VehicleInsuranceRepository  extends MongoRepository<Vehicle,String>  {
	

}
