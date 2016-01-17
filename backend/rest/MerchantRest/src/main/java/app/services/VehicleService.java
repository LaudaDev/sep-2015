package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Vehicle;
import app.repository.local.VehicleLocalRepository;

@Service
public class VehicleService {

	@Autowired
	private VehicleLocalRepository vehicleRepository;

	
	public Vehicle create(Vehicle vehicle) {
	
		return vehicleRepository.save(vehicle);
	}

	public List<Vehicle> findAll() {
		
		return (List<Vehicle>) vehicleRepository.findAll();
	}

	public Vehicle findById(String id) {
		return vehicleRepository.findOne(id);
	}

	
	public void remove(String id) {
		vehicleRepository.delete(id);		
	}

	public Vehicle update(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}
}
