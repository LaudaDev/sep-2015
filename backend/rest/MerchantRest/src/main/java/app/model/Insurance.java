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
	private BigDecimal amountToPay;

	@NotNull(message = "error.travelInsurance.notnull")
	private Travel travel;

	@NotNull(message = "error.amountToPay.notnull")
	@Min(1)

	public Insurance() {
		super();
	}

	public Insurance(Vehicle vehicleIns, RealEstate realstateIns, Travel travel, BigDecimal totalPrice) {
		super();
		this.vehicle = vehicleIns;
		this.realEstate = realstateIns;
		this.travel = travel;
		this.amountToPay = totalPrice;
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
