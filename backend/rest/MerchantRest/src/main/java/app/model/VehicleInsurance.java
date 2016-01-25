package app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class VehicleInsurance implements Serializable {
	
		/**
	 * 
	 */
	private static final long serialVersionUID = -1027548365143014756L;
	
	@NotNull(message = "error.duration.notnull")
	private int duration;
	
	@NotNull(message = "error.model.notnull")
	private String model;
	
	@NotNull(message = "error.type.notnull")
	private String type;
	
	@NotNull(message = "error.owner.notnull")
	private String owner;
	
	@NotNull(message = "error.productionYear.notnull")
	private int productionYear;
	
	@NotNull(message = "error.registrationNumber.notnull")
	private String registrationNumber;
	
	@NotNull(message = "error.vinNumber.notnull")
	private String vinNumber;
	
	@NotNull(message = "error.packageV.notnull")
	private String packageV;

	public VehicleInsurance() {
		super();
	}

	public VehicleInsurance(int duration, String model, String type, String owner, int productionYear,
			String registrationNumber, String vinNumber, String packageV) {
		super();
		this.duration = duration;
		this.model = model;
		this.type = type;
		this.owner = owner;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
		this.vinNumber = vinNumber;
		this.packageV = packageV;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
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

	public String getVinNumber() {
		return vinNumber;
	}

	public void setVinNumber(String vinNumber) {
		this.vinNumber = vinNumber;
	}

	public String getPackageV() {
		return packageV;
	}

	public void setPackageV(String packageV) {
		this.packageV = packageV;
	}

	@Override
	public String toString() {
		return "VehicleInsurance [duration=" + duration + ", model=" + model + ", type=" + type + ", owner=" + owner
				+ ", productionYear=" + productionYear + ", registrationNumber=" + registrationNumber + ", vinNumber="
				+ vinNumber + ", packageV=" + packageV + "]";
	}

		
}
