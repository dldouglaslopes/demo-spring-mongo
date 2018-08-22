package com.douglas.demospringmongo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.douglas.demospringmongo.domain.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{

}
