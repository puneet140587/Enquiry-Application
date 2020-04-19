// Generated with g9.

package com.eqap.poc.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

@SuppressWarnings("serial")
@Entity
@Table(name = "institute")
public class Institute implements Serializable {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long instituteId;
    
    @Column(length=200)
    private String name;
    
    private Date doe;
    
    @ManyToOne
    @JoinColumn(name="contactId")
    private Contact contact;
    
    //@OneToMany(mappedBy="institute")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Course> course;
    
    //@OneToMany(mappedBy="institute")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Enquiry> enquiry;

    /** Default constructor. */
    public Institute() {
    }
    

    public Institute(Long instituteId, String name) {
		this.instituteId = instituteId;
		this.name = name;
	}

	public long getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(long aInstituteId) {
        instituteId = aInstituteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public Date getDoe() {
        return doe;
    }

    public void setDoe(Date date) {
        doe = date;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact aContact) {
        contact = aContact;
    }
    
    public List<Course> getCourse() {
		return course;
	}

	public void setCourse(List<Course> course) {
		this.course = course;
	}

	public List<Enquiry> getEnquiry() {
		return enquiry;
	}

	public void setEnquiry(List<Enquiry> enquiry) {
		this.enquiry = enquiry;
	}

	private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Institute)) {
            return false;
        }
        Institute that = (Institute) other;
        if (this.getInstituteId() != that.getInstituteId()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Institute)) return false;
        return this.equalKeys(other) && ((Institute)other).equalKeys(this);
    }

    
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getInstituteId() ^ (getInstituteId()>>>32));
        result = 37*result + i;
        return result;
    }

    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Institute |");
        sb.append(" instituteId=").append(getInstituteId());
        sb.append("]");
        return sb.toString();
    }

}
