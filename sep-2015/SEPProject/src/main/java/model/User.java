package model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "users") 
public class User {

	@Id
	private String jmbg;
	
	private String firstName;
	
	private String lastName;
	
	private String passportNum;
	
	private String address;
	
	private String phoneNum;
	
	private String email;
	
	List<String> insurances = new ArrayList<>();
	
	List<String> vehicles = new ArrayList<>();
	
	List<String> realEstates = new ArrayList<>();

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String jmbg, String firstName, String lastName, String passportNum, String address, String phoneNum,
			String email, List<String> insurances, List<String> vehicles, List<String> realEstates) {
		super();
		this.jmbg = jmbg;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passportNum = passportNum;
		this.address = address;
		this.phoneNum = phoneNum;
		this.email = email;
		this.insurances = insurances;
		this.vehicles = vehicles;
		this.realEstates = realEstates;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getInsurances() {
		return insurances;
	}

	public void setInsurances(List<String> insurances) {
		this.insurances = insurances;
	}

	public List<String> getVehicles() {
		return vehicles;
	}

	public void setVehicles(List<String> vehicles) {
		this.vehicles = vehicles;
	}

	public List<String> getRealEstates() {
		return realEstates;
	}

	public void setRealEstates(List<String> realEstates) {
		this.realEstates = realEstates;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
	        return false;
	    if (!(obj instanceof User))
	        return false;
	    User other = (User) obj;
	    return jmbg == null ? false : jmbg.equals(other.jmbg);//Compare jmbg if null falseF
	}
	
	@Override
	public int hashCode() {
	    return jmbg == null ? 0 : jmbg.hashCode();
	}
	
}
