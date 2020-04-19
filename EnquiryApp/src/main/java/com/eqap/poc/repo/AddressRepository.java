package com.eqap.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eqap.poc.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
