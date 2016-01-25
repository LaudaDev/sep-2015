package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Region;
import app.repository.RegionRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	private static final Logger logger = Logger.getLogger(RegionService.class);

	public Map<String, Object> create(Region region) {
	
		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		regionRepository.save(region);
		response.put("message", "Region successfully created");
		response.put("region", region);	
		logger.info("Region successfully created");
		return response;
	}

	public List<Region> findAll() {
		return (List<Region>) regionRepository.findAll();
	}

	public Region findById(String id) {
		
		if(id == null)
		{
			throw new BadRequestException("regionId is null");
		} 	
		Region region = regionRepository.findOne(id);	
		if (region == null) {
			throw new NotFoundException("Region with id " + id + " doesn't exist.");
		}
		return region;
	}

	
	public String remove(String id) {
		
		if(id == null)
		{
			throw new BadRequestException("regionId is null");
		}
		
		logger.info("Removing region with id: " + id);		
		regionRepository.delete(id);	
		return "removed";
	}

	public Map<String, Object>  update(Region region) {
		
		Map<String, Object> response;
		response = new LinkedHashMap<String, Object>();
		regionRepository.save(region);
		response.put("message", "Region successfully  updated");
		response.put("region", region);
		
		logger.info("Region successfully  updated");
		return response;
	}
}
