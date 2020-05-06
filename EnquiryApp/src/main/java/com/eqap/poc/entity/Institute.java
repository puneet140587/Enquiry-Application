package com.eqap.poc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "institute")
public class Institute implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "instituteId")
	private Long instituteId;

	@Column(name = "name")
	private String name;

	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doe;

	@JoinColumn(name = "contactId", referencedColumnName = "contactId")
	@ManyToOne
	private Contact contact;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Enquiry> enquiryList;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Course> courseList;

	public Institute() {
	}

	public Institute(Long instituteId, String name) {
		this.instituteId = instituteId;
		this.name = name;
	}

	public Institute(String name, Date doe, Contact contact) {
		this.name = name;
		this.doe = doe;
		this.contact = contact;
	}

	public Institute(Long instituteId) {
		this.instituteId = instituteId;
	}

	public Long getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(Long instituteId) {
		this.instituteId = instituteId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Enquiry> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiry> enquiryList) {
		this.enquiryList = enquiryList;
	}

	@Override
	public String toString() {
		return "Institute [instituteId=" + instituteId + ", name=" + name + ", doe=" + doe + ", contact=" + contact
				+ ", enquiryList=" + enquiryList + ", courseList=" + courseList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((courseList == null) ? 0 : courseList.hashCode());
		result = prime * result + ((doe == null) ? 0 : doe.hashCode());
		result = prime * result + ((enquiryList == null) ? 0 : enquiryList.hashCode());
		result = prime * result + ((instituteId == null) ? 0 : instituteId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Institute other = (Institute) obj;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (courseList == null) {
			if (other.courseList != null)
				return false;
		} else if (!courseList.equals(other.courseList))
			return false;
		if (doe == null) {
			if (other.doe != null)
				return false;
		} else if (!doe.equals(other.doe))
			return false;
		if (enquiryList == null) {
			if (other.enquiryList != null)
				return false;
		} else if (!enquiryList.equals(other.enquiryList))
			return false;
		if (instituteId == null) {
			if (other.instituteId != null)
				return false;
		} else if (!instituteId.equals(other.instituteId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

}
