package com.douglas.demospringmongo.domain;

public class CostCenter {
	
	private String name;
	private String description;
	
	public CostCenter() {}
	
	public CostCenter(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
