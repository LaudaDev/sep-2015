package app.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class InsuredAmount {

	@Id
	private String id;
	
	@NotNull(message = "error.amount.notnull")
	private double amount;
	
	@NotNull(message = "error.coefficient.notnull")
	private double coefficient;
	
	
	public InsuredAmount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public InsuredAmount(String id, double amount, double coefficient) {
		super();
		this.id = id;
		this.amount = amount;
		this.coefficient = coefficient;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}
	@Override
	public String toString() {
		return "InsuredAmount [id=" + id + ", amount=" + amount + ", coefficient=" + coefficient + "]";
	}
	
	
}
