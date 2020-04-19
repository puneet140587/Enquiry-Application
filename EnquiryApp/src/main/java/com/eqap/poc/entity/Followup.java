// Generated with g9.

package com.eqap.poc.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name="followup")
public class Followup implements Serializable {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long followupId;
    private Timestamp doe;
    @Column(length=200)
    private String detail;
    @ManyToOne
    @JoinColumn(name="enquiryId")
    private Enquiry enquiry;

    /** Default constructor. */
    public Followup() {
        super();
    }

    public long getFollowupId() {
        return followupId;
    }

    public void setFollowupId(long aFollowupId) {
        followupId = aFollowupId;
    }

    public Timestamp getDoe() {
        return doe;
    }

    public void setDoe(Timestamp aDoe) {
        doe = aDoe;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String aDetail) {
        detail = aDetail;
    }

    public Enquiry getEnquiry() {
        return enquiry;
    }

    public void setEnquiry(Enquiry aEnquiry) {
        enquiry = aEnquiry;
    }

    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Followup)) {
            return false;
        }
        Followup that = (Followup) other;
        if (this.getFollowupId() != that.getFollowupId()) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Followup)) return false;
        return this.equalKeys(other) && ((Followup)other).equalKeys(this);
    }

    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getFollowupId() ^ (getFollowupId()>>>32));
        result = 37*result + i;
        return result;
    }

    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Followup |");
        sb.append(" followupId=").append(getFollowupId());
        sb.append("]");
        return sb.toString();
    }

}
