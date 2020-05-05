
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
@Table(name = "contact")
public class Contact implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "contactId")
	private Long contactId;

	@Column(name = "name")
	private String name;

	@Column(name = "email")
	private String email;

	@Column(name = "phone")
	private String phone;

	@JoinColumn(name = "localAddress", referencedColumnName = "addressId")
	@ManyToOne
	private Address localAddress;

	@JoinColumn(name = "permanentAddress", referencedColumnName = "addressId")
	@ManyToOne
	private Address permanentAddress;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Enquiry> enquiryList;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@Transient
	private List<Institute> instituteList;

	public Contact() {
	}

	public Contact(Long contactId) {
		this.contactId = contactId;
	}

	public Contact(String name, String email, String phone, Address localAddress, Address permanentAddress) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.localAddress = localAddress;
		this.permanentAddress = permanentAddress;
	}

	public Long getContactId() {
		return contactId;
	}

	public void setContactId(Long contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(Address localAddress) {
		this.localAddress = localAddress;
	}

	public Address getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(Address permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public List<Enquiry> getEnquiryList() {
		return enquiryList;
	}

	public void setEnquiryList(List<Enquiry> enquiryList) {
		this.enquiryList = enquiryList;
	}

	public List<Institute> getInstituteList() {
		return instituteList;
	}

	public void setInstituteList(List<Institute> instituteList) {
		this.instituteList = instituteList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactId == null) ? 0 : contactId.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((enquiryList == null) ? 0 : enquiryList.hashCode());
		result = prime * result + ((instituteList == null) ? 0 : instituteList.hashCode());
		result = prime * result + ((localAddress == null) ? 0 : localAddress.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((permanentAddress == null) ? 0 : permanentAddress.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Contact other = (Contact) obj;
		if (contactId == null) {
			if (other.contactId != null)
				return false;
		} else if (!contactId.equals(other.contactId))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enquiryList == null) {
			if (other.enquiryList != null)
				return false;
		} else if (!enquiryList.equals(other.enquiryList))
			return false;
		if (instituteList == null) {
			if (other.instituteList != null)
				return false;
		} else if (!instituteList.equals(other.instituteList))
			return false;
		if (localAddress == null) {
			if (other.localAddress != null)
				return false;
		} else if (!localAddress.equals(other.localAddress))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (permanentAddress == null) {
			if (other.permanentAddress != null)
				return false;
		} else if (!permanentAddress.equals(other.permanentAddress))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", localAddress=" + localAddress + ", permanentAddress=" + permanentAddress + ", enquiryList="
				+ enquiryList + ", instituteList=" + instituteList + "]";
	}

}
