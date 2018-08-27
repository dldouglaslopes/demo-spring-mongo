package com.douglas.demospringmongo.domain;

public class Address {
	private String name;
	private String type;
	private String number;
	private String city;
	private String state;
	private String zipCode;
	
	public Address() {}

	public Address(
			String name, 
			String type, 
			String number, 
			String city, 
			String state, 
			String zipCode) {
		
		super();
		this.name = name;
		this.type = type;
		this.number = number;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}	
}
