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
	private List<Contact> contacts = new ArrayList<>();
	private List<IPAddress> ipAddresses = new ArrayList<>();
	
	public ConfigBook() {}

	public ConfigBook(
			String id,
			String name,
			Address address,
			List<Contact> contacts,
			List<IPAddress> ipAddresses) {
		
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contacts = contacts;		
		this.ipAddresses = ipAddresses;
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


}
