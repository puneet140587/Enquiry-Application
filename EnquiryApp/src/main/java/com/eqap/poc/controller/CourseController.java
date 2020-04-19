package com.eqap.poc.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.eqap.poc.entity.Course;
import com.eqap.poc.entity.Institute;
import com.eqap.poc.repo.CourseRepository;
import com.eqap.poc.repo.InstituteRepository;

@Controller
public class CourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	InstituteRepository instituteRepository;
	
	@GetMapping("/courses")
	public String form(Model m) {
		m.addAttribute("cmd", new Course());
		return "/courses"; 
	}
	
	@GetMapping("/save-course")
	public String save(@ModelAttribute Course c) {
		courseRepository.save(c);
		return "redirect:/courses"; 
	}
	
	@ModelAttribute("instituteList")
	public List<Institute> getInstituteList() {
		//return instituteRepository.findAll();
		return instituteRepository.getCustomInstituteList();
	}
	
	@ModelAttribute("courseList")
	public List<Map<String,Object>> getCourseList() {
		//return courseRepository.findAll();
		 return courseRepository.getCourses(); 
	}
	

}
