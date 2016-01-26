package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.InsuredAmount;
import app.repository.InsuredAmountRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class InsuredAmountService {


	@Autowired
	private InsuredAmountRepository insuredAmountRepository;

	private static final Logger logger = Logger.getLogger(InsuredAmountService.class);

	public Map<String, Object> create(InsuredAmount amount) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		insuredAmountRepository.save(amount);
		response.put("message", "Amount successfully created");
		response.put("amount", amount);
		logger.info("Amount successfully created");

		return response;
	}

	public List<InsuredAmount> findAll() {
		return (List<InsuredAmount>) insuredAmountRepository.findAll();
	}

	public InsuredAmount findById(String id) {

		if (id == null) {
			throw new BadRequestException("amountId is null");
		}
		InsuredAmount amount = insuredAmountRepository.findOne(id);
		if (amount == null) {
			throw new NotFoundException("InsuredAmount with id " + id + " doesn't exist.");		
		}		
		return amount;
	}

	public String remove(String id) {

		if (id == null) {
			throw new BadRequestException("amountId is null");
		}	
		logger.info("Removing insured amount with id: " + id);
		insuredAmountRepository.delete(id);
		return "removed";
	}
	
	public Map<String, Object> edit(InsuredAmount amount) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		insuredAmountRepository.save(amount);
		response.put("message", "Amount updated successfully");
		response.put("amount", amount);
		logger.info("Amount updated successfully");

		return response;
	}
}
