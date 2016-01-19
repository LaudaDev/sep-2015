package app.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import app.commons.Consts;
import app.transferData.PaymentRequest;
import app.transferData.PaymentResponse;

@Service
public class PaymentLookupService {

	final RestTemplate restTemplate = new RestTemplate();

	public PaymentResponse getPaymentInstructions(PaymentRequest request)
	{
		Map<String, PaymentRequest> paramsMap = new HashMap<String, PaymentRequest>();
		PaymentResponse instructions;
		
		paramsMap.put("paymentRequest", request);
		instructions = restTemplate.getForObject(Consts.ACQUIRER_URL.toString(), PaymentResponse.class, paramsMap);
		
		return instructions;
	}
	
}
