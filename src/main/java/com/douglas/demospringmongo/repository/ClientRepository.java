package com.douglas.demospringmongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.douglas.demospringmongo.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer>{

}
