package app.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Sport {

	@Id
	private String id;
	
	@NotNull(message = "error.name.notnull")
	private String name;
	
	@NotNull(message = "error.coefficient.notnull")
	private int coefficient;

	public Sport() {
		super();
	}

	public Sport(String name, int coefficient) {
		super();
		this.name = name;
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

	public int getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(int coefficient) {
		this.coefficient = coefficient;
	}

	@Override
	public String toString() {
		return "Sport [id=" + id + ", name=" + name + ",coefficient=  "+ coefficient +"]";
	}

}
