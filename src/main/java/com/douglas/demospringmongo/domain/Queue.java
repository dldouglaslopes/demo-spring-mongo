package com.douglas.demospringmongo.domain;

import java.util.List;

public class Queue {
	
	private String name;
	private String description;
	
	public Queue() {}
	
	public Queue(String name, String description) {
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
	
	public String toSql(List<Queue> queues) {
		String total = "";
		
		for (int i = 0; i < queues.size(); i++) {
			String sql = "INSERT INTO queue (name, description) "
						+ "VALUES (\"" 
						+ queues.get(i).getName()
						+ "\",\"" 
						+ queues.get(i).getDescription() 
						+ "\");\n";
			
			total += sql;
		}		
	
		return total;
	}
}
