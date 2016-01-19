package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import app.model.Insurance;
import app.services.PaymentService;
import app.transferData.PaymentResponse;
import app.transferData.TransactionResults;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	//private static final Logger logger = Logger.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;

	
	//@RequestMapping(method = RequestMethod.GET,value = "/{amount}")
	public String buyInsurance(@RequestBody Insurance insurance, RedirectAttributes redirectAttributes)
	{	
		PaymentResponse instructions = paymentService.buyInsurance(insurance);
		redirectAttributes.addFlashAttribute("paymentID", instructions.getPaymentID());
		return "redirect:"+instructions.getPaymentURL();
	
	}
	
	
	
	@RequestMapping(value = "transactionResults",method = RequestMethod.POST)
	public String receiveTransactionResults(@RequestBody TransactionResults transactionResults)
	{
		String resultURL = paymentService.updateTransaction(transactionResults);		
		return resultURL;
	}
	
	
}
