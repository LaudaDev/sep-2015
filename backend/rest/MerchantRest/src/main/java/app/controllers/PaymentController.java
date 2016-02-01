package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.Insurance;
import app.model.transferData.PaymentInstructionsAcquirerResponse;
import app.model.transferData.TransactionResults;
import app.services.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:8081") 
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public PaymentInstructionsAcquirerResponse buyInsurance(@Validated @RequestBody Insurance insurance)
	{	
		PaymentInstructionsAcquirerResponse instructions = paymentService.buyInsurance(insurance);
		return instructions;

	
	}
	
	
	
	@RequestMapping(value = "transactionResults",method = RequestMethod.POST)
	public ResponseEntity<?> receiveTransactionResults(@Validated @RequestBody TransactionResults transactionResults, BindingResult bindingResult)
	{	
		return paymentService.saveTransactionResult(transactionResults, bindingResult);	
	}
	
	
}
