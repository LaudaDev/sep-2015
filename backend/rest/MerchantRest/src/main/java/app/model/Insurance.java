package app.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Insurance implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3498853990547000424L;
	// travel insurance
	@Id
	private String id;

	private Vehicle vehicle;

	private RealEstate realEstate;

	@NotNull(message = "error.amountToPay.notnull")
	@Min(1)
	private BigDecimal amountToPay;

	@NotNull(message = "error.travelInsurance.notnull")
	private Travel travel;

	private User carrier;

	public Insurance() {
		super();
	}

	public Insurance(String id, Vehicle vehicle, RealEstate realEstate, BigDecimal amountToPay, Travel travel,
			User carrier) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.realEstate = realEstate;
		this.amountToPay = amountToPay;
		this.travel = travel;
		this.carrier = carrier;
	}

	public User getCarrier() {
		return carrier;
	}

	public void setCarrier(User carrier) {
		this.carrier = carrier;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public RealEstate getRealEstate() {
		return realEstate;
	}

	public void setRealEstate(RealEstate realEstate) {
		this.realEstate = realEstate;
	}

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public BigDecimal getAmountToPay() {
		return amountToPay;
	}

	public void setAmountToPay(BigDecimal amountToPay) {
		this.amountToPay = amountToPay;
	}

	@Override
	public String toString() {
		return "Insurance [id=" + id + ", vehicleIns=" + vehicle + ", realstateIns=" + realEstate + ", travelIns="
				+ travel + ", totalPrice=" + amountToPay + "]";
	}
}
