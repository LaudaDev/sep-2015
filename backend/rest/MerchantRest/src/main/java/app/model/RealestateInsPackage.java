package app.model;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class RealestateInsPackage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2346958759788063003L;
	@Id
	private String id;
	
	@NotNull(message = "error.name.notnull")
	private String name;
	
	@NotNull(message = "error.coefficient.notnull")
	private Double coefficient;
	
	public RealestateInsPackage() {
		super();
	}
	
	public RealestateInsPackage(String name, Double coefficient) {
		super();
		this.name = name;
		this.coefficient = coefficient;
	}

	
	
	public Double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(Double coefficient) {
		this.coefficient = coefficient;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "RealEstateInsPackage [id=" + id + ", name=" + name + "]";
	}
	
	
}
