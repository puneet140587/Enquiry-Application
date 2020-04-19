// Generated with g9.

package com.eqap.poc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity(name="enquirycourse")
public class EnquiryCourse implements Serializable {
    

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long enquiryCourseId;
    @ManyToOne
    @JoinColumn(name="courseId")
    private Course course;
    @ManyToOne
    @JoinColumn(name="enquiryId")
    private Enquiry enquiry;

    /** Default constructor. */
    public EnquiryCourse() {
        super();
    }

    
    public long getEnquiryCourseId() {
        return enquiryCourseId;
    }

    
    public void setEnquiryCourseId(long aEnquiryCourseId) {
        enquiryCourseId = aEnquiryCourseId;
    }

    
    public Course getCourse() {
        return course;
    }

    
    public void setCourse(Course aCourse) {
        course = aCourse;
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
        if (!(other instanceof EnquiryCourse)) {
            return false;
        }
        EnquiryCourse that = (EnquiryCourse) other;
        if (this.getEnquiryCourseId() != that.getEnquiryCourseId()) {
            return false;
        }
        return true;
    }

    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof EnquiryCourse)) return false;
        return this.equalKeys(other) && ((EnquiryCourse)other).equalKeys(this);
    }

    
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getEnquiryCourseId() ^ (getEnquiryCourseId()>>>32));
        result = 37*result + i;
        return result;
    }

    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Enquirycourse |");
        sb.append(" enquiryCourseId=").append(getEnquiryCourseId());
        sb.append("]");
        return sb.toString();
    }

}
