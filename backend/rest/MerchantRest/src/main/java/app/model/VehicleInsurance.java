package app.model;

import java.io.Serializable;

public class VehicleInsurance implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1027548365143014756L;
	private Integer duration;
	private String model;
	private String type;
	private String owner;
	private int productionYear;
	private String registrationNumber;
	private String vinNumber;
	private String packageV;
	private double packageDetail;

	public VehicleInsurance() {
		super();
	}

	public VehicleInsurance(Integer duration, String model, String type, String owner, int productionYear,
			String registrationNumber, String vinNumber, String packageV, double packageDetail) {
		super();
		this.duration = duration;
		this.model = model;
		this.type = type;
		this.owner = owner;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
		this.vinNumber = vinNumber;
		this.packageV = packageV;
		this.packageDetail = packageDetail;
	}

	public double getPackageDetail() {
		return packageDetail;
	}

	public void setPackageDetail(double packageDetail) {
		this.packageDetail = packageDetail;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
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
