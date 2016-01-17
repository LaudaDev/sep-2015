package app.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import app.repository.commons.Common;

@Document
public class Insurance extends Common implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3498853990547000424L;
	//travel insurance
	@Id
	private String id;
	private VehicleInsurance vehicle;
	private RealestateInsurance realEstate;
	private TravelInsurance travel;
	private double amountToPay;

	public Insurance() {
		super();		
	}
	
	public Insurance(VehicleInsurance vehicleIns, RealestateInsurance realstateIns, TravelInsurance travelIns,
			double totalPrice) {
		super();
		this.vehicle = vehicleIns;
		this.realEstate = realstateIns;
		this.travel = travelIns;
		this.amountToPay = totalPrice;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public VehicleInsurance getVehicle() {
		return vehicle;
	}

	public void setVehicle(VehicleInsurance vehicle) {
		this.vehicle = vehicle;
	}

	public RealestateInsurance getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealestateInsurance realEstate) {
		this.realEstate = realEstate;
	}

	public TravelInsurance getTravel() {
		return travel;
	}

	public void setTravel(TravelInsurance travel) {
		this.travel = travel;
	}

	public double getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", vehicleIns=" + vehicle + ", realstateIns=" + realEstate + ", travelIns="
				+ travel + ", totalPrice=" + amountToPay + "]";
	}
}
