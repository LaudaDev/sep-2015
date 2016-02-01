package app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User implements Serializable {

	
	private static final long serialVersionUID = -2312800478329505351L;
	
	@NotNull(message = "error.name.notnull")
	private String name;

	@NotNull(message = "error.surname.notnull")
	private String surname;

	@NotNull(message = "error.jmbg.notnull")
	private String jmbg;

	@NotNull(message = "error.phoneNum.notnull")
	private String phoneNum;

	@NotNull(message = "error.address.notnull")
	private String address;

	@NotNull(message = "error.passportNum.notnull")
	private String passportNum;

	private String email;

	public User() {
		super();
	}

	public User(String name, String surname, String jmbg, String phoneNum, String address,
			String passportNum, String email) {
		super();

		this.name = name;
		this.surname = surname;
		this.jmbg = jmbg;
		this.phoneNum = phoneNum;
		this.address = address;
		this.passportNum = passportNum;
		this.email = email;
	}
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

}
