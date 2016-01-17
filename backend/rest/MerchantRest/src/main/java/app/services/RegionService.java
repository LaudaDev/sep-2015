package app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Region;
import app.repository.local.RegionLocalRepository;

@Service
public class RegionService {

	@Autowired
	private RegionLocalRepository regionRepository;

	
	public Region create(Region region) {
	
		return regionRepository.save(region);
	}

	public List<Region> findAll() {
		
		return (List<Region>) regionRepository.findAll();
	}

	public Region findById(String id) {
		return regionRepository.findOne(id);
	}

	
	public void remove(String id) {
		regionRepository.delete(id);		
	}

	public Region update(Region region) {
		
		return regionRepository.save(region);
	}
}
