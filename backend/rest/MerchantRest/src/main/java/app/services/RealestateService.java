package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.RealestateInsPackage;
import app.repository.RealestatePackRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class RealestateService {

	@Autowired
	private RealestatePackRepository realestateRepository;

	private static final Logger logger = Logger.getLogger(RealestateService.class);

	public Map<String, Object> create(RealestateInsPackage realestate) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		realestateRepository.save(realestate);
		response.put("message", "Package created successfully");
		response.put("package", realestate);
		logger.info("Package created successfully");
		return response;

	}

	public List<RealestateInsPackage> findAll() {
		return (List<RealestateInsPackage>) realestateRepository.findAll();
	}

	public RealestateInsPackage findById(String packageId) {

		if (packageId == null) {
			throw new BadRequestException("packageId is null");
		}
		RealestateInsPackage rPackage = realestateRepository.findOne(packageId);
		
		if (rPackage == null) {
			throw new NotFoundException("Realestate package with id " + packageId + " doesn't exist.");
		}
		return rPackage;
	}

	public String remove(String packageId) {

		if (packageId == null) {
			throw new BadRequestException("package id is null");
		}
		logger.info("Removing package with id: " + packageId);
		realestateRepository.delete(packageId);
		return "removed";

	}

	public Map<String, Object> edit(RealestateInsPackage realestate) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		realestateRepository.save(realestate);
		response.put("message", "Package updated successfully");
		response.put("package", realestate);
		logger.info("Package updated successfully");
		return response;

	}
}
