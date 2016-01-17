package app.controllers;

import java.util.LinkedHashMap;
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
	public Map<String, Object> createinsurance(@RequestBody Insurance insurance) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
		if (insurance == null) {
			response.put("message", "Error.Insurance is null.");
		} else {
			//dodati validacije 
			System.out.println("ispiiis "+insurance.toString());
			insuranceService.create(insurance);
			response.put("message", "Insurance created successfully");
			response.put("insurance", insurance);
		}
	
		return response;
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
		insuranceService.remove(insId);
		return "removed";
	}
	
	/*@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> editInsurance(@RequestBody Insurance insurance) {
		Map<String, Object> response = new LinkedHashMap<String, Object>();
	

		return response;
	}*/
	
}
