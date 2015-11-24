package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "vehicles") 
public class Vehicle {

	@Id
	private String vinNumber; // broj sasije
	
	private String manufacturer;
	
	private String model;
	
	private int productionYear;
	
	private String registrationNumber;
	
	private User owner;

	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vehicle(String vinNumber, String manufacturer, String model, int productionYear, String registrationNumber,
			User owner) {
		super();
		this.vinNumber = vinNumber;
		this.manufacturer = manufacturer;
		this.model = model;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
		this.owner = owner;
	}

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(int productionYear) {
		this.productionYear = productionYear;
	}

	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
	        return false;
	    if (!(obj instanceof User))
	        return false;
	    Vehicle other = (Vehicle) obj;
	    return vinNumber == null ? false : vinNumber.equals(other.vinNumber);//Compare vinNumber if null falseF
	}
	
	@Override
	public int hashCode() {
	    return vinNumber == null ? 0 : vinNumber.hashCode();
	}
}
