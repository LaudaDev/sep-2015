package app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class Vehicle implements Serializable {

	
	private static final long serialVersionUID = -1027548365143014756L;
	@NotNull(message = "error.duration.notnull")
	private Integer duration;
	@NotNull(message = "error.model.notnull")
	private String model;
	@NotNull(message = "error.typeVehicle.notnull")
	private String typeVehicle;
	
	private User owner;
	@NotNull(message = "error.productionYear.notnull")
	private Integer productionYear;
	
	@NotNull(message = "error.registrationNumber.notnull")
	private String registrationNumber;
	
	@NotNull(message = "error.vinNumber.notnull")
	private String vinNumber;
	
	@NotNull(message = "error.packageV.notnull")
	private String packageV;
	private Double packageDetail;

	public Vehicle() {
		super();
	}

	public Vehicle(Integer duration, String model, String type, User owner, Integer productionYear,
			String registrationNumber, String vinNumber, String packageV, Double packageDetail) {
		super();
		this.duration = duration;
		this.model = model;
		this.typeVehicle = type;
		this.owner = owner;
		this.productionYear = productionYear;
		this.registrationNumber = registrationNumber;
		this.vinNumber = vinNumber;
		this.packageV = packageV;
		this.packageDetail = packageDetail;
	}

	public Double getPackageDetail() {
		return packageDetail;
	}

	public void setPackageDetail(Double packageDetail) {
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

	public String getTypeVehicle() {
		return typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}


	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Integer getProductionYear() {
		return productionYear;
	}

	public void setProductionYear(Integer productionYear) {
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
		return "VehicleInsurance [duration=" + duration + ", model=" + model + ", type=" + typeVehicle + ", owner="
				+ owner + ", productionYear=" + productionYear + ", registrationNumber=" + registrationNumber
				+ ", vinNumber=" + vinNumber + ", packageV=" + packageV + "]";
	}

}
