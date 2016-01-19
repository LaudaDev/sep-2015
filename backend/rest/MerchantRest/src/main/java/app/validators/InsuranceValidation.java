package app.validators;

import org.apache.log4j.Logger;

import app.controllers.PaymentController;
import app.model.Insurance;
import app.model.VehicleInsurance;

public class InsuranceValidation {

	private static final Logger logger = Logger.getLogger(InsuranceValidation.class);
	
	public boolean validateInsurance(Insurance insurance)
	{
		boolean isValid = true;
		if(insurance.getAmountToPay()<0)
		{
			isValid = false;
			logger.error("Amount to pay < 0");
		}
		
		if(!validateVehicleInsurance(insurance.getVehicle()))
		{
			logger.error("Vehicle insurance is not valid.");
		}
		
		return isValid;
	}
	
	
	public boolean validateVehicleInsurance(VehicleInsurance vehicleIns)
	{
		boolean isValid = true;
		//TODO
		return isValid;
	}
}
