package com.douglas.demospringmongo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.demospringmongo.config.MongoConfig;
import com.douglas.demospringmongo.domain.Contact;
import com.douglas.demospringmongo.repository.ContactRepository;
import com.mongodb.client.MongoCollection;

@Service
public class ContactService {
	
	private MongoCollection<Document> collectionContact;
	
	@Autowired
	private ContactRepository contactRepository;
	@Autowired
	private ClientService clientService;
	
	public ContactService() {
		this.collectionContact = new MongoConfig().getCollection();
	}
	
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
		
		Document contactDoc = new Document("contact", contact); 
		collectionContact.insertOne(contactDoc);
		
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
