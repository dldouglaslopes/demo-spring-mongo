package com.douglas.demospringmongo.domain;

import java.util.List;

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
	
	public String toSql(List<CostCenter> costCenters) {
		String total = "";
		
		for (int i = 0; i < costCenters.size(); i++) {
			String sql = "INSERT INTO cost_center (name, description) "
						+ "VALUES (\"" 
						+ costCenters.get(i).getName()
						+ "\",\"" 
						+ costCenters.get(i).getDescription() 
						+ "\");\n";
			
			total += sql;
		}		
	
		return total;
	}
}

