package app.model;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

public class Travel implements Serializable {

	private static final long serialVersionUID = 2158996423429099545L;

	@NotNull(message = "error.users.notnull")
	private List<User> users;
	@NotNull(message = "error.duration.notnull")
	private Integer duration; // in days
	@NotNull(message = "error.region.notnull")
	private String region; // foreign key
	private Integer less; // users younger than 18
	private Integer between;// users between 18 and 65
	private Integer over; // users older than 65
	private boolean doesSport; // foreign key
	private String sport;
	@NotNull(message = "error.numOfPersons.notnull")
	private Integer numOfPersons;// less + between + over
	@NotNull(message = "error.insuredAmount.notnull")
	private Double insuredAmount;

	public Travel() {
		super();
	}

	public Travel(List<User> users, Integer duration, String region, Integer less, Integer between, Integer over,
			boolean doesSport, String sport, Integer numOfPersons, Double insuredAmount) {
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Integer getLess() {
		return less;
	}

	public void setLess(Integer less) {
		this.less = less;
	}

	public Integer getBetween() {
		return between;
	}

	public void setBetween(Integer between) {
		this.between = between;
	}

	public Integer getOver() {
		return over;
	}

	public void setOver(Integer over) {
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

	public Integer getNumOfPersons() {
		return numOfPersons;
	}

	public void setNumOfPersons(Integer numOfPersons) {
		this.numOfPersons = numOfPersons;
	}

	public Double getInsuredAmount() {
		return insuredAmount;
	}

	public void setInsuredAmount(Double insuredAmount) {
		this.insuredAmount = insuredAmount;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Integer getDuration() {
		return duration;
	}

	@Override
	public String toString() {
		return "TravelInsurance [users=" + users + ", duration=" + duration + ", region=" + region + ", less=" + less
				+ ", between=" + between + ", over=" + over + ", doesSport=" + doesSport + ", sport=" + sport
				+ ", numOfPersons=" + numOfPersons + ", amount=" + insuredAmount + "]";
	}

}
