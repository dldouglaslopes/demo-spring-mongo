package com.douglas.demospringmongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.demospringmongo.domain.Client;
import com.douglas.demospringmongo.repository.ClientRepository;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	ClientRepository clientRepository;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<Client> list(){
		return this.clientRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Client save(@RequestBody Client client) {
		return this.clientRepository.save(client);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Optional<Client> findById(@PathVariable String id) {
		return this.clientRepository.findById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		this.clientRepository.deleteById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public Client update(@RequestBody Client client, @PathVariable String id) {
		return this.clientRepository.findById(id).map(c -> this.clientRepository.save(client)).orElseThrow(IllegalStateException::new);
	}
}
