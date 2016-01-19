package app.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import app.model.Insurance;
import app.services.InsuranceService;

@RestController
@RequestMapping("/insurance")

public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createInsurance(@RequestBody Insurance insurance) {	
		
		return insuranceService.create(insurance);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{userId}")
	public Insurance getInsuranceById(@PathVariable("userId") String insId) {
		
		return insuranceService.findById(insId);
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Insurance> getAll() {
		
		return (List<Insurance>) insuranceService.findAll();
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{insuranceId}")
	public String removeInsurance(@PathVariable("insuranceId") String insId) {		
		
		return insuranceService.remove(insId);
		
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> editInsurance(@RequestBody  Insurance insurance) {	
		
		return insuranceService.edit(insurance);
	}
	
	
}
