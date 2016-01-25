package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Sport;
import app.repository.SportRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class SportService {

	@Autowired
	private SportRepository sportRepository;

	private static final Logger logger = Logger.getLogger(SportService.class);

	public Map<String, Object> create(Sport sport) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		sportRepository.save(sport);
		response.put("message", "Sport successfully created ");
		response.put("sport", sport);
		logger.info("Sport successfully created ");

		return response;
	}

	public List<Sport> findAll() {

		return (List<Sport>) sportRepository.findAll();
	}

	public Sport findById(String id) {

		if (id == null) {
			throw new BadRequestException("sport id is null");
		}

		Sport sport = sportRepository.findOne(id);
		if (sport == null) {
			throw new NotFoundException("Sport with id " + id + " doesn't exist.");
		}
		return sport;
	}

	public String remove(String id) {
		if (id == null) {
			throw new BadRequestException("sport id is null");
		}
		logger.info("Removing sport with id: " + id);
		sportRepository.delete(id);
		return "removed";
	}
	
	public Map<String, Object> edit(Sport sport) {

		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		sportRepository.save(sport);
		response.put("message", "Sport successfully updated");
		response.put("sport", sport);
		logger.info("Sport successfully updated");

		return response;
	}


}
