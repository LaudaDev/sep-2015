package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Vehicle;
import app.repository.local.VehicleInsuranceRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class VehicleInsuranceService {

	@Autowired
	private VehicleInsuranceRepository vehicleRepository;
	
	private static final Logger logger = Logger.getLogger(VehicleInsuranceService.class);

	public Map<String, Object> create(Vehicle vehicle) {
	
		Map<String, Object> response;

		if (vehicle == null) {
			throw new BadRequestException();		
		}
		
		response = new LinkedHashMap<String, Object>();
		vehicleRepository.save(vehicle);
		response.put("message", "Vehicle insurance created successfully");
		response.put("sport", vehicle);
		
		logger.info("Vehicle insurance created successfully");
		return response;

	}

	public List<Vehicle> findAll() {
		logger.info("List all insurances");
		return (List<Vehicle>) vehicleRepository.findAll();
	}

	public Vehicle findById(String id) {

		if(id == null)
		{
			throw new BadRequestException();
		} 
		
		logger.info("Find vehicle insurance with id: " + id);
		Vehicle vehicle = vehicleRepository.findOne(id);;
		
		if (vehicle == null) {
			throw new NotFoundException();
		}
		return vehicle;
	
	}

	
	public String remove(String id) {
		if(id == null)
		{
			throw new BadRequestException();
		}
		logger.info("Removing vehicle insurance with id: " + id);		
		vehicleRepository.delete(id);	
		return "removed";
				
	}

	
}
