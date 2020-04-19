// Generated with g9.

package com.eqap.poc.entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@SuppressWarnings("serial")
@Entity(name="enquiry")
public class Enquiry implements Serializable {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long enquiryId;
    private Timestamp doe;
    private Date nextCallDate;
    @Column(length=400)
    private String remark;
    @Column(precision=15, scale=3)
    private double committedFees;
    private Timestamp lastUpdate;
    @ManyToOne
    @JoinColumn(name="contactId")
    private Contact contact;
    @OneToMany(mappedBy="enquiry")
    private Set<Followup> followup;
    @OneToMany(mappedBy="enquiry")
    private Set<EnquiryCourse> enquirycourse;
    @ManyToOne
    @JoinColumn(name="instituteId")
    private Institute institute;
    @ManyToOne
    @JoinColumn(name="enquirySourceId")
    private EnquirySource enquirysource;

    /** Default constructor. */
    public Enquiry() {
        super();
    }

    
    public long getEnquiryId() {
        return enquiryId;
    }

    
    public void setEnquiryId(long aEnquiryId) {
        enquiryId = aEnquiryId;
    }

    
    public Timestamp getDoe() {
        return doe;
    }

    
    public void setDoe(Timestamp aDoe) {
        doe = aDoe;
    }

    
    public Date getNextCallDate() {
        return nextCallDate;
    }

    
    public void setNextCallDate(Date aNextCallDate) {
        nextCallDate = aNextCallDate;
    }

    
    public String getRemark() {
        return remark;
    }

    
    public void setRemark(String aRemark) {
        remark = aRemark;
    }

    
    public double getCommittedFees() {
        return committedFees;
    }

    
    public void setCommittedFees(double aCommittedFees) {
        committedFees = aCommittedFees;
    }

    
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    
    public void setLastUpdate(Timestamp aLastUpdate) {
        lastUpdate = aLastUpdate;
    }

    
    public Contact getContact() {
        return contact;
    }

    
    public void setContact(Contact aContact) {
        contact = aContact;
    }

    
    public Set<Followup> getFollowup() {
        return followup;
    }

    
    public void setFollowup(Set<Followup> aFollowup) {
        followup = aFollowup;
    }

    
    public Set<EnquiryCourse> getEnquirycourse() {
        return enquirycourse;
    }

    
    public void setEnquirycourse(Set<EnquiryCourse> aEnquirycourse) {
        enquirycourse = aEnquirycourse;
    }

    
    public Institute getInstitute() {
        return institute;
    }

    
    public void setInstitute(Institute aInstitute) {
        institute = aInstitute;
    }

    
    public EnquirySource getEnquirysource() {
        return enquirysource;
    }

    
    public void setEnquirysource(EnquirySource aEnquirysource) {
        enquirysource = aEnquirysource;
    }

   
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Enquiry)) {
            return false;
        }
        Enquiry that = (Enquiry) other;
        if (this.getEnquiryId() != that.getEnquiryId()) {
            return false;
        }
        return true;
    }

   
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Enquiry)) return false;
        return this.equalKeys(other) && ((Enquiry)other).equalKeys(this);
    }

   
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getEnquiryId() ^ (getEnquiryId()>>>32));
        result = 37*result + i;
        return result;
    }

    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Enquiry |");
        sb.append(" enquiryId=").append(getEnquiryId());
        sb.append("]");
        return sb.toString();
    }

}
