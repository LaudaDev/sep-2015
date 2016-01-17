package app.model;

import java.io.Serializable;

import app.repository.commons.Common;

public class RealestateInsurance extends Common implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5348136306628433221L;
		//real estate insurance -- "re"

		private int duration;
		private double size;
		private double age;
		private double estimatedValue;
		private User owner; // name + surname
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
			return "RealestateInsurance [ duration=" + duration + ", size=" + size + ", age=" + age
					+ ", estimatedValue=" + estimatedValue + ", owner=" + owner + ", packageRE=" + packageRE + "]";
		}


}
