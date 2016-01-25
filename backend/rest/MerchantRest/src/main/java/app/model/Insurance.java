package app.model;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Insurance implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3498853990547000424L;
	//travel insurance
	@Id
	private String id;
	private VehicleInsurance vehicle;
	private RealestateInsurance realEstate;
	
	@NotNull(message = "error.travelInsurance.notnull")
	private TravelInsurance travel;
	
	@NotNull(message = "error.amountToPay.notnull")
	@Min(1)
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
