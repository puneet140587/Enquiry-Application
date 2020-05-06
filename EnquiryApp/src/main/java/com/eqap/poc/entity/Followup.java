
package com.eqap.poc.entity;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name = "followup")
public class Followup implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "followupId")
	private Long followupId;

	@Column(name = "doe")
	@Temporal(TemporalType.TIMESTAMP)
	private Date doe;

	@Column(name = "detail")
	private String detail;

	@JoinColumn(name = "enquiryId", referencedColumnName = "enquiryId")
	@ManyToOne
	private Enquiry enquiry;

	public Followup(Long followupId, Date doe, String detail) {
		this.followupId = followupId;
		this.doe = doe;
		this.detail = detail;
	}

	public Followup() {
	}

	public Followup(Long followupId) {
		this.followupId = followupId;
	}

	public Long getFollowupId() {
		return followupId;
	}

	public void setFollowupId(Long followupId) {
		this.followupId = followupId;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Enquiry getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(Enquiry enquiry) {
		this.enquiry = enquiry;
	}

	@Override
	public String toString() {
		return "Followup [followupId=" + followupId + ", doe=" + doe + ", detail=" + detail + ", enquiry=" + enquiry
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((detail == null) ? 0 : detail.hashCode());
		result = prime * result + ((doe == null) ? 0 : doe.hashCode());
		result = prime * result + ((enquiry == null) ? 0 : enquiry.hashCode());
		result = prime * result + ((followupId == null) ? 0 : followupId.hashCode());
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
		Followup other = (Followup) obj;
		if (detail == null) {
			if (other.detail != null)
				return false;
		} else if (!detail.equals(other.detail))
			return false;
		if (doe == null) {
			if (other.doe != null)
				return false;
		} else if (!doe.equals(other.doe))
			return false;
		if (enquiry == null) {
			if (other.enquiry != null)
				return false;
		} else if (!enquiry.equals(other.enquiry))
			return false;
		if (followupId == null) {
			if (other.followupId != null)
				return false;
		} else if (!followupId.equals(other.followupId))
			return false;
		return true;
	}

}
