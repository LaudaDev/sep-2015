package app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class RealestateInsurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5348136306628433221L;
	
	@NotNull(message = "error.duration.notnull")
	private Integer duration;
	
	@NotNull(message = "error.size.notnull")
	private Double size;
	
	@NotNull(message = "error.age.notnull")
	private Double age;
	
	@NotNull(message = "error.estimatedValue.notnull")
	private Double estimatedValue;
	
	@NotNull(message = "error.owner.notnull")
	private User owner; // name + surname
	
	@NotNull(message = "error.packageRE.notnull")
	private String packageRE;

	public RealestateInsurance() {
		super();
	}

	public RealestateInsurance(Integer duration, Double size, Double age, Double estimatedValue, User owner,
			String packageRE) {
		super();
		this.duration = duration;
		this.size = size;
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

	public Double getSize() {
		return size;
	}

	public void setSize(Double size) {
		this.size = size;
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
		return "RealestateInsurance [ duration=" + duration + ", size=" + size + ", age=" + age + ", estimatedValue="
				+ estimatedValue + ", owner=" + owner + ", packageRE=" + packageRE + "]";
	}

}
