package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "insurances") 
public abstract class Insurance {
	
	@Id
	private String id;
	
	private int insuranceDuration; // mozda ovde treba date!!! verovatno treba jer ces birati sa date pickera pocetak i kraj vazenja osiguranja
	
	private double insurancePrice;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getInsuranceDuration() {
		return insuranceDuration;
	}

	public void setInsuranceDuration(int insuranceDuration) {
		this.insuranceDuration = insuranceDuration;
	}

	public double getInsurancePrice() {
		return insurancePrice;
	}

	public void setInsurancePrice(double insurancePrice) {
		this.insurancePrice = insurancePrice;
	}

	
}
