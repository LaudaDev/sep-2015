package model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditCards")
public class CreditCard {

	@Id
	private String pan;

	private String securityCode;

	private String cardholderName;

	private Date expireDate; // razmisliti da li mozda koristiti JodaDate

	private double amountOnCard;

	private User owner;

	public CreditCard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CreditCard(String pan, String securityCode, String cardholderName, Date expireDate, double amountOnCard,
			User owner) {
		super();
		this.pan = pan;
		this.securityCode = securityCode;
		this.cardholderName = cardholderName;
		this.expireDate = expireDate;
		this.amountOnCard = amountOnCard;
		this.owner = owner;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public double getAmountOnCard() {
		return amountOnCard;
	}

	public void setAmountOnCard(double amountOnCard) {
		this.amountOnCard = amountOnCard;
	}

	public User getCardOwner() {
		return owner;
	}

	public void setCardOwner(User cardOwner) {
		this.owner = cardOwner;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof CreditCard))
			return false;
		CreditCard other = (CreditCard) obj;
		return pan == null ? false : pan.equals(other.pan);// Compare pan if null falseF
	}

	@Override
	public int hashCode() {
		return pan == null ? 0 : pan.hashCode();
	}

}
