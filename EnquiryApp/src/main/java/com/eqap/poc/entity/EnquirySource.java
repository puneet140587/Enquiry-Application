// Generated with g9.

package com.eqap.poc.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import com.fasterxml.jackson.annotation.JsonInclude;

@SuppressWarnings("serial")
@Entity(name="enquirysource")
public class EnquirySource implements Serializable {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long enquirySourceId;
    
    @Column(length=100)
    private String name;
    
    //@OneToMany(mappedBy="enquirysource")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Enquiry> enquiry;

    public EnquirySource() {
    }
    
    public EnquirySource(String name) {
		this.name = name;
	}

    public long getEnquirySourceId() {
        return enquirySourceId;
    }

    public void setEnquirySourceId(long aEnquirySourceId) {
        enquirySourceId = aEnquirySourceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public List<Enquiry> getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(List<Enquiry> aEnquiry) {
        enquiry = aEnquiry;
    }

    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof EnquirySource)) {
            return false;
        }
        EnquirySource that = (EnquirySource) other;
        if (this.getEnquirySourceId() != that.getEnquirySourceId()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EnquirySource)) return false;
        return this.equalKeys(other) && ((EnquirySource)other).equalKeys(this);
    }

    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getEnquirySourceId() ^ (getEnquirySourceId()>>>32));
        result = 37*result + i;
        return result;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Enquirysource |");
        sb.append(" enquirySourceId=").append(getEnquirySourceId());
        sb.append("]");
        return sb.toString();
    }

 
}
