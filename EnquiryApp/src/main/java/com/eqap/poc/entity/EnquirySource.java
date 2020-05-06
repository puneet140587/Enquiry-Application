
package com.eqap.poc.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "enquirysource")
public class EnquirySource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "enquirySourceId")
	private Long enquirySourceId;

	@Column(name = "name")
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Enquiry> enquiryList;

	public EnquirySource() {
	}

	public EnquirySource(Long enquirySourceId, String name) {
		this.enquirySourceId = enquirySourceId;
		this.name = name;
	}

	public EnquirySource(String name) {
		this.name = name;
	}

	public EnquirySource(Long enquirySourceId) {
		this.enquirySourceId = enquirySourceId;
	}

	public Long getEnquirySourceId() {
		return enquirySourceId;
	}

	public void setEnquirySourceId(Long enquirySourceId) {
		this.enquirySourceId = enquirySourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EnquirySource [enquirySourceId=" + enquirySourceId + ", name=" + name + ", enquiryList=" + enquiryList
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((enquiryList == null) ? 0 : enquiryList.hashCode());
		result = prime * result + ((enquirySourceId == null) ? 0 : enquirySourceId.hashCode());
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
		EnquirySource other = (EnquirySource) obj;
		if (enquiryList == null) {
			if (other.enquiryList != null)
				return false;
		} else if (!enquiryList.equals(other.enquiryList))
			return false;
		if (enquirySourceId == null) {
			if (other.enquirySourceId != null)
				return false;
		} else if (!enquirySourceId.equals(other.enquirySourceId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public List<Enquiry> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiry> enquiryList) {
		this.enquiryList = enquiryList;
	}

}
