package com.douglas.demospringmongo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.demospringmongo.domain.ConfigBook;
import com.douglas.demospringmongo.repository.ConfigBookRepository;


@RestController
@RequestMapping(value = "/clients")
public class ClientController {
	
	@Autowired
	ConfigBookRepository clientRepository;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public List<ConfigBook> list(){
		return this.clientRepository.findAll();
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ConfigBook save(@RequestBody ConfigBook client) {
		return this.clientRepository.save(client);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public Optional<ConfigBook> findById(@PathVariable String id) {
		return this.clientRepository.findById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		this.clientRepository.deleteById(id);
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ConfigBook update(@RequestBody ConfigBook client, @PathVariable String id) {
		return this.clientRepository.findById(id).map(c -> this.clientRepository.save(client)).orElseThrow(IllegalStateException::new);
	}
}
