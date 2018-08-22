package com.douglas.demospringmongo.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.demospringmongo.domain.Address;
import com.douglas.demospringmongo.repository.AddressRepository;

@Service
public class AddressService {
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Transactional
	public Address insert(Address address) {
		address.setId(null);
		address = addressRepository.save(address);		
		
		return address;
	}

	public Address update(Address address) {
		Address newAddress = find(address.getId());
		
		newAddress.setName(address.getName());
		newAddress.setNumber(address.getNumber());
		newAddress.setCity(address.getCity());
		newAddress.setState(address.getState());
		newAddress.setType(address.getType());
		newAddress.setZipCode(address.getZipCode());
		newAddress.setClient(address.getClient());
		
		return addressRepository.save(newAddress);
	}

	private Address find(Integer id) {
		Optional<Address> address = addressRepository.findById(id);
		
		return address.orElse(null);
	}

}
