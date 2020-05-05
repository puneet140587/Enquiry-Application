package com.eqap.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eqap.poc.entity.EnquirySource;
import com.eqap.poc.repo.EnquirySourceRepository;

@RestController
public class TestController {

	@Autowired
	EnquirySourceRepository enquirySourceRepository;

	@GetMapping("/test-save-source")
	public String testSaveSource() {
		EnquirySource es = new EnquirySource("Whatsapp University");
		enquirySourceRepository.save(es);
		return "Success";
	}

	@GetMapping("/test-source-list")
	public List<EnquirySource> getAllSources() {
		EnquirySource es = new EnquirySource("Whatsapp University");
		return enquirySourceRepository.findAll();
	}

}
