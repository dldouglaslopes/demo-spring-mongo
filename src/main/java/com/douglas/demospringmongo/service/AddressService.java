package com.douglas.demospringmongo.service;

import java.util.List;
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
	
	public Address findOne(Integer id) {
		Optional<Address> address = addressRepository.findById(id);
		
		return address.orElse(null);
	}
	
	public List<Address> findAll() {
		List<Address> addresses = addressRepository.findAll();
		
		return addresses;
	}
	
	@Transactional
	public Address insert(Address address) {
		address.setId(null);
		address = addressRepository.save(address);		
		
		return address;
	}

	public Address update(Address address) {
		Address newAddress = findOne(address.getId());
		
		newAddress.setName(address.getName());
		newAddress.setNumber(address.getNumber());
		newAddress.setCity(address.getCity());
		newAddress.setState(address.getState());
		newAddress.setType(address.getType());
		newAddress.setZipCode(address.getZipCode());
		newAddress.setClient(address.getClient());
		
		return addressRepository.save(newAddress);
	}

	public void deleteOne(Integer id) {
		if (findOne(id) != null) {
			addressRepository.deleteById(id);
		}
	}
}
