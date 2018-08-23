package com.douglas.demospringmongo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.demospringmongo.domain.Contact;
import com.douglas.demospringmongo.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository contactRepository;
	
	public Contact findOne(Integer id) {
		Optional<Contact> contact = contactRepository.findById(id);
		
		return contact.orElse(null);
	}
	
	public List<Contact> findAll() {
		List<Contact> contacts = contactRepository.findAll();
		
		return contacts;
	}
	
	@Transactional
	public Contact insert(Contact contact) {
		contact.setId(null);
		contact = contactRepository.save(contact);		
		
		return contact;
	}

	public Contact update(Contact contact) {
		Contact newContact = findOne(contact.getId());
		
		newContact.setName(contact.getName());
		newContact.setPhone(contact.getPhone());
		newContact.setClient(contact.getClient());
		
		return contactRepository.save(newContact);
	}

	public void deleteOne(Integer id) {
		if (findOne(id) != null) {
			contactRepository.deleteById(id);
		}
	}
}
