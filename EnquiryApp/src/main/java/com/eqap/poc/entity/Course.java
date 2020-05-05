
package com.eqap.poc.entity;

import java.io.Serializable;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "course")
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "courseId")
	private Long courseId;

	@Column(name = "name")
	private String name;

	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "fees")
	private Double fees;

	@JoinColumn(name = "instituteId", referencedColumnName = "instituteId")
	@ManyToOne
	private Institute institute;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<EnquiryCourse> enquiryCourseList;

	public Course(String name, Double fees, Institute institute) {
		this.name = name;
		this.fees = fees;
		this.institute = institute;
	}

	public Course() {
	}

	public Course(Long courseId) {
		this.courseId = courseId;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getFees() {
		return fees;
	}

	public void setFees(Double fees) {
		this.fees = fees;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}

	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", name=" + name + ", fees=" + fees + ", institute=" + institute
				+ ", enquiryCourseList=" + enquiryCourseList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
		result = prime * result + ((enquiryCourseList == null) ? 0 : enquiryCourseList.hashCode());
		result = prime * result + ((fees == null) ? 0 : fees.hashCode());
		result = prime * result + ((institute == null) ? 0 : institute.hashCode());
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
		Course other = (Course) obj;
		if (courseId == null) {
			if (other.courseId != null)
				return false;
		} else if (!courseId.equals(other.courseId))
			return false;
		if (enquiryCourseList == null) {
			if (other.enquiryCourseList != null)
				return false;
		} else if (!enquiryCourseList.equals(other.enquiryCourseList))
			return false;
		if (fees == null) {
			if (other.fees != null)
				return false;
		} else if (!fees.equals(other.fees))
			return false;
		if (institute == null) {
			if (other.institute != null)
				return false;
		} else if (!institute.equals(other.institute))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public List<EnquiryCourse> getEnquiryCourseList() {
		return enquiryCourseList;
	}

	public void setEnquiryCourseList(List<EnquiryCourse> enquiryCourseList) {
		this.enquiryCourseList = enquiryCourseList;
	}

}
