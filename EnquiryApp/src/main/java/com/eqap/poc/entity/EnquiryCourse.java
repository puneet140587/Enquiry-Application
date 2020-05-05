
package com.eqap.poc.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enquirycourse")
public class EnquiryCourse implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "enquiryCourseId")
	private Long enquiryCourseId;

	@JoinColumn(name = "courseId", referencedColumnName = "courseId")
	@ManyToOne
	private Course course;

	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	@ManyToOne
	private Enquiry enquiry;

	public EnquiryCourse() {
	}

	public EnquiryCourse(Long enquiryCourseId) {
		this.enquiryCourseId = enquiryCourseId;
	}

	public Long getEnquiryCourseId() {
		return enquiryCourseId;
	}

	public void setEnquiryCourseId(Long enquiryCourseId) {
		this.enquiryCourseId = enquiryCourseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Enquiry getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((enquiry == null) ? 0 : enquiry.hashCode());
		result = prime * result + ((enquiryCourseId == null) ? 0 : enquiryCourseId.hashCode());
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
		EnquiryCourse other = (EnquiryCourse) obj;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (enquiry == null) {
			if (other.enquiry != null)
				return false;
		} else if (!enquiry.equals(other.enquiry))
			return false;
		if (enquiryCourseId == null) {
			if (other.enquiryCourseId != null)
				return false;
		} else if (!enquiryCourseId.equals(other.enquiryCourseId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EnquiryCourse [enquiryCourseId=" + enquiryCourseId + ", course=" + course + ", enquiry=" + enquiry
				+ "]";
	}

}
