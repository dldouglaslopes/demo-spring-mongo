package com.douglas.demospringmongo.dto;

import java.util.ArrayList;
import java.util.List;

import com.douglas.demospringmongo.domain.Address;
import com.douglas.demospringmongo.domain.Contact;

public class ClientDTO {
	
	private String name;
	private Address address;
	private List<Contact> contacts = new ArrayList<>();
	
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
