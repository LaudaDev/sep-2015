package app.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class TravelInsurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2158996423429099545L;

	@NotNull(message = "error.users.notnull")
	private List<User> users;

	@NotNull(message = "error.duration.notnull")
	private int duration; // in days

	@NotNull(message = "error.region.notnull")
	private String region; // foreign key

	@NotNull(message = "error.less.notnull")
	private int less; // users younger than 18

	@NotNull(message = "error.between.notnull")
	private int between;// users between 18 and 65

	@NotNull(message = "error.over.notnull")
	private int over; // users older than 65

	private boolean doesSport; // foreign key
	private String sport;

	@NotNull(message = "error.numOfPersons.notnull")
	private int numOfPersons;// less + between + over
	@NotNull(message = "error.amount.notnull")
	private double amount;

	public TravelInsurance() {
		super();
	}

	public TravelInsurance(List<User> users, int duration, String region, int less, int between, int over,
			boolean doesSport, String sport, int numOfPersons, double amount) {
		super();
		this.users = users;
		this.duration = duration;
		this.region = region;
		this.less = less;
		this.between = between;
		this.over = over;
		this.doesSport = doesSport;
		this.sport = sport;
		this.numOfPersons = numOfPersons;
		this.amount = amount;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public int getLess() {
		return less;
	}

	public void setLess(int less) {
		this.less = less;
	}

	public int getBetween() {
		return between;
	}

	public void setBetween(int between) {
		this.between = between;
	}

	public int getOver() {
		return over;
	}

	public void setOver(int over) {
		this.over = over;
	}

	public boolean isDoesSport() {
		return doesSport;
	}

	public void setDoesSport(boolean doesSport) {
		this.doesSport = doesSport;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public int getNumOfPersons() {
		return numOfPersons;
	}

	public void setNumOfPersons(int numOfPersons) {
		this.numOfPersons = numOfPersons;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "TravelInsurance [users=" + users + ", duration=" + duration + ", region=" + region + ", less=" + less
				+ ", between=" + between + ", over=" + over + ", doesSport=" + doesSport + ", sport=" + sport
				+ ", numOfPersons=" + numOfPersons + ", amount=" + amount + "]";
	}

}
