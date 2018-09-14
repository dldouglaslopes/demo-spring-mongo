package com.douglas.demospringmongo.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.douglas.demospringmongo.domain.ConfigBook;
import com.douglas.demospringmongo.domain.CostCenter;
import com.douglas.demospringmongo.domain.Queue;
import com.douglas.demospringmongo.domain.User;
import com.douglas.demospringmongo.repository.ConfigBookRepository;


@RestController
@RequestMapping(value = "/configBooks")
public class ConfigBookController {
	
	@Autowired
	ConfigBookRepository configBookRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public List<ConfigBook> findAll(){
		return this.configBookRepository.findAll();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Optional<ConfigBook> findById(@PathVariable String id) {
		return this.configBookRepository.findById(id);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ConfigBook save(@RequestBody ConfigBook configBook) {
		return this.configBookRepository.save(configBook);
	}
	
	@RequestMapping(value="/{id}.sql", method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> download(@PathVariable String id) throws IOException {
		 
		Optional<ConfigBook> configBook = configBookRepository.findById(id);
		
		String sql = new CostCenter().toSql(configBook.get().getCostCenters()) 
					+ new Queue().toSql(configBook.get().getQueues())
					+ new User().toSql(configBook.get().getUser());
		
		File file = new File("query.sql");
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(sql);
		writer.close();
		
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        
		InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
		
		return ResponseEntity.ok()
				            .headers(headers)
				            .contentLength(file.length())
				            .contentType(MediaType.APPLICATION_PDF)
				            .body(resource);
	}

	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public void deleteById(@PathVariable String id) {
		this.configBookRepository.deleteById(id);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ConfigBook update(@RequestBody ConfigBook configBook, 
							@PathVariable String id) {
		
		return this.configBookRepository.findById(id)
										.map(c -> this.configBookRepository.save(configBook))
										.orElseThrow(IllegalStateException::new);
	}
}
