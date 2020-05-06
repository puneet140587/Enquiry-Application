package com.eqap.poc.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eqap.poc.dto.EnquiryCommand;
import com.eqap.poc.entity.Address;
import com.eqap.poc.entity.Contact;
import com.eqap.poc.entity.Enquiry;
import com.eqap.poc.entity.EnquiryCourse;
import com.eqap.poc.entity.Followup;
import com.eqap.poc.entity.Institute;
import com.eqap.poc.repo.AddressRepository;
import com.eqap.poc.repo.ContactRepository;
import com.eqap.poc.repo.CourseRepository;
import com.eqap.poc.repo.EnquiryCourseRepository;
import com.eqap.poc.repo.EnquiryRepository;
import com.eqap.poc.repo.EnquirySourceRepository;
import com.eqap.poc.repo.FollowupRepository;
import com.eqap.poc.repo.InstituteRepository;

@Service
public class CommonService {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	ContactRepository contactRepository;

	@Autowired
	InstituteRepository instituteRepository;

	@Autowired
	EnquirySourceRepository enquirySourceRepository;

	@Autowired
	EnquiryRepository enquiryRepository;

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	EnquiryCourseRepository enquiryCourseRepository;

	@Autowired
	FollowupRepository followupRepository;

	@Transactional
	public void saveInstitute(Institute inst) {
		// Address
		addressRepository.save(inst.getContact().getPermanentAddress());
		// Contact
		contactRepository.save(inst.getContact());
		// Institute
		instituteRepository.save(inst);
	}

	@Transactional
	public void saveEnquiry(EnquiryCommand cmd) {

		Address a = cmd.getEnquiry().getContact().getPermanentAddress();
		addressRepository.save(a);

		Contact c = cmd.getEnquiry().getContact();
		contactRepository.save(c);

		Enquiry e = cmd.getEnquiry();
		e.setInstitute(instituteRepository.getOne(e.getInstitute().getInstituteId()));
		e.setEnquirySource(enquirySourceRepository.getOne(e.getEnquirySource().getEnquirySourceId()));
		Date d = new Date();
		e.setDoe(d);
		e.setLastUpdate(d);
		enquiryRepository.save(e);

		Long[] courseIds = cmd.getCourses();
		for (Long courseId : courseIds) {
			EnquiryCourse ec = new EnquiryCourse();
			ec.setEnquiry(e);
			ec.setCourse(courseRepository.getOne(courseId));
			enquiryCourseRepository.save(ec);
		}

	}

	@Transactional
	public void saveFollowup(Long enquiryId, String detail) {
		Followup fo = new Followup();
		fo.setDetail(detail);
		fo.setEnquiry(enquiryRepository.getOne(enquiryId)); // For fetching Foreign Key reference without hitting
															// database
		fo.setDoe(new Date());
		followupRepository.save(fo);
	}

	@Transactional
	public void deleteEnquiry(Long enquiryId) {
		Enquiry enquiry = enquiryRepository.findById(enquiryId).get();
		Contact contact = enquiry.getContact();
		// Contact need to be delete manually
		contactRepository.delete(contact);
		// Now, only Enquiry can be deleted
		enquiryRepository.delete(enquiry);

	}

}
