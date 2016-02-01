package app.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

public class InsuredAmount {

	@Id
	private String id;
	
	@NotNull(message = "error.amount.notnull")
	private BigDecimal amount;
	
	@NotNull(message = "error.coefficient.notnull")
	private Double coefficient;
	
	
	public InsuredAmount() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public InsuredAmount(String id, BigDecimal amount, Double coefficient) {
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
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Double getCoefficient() {
		return coefficient;
	}
	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}
	@Override
	public String toString() {
		return "InsuredAmount [id=" + id + ", amount=" + amount + ", coefficient=" + coefficient + "]";
	}
	
	
}
