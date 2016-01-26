package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.model.Insurance;
import app.model.transferData.PaymentInstructionsAcquirerResponse;
import app.model.transferData.TransactionResults;
import app.services.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	
	@RequestMapping(method = RequestMethod.POST)
	public String buyInsurance(@Validated @RequestBody Insurance insurance, RedirectAttributes redirectAttributes)
	{	
		PaymentInstructionsAcquirerResponse instructions = paymentService.buyInsurance(insurance);
		
	//	redirectAttributes.addFlashAttribute("paymentID", instructions.getPaymentID());
		return "redirect:"+instructions.getPaymentURL()+"/"+instructions.getPaymentID();
	
	}
	
	
	
	@RequestMapping(value = "transactionResults",method = RequestMethod.POST)
	public ResponseEntity<?> receiveTransactionResults(@Validated @RequestBody TransactionResults transactionResults)
	{	
		return paymentService.saveTransactionResult(transactionResults);	
	}
	
	
}
