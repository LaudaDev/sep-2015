package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Sport;
import app.repository.local.SportLocalRepository;

@Service
public class SportService {

	@Autowired
	private SportLocalRepository sportRepository;

	
	public Sport create(Sport sport) {
	
		return sportRepository.save(sport);
	}

	public List<Sport> findAll() {
		
		return (List<Sport>) sportRepository.findAll();
	}

	public Sport findById(String id) {
		return sportRepository.findOne(id);
	}

	
	public void remove(String id) {
		sportRepository.delete(id);		
	}

	public Sport update(Sport sport) {
		
		return sportRepository.save(sport);
	}
}
