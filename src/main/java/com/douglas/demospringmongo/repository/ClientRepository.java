package com.douglas.demospringmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.douglas.demospringmongo.domain.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, String>{

}
