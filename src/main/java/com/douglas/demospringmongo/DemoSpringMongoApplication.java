package com.douglas.demospringmongo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.douglas.demospringmongo.config.MongoConfig;
import com.douglas.demospringmongo.domain.Address;
import com.douglas.demospringmongo.domain.Client;
import com.douglas.demospringmongo.domain.Contact;
import com.douglas.demospringmongo.repository.AddressRepository;
import com.douglas.demospringmongo.repository.ClientRepository;
import com.douglas.demospringmongo.repository.ContactRepository;

@SpringBootApplication
public class DemoSpringMongoApplication implements CommandLineRunner{
	
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private ContactRepository contactRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoSpringMongoApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		MongoConfig config = new MongoConfig();
		
		Client client = new Client(null, "teste");		
		clientRepository.saveAll(Arrays.asList(client));

		Address address = new Address(null, "name", "type", "52", "city", "state", "zipCode", client);
		client.setAddress(address);		
		addressRepository.saveAll(Arrays.asList(address));		
		
		Contact contact = new Contact(null, "name", "phone", client);			
		client.getContacts().addAll(Arrays.asList(contact));		
		contactRepository.saveAll(Arrays.asList(contact));
		
		config.close();
	}
}
