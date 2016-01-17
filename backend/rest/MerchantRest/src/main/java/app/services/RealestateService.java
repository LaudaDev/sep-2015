package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.RealestateInsPackage;
import app.repository.local.RealestatePackLocalRepository;

@Service
public class RealestateService {
	@Autowired
	private RealestatePackLocalRepository realestateRepository;

	
	public RealestateInsPackage create(RealestateInsPackage realestate) {
		return realestateRepository.save(realestate);
	
	}


	public List<RealestateInsPackage> findAll() {
		return (List<RealestateInsPackage>) realestateRepository.findAll();
	}

	
	public RealestateInsPackage findById( String packageId) {
		return realestateRepository.findOne(packageId);
	}

	
	public void remove(String packageId) {
		realestateRepository.delete(packageId);

	}
}
