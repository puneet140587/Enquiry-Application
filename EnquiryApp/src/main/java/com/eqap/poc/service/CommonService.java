package com.eqap.poc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eqap.poc.entity.Institute;
import com.eqap.poc.repo.AddressRepository;
import com.eqap.poc.repo.ContactRepository;
import com.eqap.poc.repo.InstituteRepository;

@Service  
public class CommonService {
	
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	ContactRepository contactRepository;
	
	@Autowired
	InstituteRepository instituteRepository;
	
	
	
	@Transactional
	public void saveInstitute(Institute inst) {
		//Address
		addressRepository.save(inst.getContact().getPermanentAddress());
		//Contact
		contactRepository.save(inst.getContact());
		//Institute
		instituteRepository.save(inst);
		
		
	}

}
