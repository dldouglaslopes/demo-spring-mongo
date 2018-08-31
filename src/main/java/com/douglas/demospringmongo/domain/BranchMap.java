package com.douglas.demospringmongo.domain;

public class BranchMap {
	
	private String branch;
	private String ddr;
	private String name;
	private String context;
	private CostCenter costCenter;
	private String typeEndpoint;
	private String password;
	
	public BranchMap() {}
	
	public BranchMap(String branch, String ddr, String name, String context, CostCenter costCenter, String typeEndpoint,
			String password) {
		super();
		this.branch = branch;
		this.ddr = ddr;
		this.name = name;
		this.context = context;
		this.costCenter = costCenter;
		this.typeEndpoint = typeEndpoint;
		this.password = password;
	}
	
	public String getBranch() {
		return branch;
	}
	
	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String getDdr() {
		return ddr;
	}
	
	public void setDdr(String ddr) {
		this.ddr = ddr;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getContext() {
		return context;
	}
	
	public void setContext(String context) {
		this.context = context;
	}
	
	public CostCenter getCostCenter() {
		return costCenter;
	}
	
	public void setCostCenter(CostCenter costCenter) {
		this.costCenter = costCenter;
	}
	
	public String getTypeEndpoint() {
		return typeEndpoint;
	}
	
	public void setTypeEndpoint(String typeEndpoint) {
		this.typeEndpoint = typeEndpoint;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
