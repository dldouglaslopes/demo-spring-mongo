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

import com.douglas.demospringmongo.domain.Client;
import com.douglas.demospringmongo.domain.Contact;
import com.douglas.demospringmongo.dto.ContactDTO;
import com.douglas.demospringmongo.service.ClientService;
import com.douglas.demospringmongo.service.ContactService;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {
	
	@Autowired
	private ContactService contactService;
	@Autowired
	private ClientService clientService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> findAll() {
		List<Contact> contacts = contactService.findAll();
		
		return ResponseEntity.ok().body(contacts);
	}
		
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Contact> findOne(@PathVariable Integer id) {
		Contact contact = contactService.findOne(id);
		
		return ResponseEntity.ok().body(contact);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Contact> insert(@RequestBody @Valid ContactDTO contactDTO) {
		
		Client client = clientService.findOne(contactDTO.getClient());
		
		Contact contact = new Contact(
				null, 
				contactDTO.getName(), 
				contactDTO.getPhone(), 
				client);
		
		contact = contactService.insert(contact);		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(contact.getId()).toUri();		
						
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		contactService.deleteOne(id);		
	
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@PathVariable Integer id, 
										@RequestBody @Valid ContactDTO contactDTO) {
		
		Contact contact = contactService.findOne(id);
		
		Contact newContact = new Contact(
				contact.getId(), 
				contactDTO.getName(),
				contactDTO.getPhone(),
				contact.getClient());
		
		contact = contactService.update(newContact);		
		
		return ResponseEntity.noContent().build();
	}		
}
