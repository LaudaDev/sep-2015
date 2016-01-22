package app.validators;

import org.apache.log4j.Logger;

import app.model.Insurance;
import app.model.RealestateInsurance;
import app.model.Travel;
import app.model.VehicleInsurance;

public final class InsuranceValidation {

	private static final Logger logger = Logger.getLogger(InsuranceValidation.class);
	
	public static boolean validateInsurance(Insurance insurance)
	{

		if(insurance.getAmountToPay()<0)
		{
			logger.error("Amount to pay < 0");
			return false;
		}
		
		if(insurance.getTravel() == null)
		{
			logger.error("Travel insurance is null.");
			return false;
		}
		else
		{
			if(!validateTravelInsurance(insurance.getTravel()))
			{
				logger.error("Travel insurance is not valid.");
				return false;
			}
		}
		
		if(insurance.getVehicle()!=null){
			
			if(!validateVehicleInsurance(insurance.getVehicle()))
			{
				logger.error("Vehicle insurance is not valid.");
				return false;
			}
		}
		
		if(insurance.getRealEstate()!=null)
		{
			if(!validateRealestateInsurance(insurance.getRealEstate()))
			{
				logger.error("Realestate insurance is not valid.");
				return false;
			}
		}
			
		
		return true;
	}
	
	
	public  static boolean validateVehicleInsurance(VehicleInsurance vehicleIns)
	{
		
		if(vehicleIns.getDuration() < 0)
		{
			logger.error("Vehicle insurance duration < 0");
			return false;
		}
		
		if(vehicleIns.getProductionYear()<1940)
		{
			logger.error("Vehicle insurance production year < 1940");
			return false;
		}
		return true;
	}
	
	public  static boolean validateRealestateInsurance(RealestateInsurance realestateIns)
	{
		if(realestateIns.getDuration() < 0)
		{
			logger.error("Realestate insurance duration < 0");
			return false;
		}
		
		if(realestateIns.getAge() < 0)
		{
			logger.error("Realestate insurance age < 0");
			return false;
		}
		
		if(realestateIns.getEstimatedValue() < 0)
		{
			logger.error("Realestate insurance estimated value < 0");
			return false;
		}
		
		if(realestateIns.getOwner()==null)
		{
			logger.error("Realestate insurance owner is null");
			return false;
		}
		
		if(realestateIns.getPackageRE()==null)
		{
			logger.error("Realestate insurance package is null");
			return false;
		}
	
		return true;
	}
	
	public  static boolean validateTravelInsurance(Travel travelIns)
	{
		
		if(travelIns.getUsers() == null)
		{
			logger.error("Travel insurance users list is null");
			return false;
		}
		
		if(travelIns.getDuration() < 0)
		{
			logger.error("Travel insurance duration < 0");
			return false;
		}
	
		if(travelIns.getRegion() == null)
		{
			logger.error("Travel insurance region is null");
			return false;
		}
		
		if(travelIns.getNumOfPersons()<=0)
		{
			logger.error("Travel insurance number of persons<= 0");
			return false;
		}
		
		if(travelIns.getInsuredAmount() < 0)
		{
			logger.error("Travel insurance amount< 0");
			return false;
		}
		
		return true;
	}
}
