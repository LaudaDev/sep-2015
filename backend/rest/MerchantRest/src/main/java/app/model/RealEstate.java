package app.model;

import java.io.Serializable;

public class RealEstate implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5348136306628433221L;
	// real estate insurance -- "re"
	private Integer duration;
	private Double sizeRE;
	private Double age;
	private Double estimatedValue;
	private User owner; 
	private String packageRE;

	public RealEstate() {
		super();
	}

	public RealEstate(Integer duration, Double size, Double age, Double estimatedValue, User owner, String packageRE) {
		super();
		this.duration = duration;
		this.sizeRE = size;
		this.age = age;
		this.estimatedValue = estimatedValue;
		this.owner = owner;
		this.packageRE = packageRE;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Double getSizeRE() {
		return sizeRE;
	}

	public void setSizeRE(Double sizeRE) {
		this.sizeRE = sizeRE;
	}

	public Double getAge() {
		return age;
	}

	public void setAge(Double age) {
		this.age = age;
	}

	public Double getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(Double estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getPackageRE() {
		return packageRE;
	}

	public void setPackageRE(String packageRE) {
		this.packageRE = packageRE;
	}

	@Override
	public String toString() {
		return "RealestateInsurance [ duration=" + duration + ", size=" + sizeRE + ", age=" + age + ", estimatedValue="
				+ estimatedValue + ", owner=" + owner + ", packageRE=" + packageRE + "]";
	}

}
