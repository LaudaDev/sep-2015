package model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "realEstates")
public class RealEstate {
	
	@Id
	private String id; //bice neki id jer ne znam sta je kljuc za stanove
	
	private double realEstateSize; //povrsina stana 

	private int yearOfProduction;
	
	private double estimatedValue;
	
	private String address;
	
	private User owner;

	public RealEstate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RealEstate(String id, double realEstateSize, int yearOfProduction, double estimatedValue, String address,
			User owner) {
		super();
		this.id = id;
		this.realEstateSize = realEstateSize;
		this.yearOfProduction = yearOfProduction;
		this.estimatedValue = estimatedValue;
		this.address = address;
		this.owner = owner;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getRealEstateSize() {
		return realEstateSize;
	}

	public void setRealEstateSize(double realEstateSize) {
		this.realEstateSize = realEstateSize;
	}

	public int getYearOfProduction() {
		return yearOfProduction;
	}

	public void setYearOfProduction(int yearOfProduction) {
		this.yearOfProduction = yearOfProduction;
	}

	public double getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(double estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public User getRealEstateOwner() {
		return owner;
	}

	public void setRealEstateOwner(User realEstateOwner) {
		this.owner = realEstateOwner;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (obj == null)
	        return false;
	    if (!(obj instanceof User))
	        return false;
	    RealEstate other = (RealEstate) obj;
	    return id == null ? false : id.equals(other.id);//Compare id if null falseF
	}
	
	@Override
	public int hashCode() {
	    return id == null ? 0 : id.hashCode();
	}
}
