package com.douglas.demospringmongo.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.douglas.demospringmongo.domain.Address;
import com.douglas.demospringmongo.domain.Client;
import com.douglas.demospringmongo.dto.AddressDTO;
import com.douglas.demospringmongo.service.AddressService;
import com.douglas.demospringmongo.service.ClientService;

@RestController
@RequestMapping(value = "/adresses")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Address> find(@PathVariable Integer id){
		Address address = addressService.findOne(id);
		
		return ResponseEntity.ok().body(address);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Address>> find(){
		List<Address> addresses = addressService.findAll();
		
		return ResponseEntity.ok().body(addresses);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<Address> insert(@Valid @RequestBody AddressDTO addressDTO){
		Client client = clientService.findOne(addressDTO.getId());
		
		Address address = new Address(
									null, 
									addressDTO.getName(), 
									addressDTO.getType(), 
									addressDTO.getNumber(), 
									addressDTO.getCity(), 
									addressDTO.getState(), 
									addressDTO.getZipCode(), 
									client);
				
		address = addressService.insert(address);
	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(address.getId()).toUri();		
						
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		addressService.deleteOne(id);		
		
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public ResponseEntity<Address> update(@PathVariable Integer id, 
											@RequestBody @Valid AddressDTO addressDTO) {
		
		Client client = clientService.findOne(addressDTO.getId());
		
		Address address = addressService.findOne(id);
		
		Address newAddress = new Address(
									address.getId(), 
									addressDTO.getName(), 
									addressDTO.getType(), 
									addressDTO.getNumber(), 
									addressDTO.getCity(), 
									addressDTO.getState(), 
									addressDTO.getZipCode(), 
									client);
				
		address = addressService.update(newAddress);		
		
		return ResponseEntity.noContent().build();
	}
}
