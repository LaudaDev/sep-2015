package app.services;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.model.Region;
import app.repository.local.RegionRepository;
import app.services.exceptions.BadRequestException;
import app.services.exceptions.NotFoundException;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	private static final Logger logger = Logger.getLogger(RegionService.class);

	public Map<String, Object> create(Region region) {
	
		Map<String, Object> response;

		if (region == null) {
			throw new BadRequestException();		
		}
		
		response = new LinkedHashMap<String, Object>();
		regionRepository.save(region);
		response.put("message", "Region created successfully");
		response.put("region", region);
		
		logger.info("Region created successfully");
		return response;
	}

	public List<Region> findAll() {
		
		logger.info("List all regions");
		return (List<Region>) regionRepository.findAll();
	}

	public Region findById(String id) {
		
		if(id == null)
		{
			throw new BadRequestException();
		} 
		
		logger.info("Find region with id: " + id);
		Region region = regionRepository.findOne(id);
		
		if (region == null) {
			throw new NotFoundException();
		}
		return region;
	}

	
	public String remove(String id) {
		
		if(id == null)
		{
			throw new BadRequestException();
		}
		logger.info("Removing region with id: " + id);		
		regionRepository.delete(id);	
		return "removed";
	}

	public Map<String, Object>  update(Region region) {
		
		Map<String, Object> response;

		if (region == null) {
			throw new BadRequestException();		
		}
		
		response = new LinkedHashMap<String, Object>();
		regionRepository.save(region);
		response.put("message", "Region updated successfully");
		response.put("region", region);
		
		logger.info("Region updated successfully");
		return response;
	}
}
