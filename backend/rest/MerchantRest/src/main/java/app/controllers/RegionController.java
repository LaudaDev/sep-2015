package app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Region;
import app.services.RegionService;

@RestController
@RequestMapping("/region")
public class RegionController {
	
	@Autowired
	private RegionService regionService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createRegion(@Validated @RequestBody Region region) {
		return regionService.create(region);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public List<Region> getRegions() {
		return (List<Region>) regionService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{regionId}")
	public Region getRegionById(@PathVariable("regionId") String regionId) {
		return regionService.findById(regionId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{regionId}")
	public String removeRegion(@PathVariable("regionId") String regionId) {
		return regionService.remove(regionId);

	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> updateRegion(@Validated @RequestBody Region region) {
		return regionService.update(region);
	}
	
}
