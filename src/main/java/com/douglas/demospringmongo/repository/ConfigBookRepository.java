package com.douglas.demospringmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.douglas.demospringmongo.domain.ConfigBook;

@Repository
public interface ConfigBookRepository extends MongoRepository<ConfigBook, String>{

}
