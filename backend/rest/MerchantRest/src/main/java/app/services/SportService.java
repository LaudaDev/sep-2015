package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Sport;
import app.repository.local.SportRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class SportService {

	@Autowired
	private SportRepository sportRepository;
	
	private static final Logger logger = Logger.getLogger(SportService.class);

	
	public Map<String, Object> create(Sport sport) {
	
		Map<String, Object> response;

		if (sport == null) {
			throw new BadRequestException();		
		}
		
		response = new LinkedHashMap<String, Object>();
		sportRepository.save(sport);
		response.put("message", "Sport created successfully");
		response.put("sport", sport);
		logger.info("Sport created successfully");
		
		return response;
	}

	public List<Sport> findAll() {
		
		logger.info("List all sports");
		return (List<Sport>) sportRepository.findAll();
	}

	public Sport findById(String id) {
		
		if(id == null)
		{
			throw new BadRequestException();
		} 
		
		logger.info("Find sport with id: " + id);
		Sport sport = sportRepository.findOne(id);
		
		if (sport == null) {
			throw new NotFoundException();
		}
		return sport;
	}

	
	public String remove(String id) {	
		if(id == null)
		{
			throw new BadRequestException();
		}
		logger.info("Removing sport with id: " + id);		
		sportRepository.delete(id);	
		return "removed";
	}

	
}
