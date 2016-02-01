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

import app.model.InsuredAmount;
import app.services.InsuredAmountService;

@RestController
@RequestMapping("/insuredAmount")
public class InsuredAmountController {

	@Autowired
	private InsuredAmountService insuredAmountService;

	@RequestMapping(method = RequestMethod.POST)
	public Map<String, Object> createInsuredAmount(@Validated @RequestBody InsuredAmount amount) {
		return insuredAmountService.create(amount);	
	}

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	@CrossOrigin
	public List<InsuredAmount> getInsuredAmounts() {
		return insuredAmountService.findAll();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{amountId}")
	public InsuredAmount getInsuredAmountById(@PathVariable("amountId") String amountId) {
		return insuredAmountService.findById(amountId);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/{amountId}")
	public String removeInsuredAmount(@PathVariable("amountId") String amountId) {
		return insuredAmountService.remove(amountId);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Map<String, Object> editInsuredAmount(@Validated @RequestBody InsuredAmount amount) {
		return insuredAmountService.edit(amount);
	}

}
