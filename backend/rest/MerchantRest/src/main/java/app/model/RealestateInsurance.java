package app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class RealestateInsurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5348136306628433221L;
	
	@NotNull(message = "error.duration.notnull")
	private int duration;
	
	@NotNull(message = "error.size.notnull")
	private double size;
	
	@NotNull(message = "error.age.notnull")
	private double age;
	
	@NotNull(message = "error.estimatedValue.notnull")
	private double estimatedValue;
	
	@NotNull(message = "error.owner.notnull")
	private User owner; // name + surname
	
	@NotNull(message = "error.packageRE.notnull")
	private String packageRE;

	public RealestateInsurance() {
		super();
	}

	public RealestateInsurance(int duration, double size, double age, double estimatedValue, User owner,
			String packageRE) {
		super();
		this.duration = duration;
		this.size = size;
		this.age = age;
		this.estimatedValue = estimatedValue;
		this.owner = owner;
		this.packageRE = packageRE;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public double getAge() {
		return age;
	}

	public void setAge(double age) {
		this.age = age;
	}

	public double getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(double estimatedValue) {
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
