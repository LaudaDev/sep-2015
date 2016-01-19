package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Insurance;
import app.repository.local.InsuranceRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;
import app.validators.InsuranceValidation;

@Service
public class InsuranceService {
	@Autowired
	private InsuranceRepository insuranceRepository;

	private static final Logger logger = Logger.getLogger(InsuranceService.class);

	public Map<String, Object> create(Insurance insurance) {

		Map<String, Object> response;

		if (!InsuranceValidation.validateInsurance(insurance)) {
			throw new BadRequestException();
		}

		response = new LinkedHashMap<String, Object>();
		insuranceRepository.save(insurance);
		response.put("message", "Insurance created successfully");
		response.put("insurance", insurance);

		logger.info("Insurance created successfully");

		return response;
	}

	public List<Insurance> findAll() {

		logger.info("List all insurances");
		return insuranceRepository.findAll();
	}

	public Insurance findById(String insId) {

		Insurance insurance = insuranceRepository.findOne(insId);
		logger.info("Find insurance with id: " + insId);

		if (insurance == null) {
			throw new NotFoundException();
		}

		return insurance;
	}

	public String remove(String insId) {

		logger.info("Removing insurance with id: " + insId);
		insuranceRepository.delete(insId);
		return "removed";
	}

	public Map<String, Object> edit(Insurance insurance) {

		Map<String, Object> response;

		if (!InsuranceValidation.validateInsurance(insurance)) {
			throw new BadRequestException();
		}

		response = new LinkedHashMap<String, Object>();
		insuranceRepository.save(insurance);
		response.put("message", "Insurance updated successfully");
		response.put("insurance", insurance);

		logger.info("Insurance updated successfully");

		return response;
	}
}
