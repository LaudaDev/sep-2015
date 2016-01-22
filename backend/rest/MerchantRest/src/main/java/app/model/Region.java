package app.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Region{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1921425395458244178L;
	@Id
	private String id;
	private String name;
	private double coefficient;
	
	public Region() {
		super();
	}
	
	public Region(String name, double coefficient) {
		super();
		this.name = name;
		this.coefficient = coefficient;
	}

	//@Override
	public String getId() {
		return id;
	}
	
	//@Override
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	@Override
	public String toString() {
		return "Region [id=" + id + ", name=" + name + ", coefficient=" + coefficient + "]";
	}

	
}
