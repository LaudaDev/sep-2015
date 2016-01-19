package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.RealestateInsPackage;
import app.repository.local.RealestatePackRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class RealestateService {
	
	@Autowired
	private RealestatePackRepository realestateRepository;
	
	private static final Logger logger = Logger.getLogger(RealestateService.class);

	
	public Map<String, Object> create(RealestateInsPackage realestate) {
		
		Map<String, Object> response;
		
		if (realestate == null) {
			throw new BadRequestException();		
		}
		
		response = new LinkedHashMap<String, Object>();
		realestateRepository.save(realestate);
		response.put("message", "Package created successfully");
		response.put("package", realestate);
		logger.info("Package created successfully");
		
		return response;
	
	}


	public List<RealestateInsPackage> findAll() {
		logger.info("List all packages");
		return (List<RealestateInsPackage>) realestateRepository.findAll();
	}

	
	public RealestateInsPackage findById( String packageId) {
		
		if(packageId == null)
		{
			throw new BadRequestException();
		} 
		
		logger.info("Find package with id: " + packageId);
		RealestateInsPackage rPackage =realestateRepository.findOne(packageId);
		
		if (rPackage == null) {
			throw new NotFoundException();
		}
		return rPackage;
	}

	
	public String remove(String packageId) {

		if(packageId == null)
		{
			throw new BadRequestException();
		}
		logger.info("Removing package with id: " + packageId);		
		realestateRepository.delete(packageId);	
		return "removed";
	

	}
}
