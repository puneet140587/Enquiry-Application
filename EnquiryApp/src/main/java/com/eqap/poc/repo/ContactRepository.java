package com.eqap.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eqap.poc.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
