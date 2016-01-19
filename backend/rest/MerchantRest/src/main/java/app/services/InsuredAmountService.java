package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.InsuredAmount;
import app.repository.local.InsuredAmountRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class InsuredAmountService {


	@Autowired
	private InsuredAmountRepository insuredAmountRepository;

	private static final Logger logger = Logger.getLogger(InsuredAmountService.class);

	public Map<String, Object> create(InsuredAmount amount) {

		Map<String, Object> response;

		if (amount == null) {
			throw new BadRequestException();
		}

		response = new LinkedHashMap<String, Object>();
		insuredAmountRepository.save(amount);
		response.put("message", "Amount created successfully");
		response.put("region", amount);

		logger.info("Amount created successfully");

		return response;
	}

	public List<InsuredAmount> findAll() {

		logger.info("List all insured amounts");
		return (List<InsuredAmount>) insuredAmountRepository.findAll();
	}

	public InsuredAmount findById(String id) {

		if (id == null) {
			throw new BadRequestException();
		}
		logger.info("Find amount with id: " + id);
		InsuredAmount amount = insuredAmountRepository.findOne(id);

		if (amount == null) {
			throw new NotFoundException();
		}
		return amount;
	}

	public String remove(String id) {

		if (id == null) {
			throw new BadRequestException();
		}
		logger.info("Removing insured amount with id: " + id);
		insuredAmountRepository.delete(id);
		return "removed";
	}
}
