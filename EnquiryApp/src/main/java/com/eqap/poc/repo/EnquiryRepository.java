package com.eqap.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eqap.poc.entity.Enquiry;

public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {

}
