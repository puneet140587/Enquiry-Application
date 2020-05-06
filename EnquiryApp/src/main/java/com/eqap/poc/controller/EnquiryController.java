package com.eqap.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eqap.poc.dto.EnquiryCommand;
import com.eqap.poc.entity.Course;
import com.eqap.poc.entity.EnquirySource;
import com.eqap.poc.entity.Institute;
import com.eqap.poc.repo.CourseRepository;
import com.eqap.poc.repo.EnquiryRepository;
import com.eqap.poc.repo.EnquirySourceRepository;
import com.eqap.poc.repo.FollowupRepository;
import com.eqap.poc.repo.InstituteRepository;
import com.eqap.poc.service.CommonService;

@Controller
public class EnquiryController {

	@Autowired
	InstituteRepository instituteRepository;

	@Autowired
	EnquirySourceRepository enquirySourceRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	CommonService commonService;

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	FollowupRepository followupRepository;

	@GetMapping("/")
	public String index(Model m) {
		m.addAttribute("cmd", new EnquiryCommand());
		return "/index";
	}

	@GetMapping("/save-enquiry")
	public String save(@ModelAttribute EnquiryCommand cmd) {
		commonService.saveEnquiry(cmd);
		return "redirect:/enq-list";
	}

	@GetMapping("/enq-list")
	public String enquiryList(@RequestParam(required = false) Long instId, Model m) {
		m.addAttribute("enquiryList", enquiryRepository.getEnquiryDTOList(instId));
		return "/enq-list";
	}

	// Just for Testing Purpose
	@GetMapping("/test-get-inst-ids")
	@ResponseBody
	public String getInstIds() {
		return enquiryRepository.findAllIds();
	}

	@ModelAttribute("instituteList")
	public List<Institute> getInstList() {
		return instituteRepository.getCustomInstituteList();
	}

	@ModelAttribute("sourceList")
	public List<EnquirySource> getSourceList() {
		return enquirySourceRepository.findAll();
	}

	@GetMapping("/get-courses")
	@ResponseBody
	public List<Course> getCourseByInstituteId(@RequestParam Long instId) {
		return courseRepository.findCourseListByInstitute_instituteId(instId);
	}

	@PostMapping("/save-followup")
	public String save_Followup(@RequestParam Long enquiryId, @RequestParam String followup,
			@RequestParam(required = false) String go) {
		commonService.saveFollowup(enquiryId, followup);
		if (go != null && go.equals("eview")) {
			return "redirect:/enquiry-detail/" + enquiryId;
		} else {
			return "redirect:/enq-list";
		}

	}

	@GetMapping("/enquiry-detail/{id}")
	public String enquiryDetail(@PathVariable Long id, Model m) {
		m.addAttribute("dataMap", enquiryRepository.getEnquiryDetailMap(id));
		m.addAttribute("followupList", followupRepository.getFollowupsByEnquiryId(id));
		return "/enquiry-detail";
	}

	@GetMapping("/enquiry-delete/{id}")
	public String enquiryDelete(@PathVariable Long id) {
		commonService.deleteEnquiry(id);
		return "redirect:/enq-list";
	}

}
