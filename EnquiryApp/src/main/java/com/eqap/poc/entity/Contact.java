// Generated with g9.

package com.eqap.poc.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("serial")
@Entity(name="contact")
public class Contact implements Serializable {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long contactId;
    @Column(length=45)
    private String name;
    @Column(length=45)
    private String email;
    @Column(length=100)
    private String phone;
    @OneToMany(mappedBy="contact")
    private Set<Enquiry> enquiry;
    @ManyToOne
    @JoinColumn(name="localAddress")
    private Address localAddress;
    @ManyToOne
    @JoinColumn(name="permanentAddress" )
    private Address permanentAddress;
    //@OneToMany(mappedBy="contact")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Institute> institute;

    /** Default constructor. */
    public Contact() {
        super();
    }

    public long getContactId() {
        return contactId;
    }

    
    public void setContactId(long aContactId) {
        contactId = aContactId;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String aName) {
        name = aName;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    
    public String getPhone() {
        return phone;
    }

    
    public void setPhone(String aPhone) {
        phone = aPhone;
    }

    
    public Set<Enquiry> getEnquiry() {
        return enquiry;
    }

    
    public void setEnquiry(Set<Enquiry> aEnquiry) {
        enquiry = aEnquiry;
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

    public List<Institute> getInstitute() {
		return institute;
	}

	public void setInstitute(List<Institute> institute) {
		this.institute = institute;
	}

	private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Contact)) {
            return false;
        }
        Contact that = (Contact) other;
        if (this.getContactId() != that.getContactId()) {
            return false;
        }
        return true;
    }
    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Contact)) return false;
        return this.equalKeys(other) && ((Contact)other).equalKeys(this);
    }

    
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getContactId() ^ (getContactId()>>>32));
        result = 37*result + i;
        return result;
    }
    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Contact |");
        sb.append(" contactId=").append(getContactId());
        sb.append("]");
        return sb.toString();
    }

}
