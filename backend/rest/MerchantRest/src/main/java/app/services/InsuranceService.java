package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Insurance;
import app.repository.local.InsuranceLocalRepository;

@Service
public class InsuranceService {
	@Autowired
	private InsuranceLocalRepository insuranceRepository;

	
	public Insurance create(Insurance insurance) {
	
		return insuranceRepository.save(insurance);
	}

	public List<Insurance> findAll() {
		
		return (List<Insurance>) insuranceRepository.findAll();
	}

	public Insurance findById(String insId) {
		return insuranceRepository.findOne(insId);
	}

	
	public void remove(String insId) {
		insuranceRepository.delete(insId);		
	}

	public Insurance update(Insurance insurance) {
		
		return insuranceRepository.save(insurance);
	}
}
