package com.douglas.demospringmongo.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {	
	
	@Id
	private String id;	
	private String name;
	private Address address;	
	private List<Contact> contacts = new ArrayList<>();
	
	public Client() {}

	public Client(
			String id,
			String name,
			Address address,
			List<Contact> contacts) {
		
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.contacts = contacts;		
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


}
