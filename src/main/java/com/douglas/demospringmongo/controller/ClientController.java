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
import com.douglas.demospringmongo.dto.ClientDTO;
import com.douglas.demospringmongo.service.AddressService;
import com.douglas.demospringmongo.service.ClientService;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	@Autowired
	private AddressService addressService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Client>> findAll() {
		List<Client> clients = clientService.findAll();
		
		return ResponseEntity.ok().body(clients);
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Client> findOne(@PathVariable Integer id) {
		Client client = clientService.findOne(id);
		
		return ResponseEntity.ok().body(client);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Client> insert(@RequestBody @Valid ClientDTO clientDTO) {
		
		Client client = new Client(
				null, 
				clientDTO.getName());
		
		client = clientService.insert(client);
		
		Address address = new Address(
				null, 
				clientDTO.getAddress(), 
				clientDTO.getType(), 
				clientDTO.getNumber(), 
				clientDTO.getCity(),
				clientDTO.getState(), 
				clientDTO.getZipCode(),
				client);
		
		client.setAddress(address);		
		address = addressService.insert(address);		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(client.getId()).toUri();		
				ResponseEntity.created(uri).build();
						
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		clientService.deleteOne(id);		
	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, 
										@RequestBody @Valid ClientDTO clientDTO) {
		
		Client client = clientService.findOne(id);
		
		Client newClient = new Client(
				client.getId(), 
				clientDTO.getName());
		
		client = clientService.update(newClient);		
		
		return ResponseEntity.noContent().build();
	}	
}
