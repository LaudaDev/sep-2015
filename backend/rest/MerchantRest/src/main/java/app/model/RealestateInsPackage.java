package app.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import app.repository.commons.Common;

@Document
public class RealestateInsPackage extends Common implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2346958759788063003L;
	@Id
	private String id;
	private String name;
	private int coefficient;
	
	public RealestateInsPackage() {
		super();
	}
	
	public RealestateInsPackage(String name, int coefficient) {
		super();
		this.name = name;
		this.coefficient = coefficient;
	}

	
	
	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
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
