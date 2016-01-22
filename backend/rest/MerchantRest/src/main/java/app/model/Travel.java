package app.model;

import java.io.Serializable;
import java.util.List;

public class Travel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2158996423429099545L;
	private List<User> users;
	private int duration; // in days
	private String region; // foreign key
	private int less; // users younger than 18
	private int between;// users between 18 and 65
	private int over; // users older than 65
	private boolean doesSport; // foreign key
	private String sport;
	private int numOfPersons;// less + between + over
	private double insuredAmount;

	public Travel() {
		super();
	}

	public Travel(List<User> users, int duration, String region, int less, int between, int over, boolean doesSport,
			String sport, int numOfPersons, double insuredAmount) {
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
		this.insuredAmount = insuredAmount;
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

	public double getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(double insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	@Override
	public String toString() {
		return "TravelInsurance [users=" + users + ", duration=" + duration + ", region=" + region + ", less=" + less
				+ ", between=" + between + ", over=" + over + ", doesSport=" + doesSport + ", sport=" + sport
				+ ", numOfPersons=" + numOfPersons + ", amount=" + insuredAmount + "]";
	}

}
