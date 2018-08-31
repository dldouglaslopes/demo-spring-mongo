package com.douglas.demospringmongo.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ConfigBook {	
	
	@Id
	private String id;	
	private String name;
	private Address address;	
	private User user;
	private List<Contact> contacts = new ArrayList<>();
	private List<IPAddress> ipAddresses = new ArrayList<>();
	private List<CostCenter> costCenters = new ArrayList<>();
	private List<BranchMap> branchMaps = new ArrayList<>();
	private List<Queue> queues = new ArrayList<>();
	
	public ConfigBook() {}

	public ConfigBook(
			String id,
			String name,
			Address address,
			User user,
			List<Contact> contacts,
			List<IPAddress> ipAddresses,
			List<CostCenter> costCenters,
			List<BranchMap> branchMaps,
			List<Queue> queues) {
		
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contacts = contacts;		
		this.ipAddresses = ipAddresses;
		this.costCenters = costCenters;
		this.branchMaps = branchMaps;
		this.queues = queues;
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
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public List<IPAddress> getIpAddresses() {
		return ipAddresses;
	}

	public void setIpAddresses(List<IPAddress> ipAddresses) {
		this.ipAddresses = ipAddresses;
	}

	public List<CostCenter> getCostCenters() {
		return costCenters;
	}

	public void setCostCenters(List<CostCenter> costCenters) {
		this.costCenters = costCenters;
	}

	public List<BranchMap> getBranchMaps() {
		return branchMaps;
	}

	public void setBranchMaps(List<BranchMap> branchMaps) {
		this.branchMaps = branchMaps;
	}

	public List<Queue> getQueues() {
		return queues;
	}

	public void setQueues(List<Queue> queues) {
		this.queues = queues;
	}


}
