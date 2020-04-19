  // Generated with g9.

package com.eqap.poc.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "course")
public class Course implements Serializable {

    /** Primary key. */
    protected static final String PK = "courseId";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long courseId;
    
    @Column(length=100)
    private String name;
    
    @Column(precision=15, scale=3)
    private double fees;
    
    @OneToMany(mappedBy="course")
    private Set<EnquiryCourse> enquirycourse;
     
    @ManyToOne
    @JoinColumn(name="instituteId" , referencedColumnName = "instituteId")
    private Institute institute;

    /** Default constructor. */
    public Course() {
    }

	/*public Course(String name, double fees, Institute institute) {
		this.name = name;
		this.fees = fees;
		this.institute = institute;
	}*/


	public long getCourseId() {
        return courseId;
    }

    
    public void setCourseId(long aCourseId) {
        courseId = aCourseId;
    }

    
    public String getName() {
        return name;
    }

    
    public void setName(String aName) {
        name = aName;
    }

    
    public double getFees() {
        return fees;
    }

    
    public void setFees(double aFees) {
        fees = aFees;
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

    
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Course)) {
            return false;
        }
        Course that = (Course) other;
        if (this.getCourseId() != that.getCourseId()) {
            return false;
        }
        return true;
    }

    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Course)) return false;
        return this.equalKeys(other) && ((Course)other).equalKeys(this);
    }

    
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getCourseId() ^ (getCourseId()>>>32));
        result = 37*result + i;
        return result;
    }

    
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Course |");
        sb.append(" courseId=").append(getCourseId());
        sb.append("]");
        return sb.toString();
    }

}
