package com.douglas.demospringmongo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.demospringmongo.domain.Client;
import com.douglas.demospringmongo.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;

	public List<Client> findAll() {
		List<Client> clients = clientRepository.findAll();
		
		return clients;
	}
	
	public Client findOne(Integer id) {
		Optional<Client> client = clientRepository.findById(id);
		
		return client.orElse(null);
	}

	@Transactional
	public Client insert(Client client) {
		client.setId(null);
		client = clientRepository.save(client);		
		
		return client;
	}

	public void deleteOne(Integer id) {
		if (findOne(id) != null) {
			clientRepository.deleteById(id);
		}
	}

	public Client update(Client client) {
		Client newClient = findOne(client.getId());
		
		newClient.setName(client.getName());
		newClient.setAddress(client.getAddress());
		
		return clientRepository.save(newClient);
	}

}
