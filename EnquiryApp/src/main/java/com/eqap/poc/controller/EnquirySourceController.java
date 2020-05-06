package com.eqap.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eqap.poc.entity.EnquirySource;
import com.eqap.poc.repo.EnquirySourceRepository;

@Controller
public class EnquirySourceController {

	@Autowired
	EnquirySourceRepository enquirySourceRepository;

	@RequestMapping("/sources")
	public String enquirySources(Model model) {
		EnquirySource cmd = new EnquirySource();
		model.addAttribute("cmd", cmd);
		return "/sources";
	}

	@RequestMapping("/save-enquiry-source")
	public String saveEnquirySources(@ModelAttribute EnquirySource es) {
		enquirySourceRepository.save(es);
		return "redirect:/sources"; // sources.html
	}

	@RequestMapping("/enquiry-source-delete/{id}")
	public String deleteEnquirySources(@PathVariable Long id) {
		enquirySourceRepository.deleteById(id);
		return "redirect:/sources";
	}

	@RequestMapping("/enquiry-source-edit/{id}")
	public String editEnquirySources(@PathVariable Long id, Model model) {
		EnquirySource cmd = enquirySourceRepository.findById(id).get();
		model.addAttribute("cmd", cmd);
		return "/sources";
	}

	@ModelAttribute("enquirySourceList")
	public List<EnquirySource> getEnquirySourceList() {
		return enquirySourceRepository.findAll();
	}
}
