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
@Entity(name="address" )
public class Address implements Serializable {

    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, length=19)
    private long addressId;
    @Column(length=200)
    private String detail;
    @Column(length=100)
    private String city;
    @Column(length=100)
    private String country;
    @Column(length=10)
    private Integer zip;
    //@OneToMany(mappedBy="address")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Contact> contact;
    //@OneToMany(mappedBy="address2")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private List<Contact> contact2;

    /** Default constructor. */
    public Address() {
        super();
    }

    public long getAddressId() {
        return addressId;
    }

    
    public void setAddressId(long aAddressId) {
        addressId = aAddressId;
    }

    
    public String getDetail() {
        return detail;
    }

    
    public void setDetail(String aDetail) {
        detail = aDetail;
    }

    
    public String getCity() {
        return city;
    }

    
    public void setCity(String aCity) {
        city = aCity;
    }

    
    public String getCountry() {
        return country;
    }

    
    public void setCountry(String aCountry) {
        country = aCountry;
    }

    public Integer getZip() {
		return zip;
	}

	public void setZip(Integer zip) {
		this.zip = zip;
	}

	public List<Contact> getContact() {
        return contact;
    }

    
    public void setContact(List<Contact> aContact) {
        contact = aContact;
    }

    
    public List<Contact> getContact2() {
        return contact2;
    }

   
    public void setContact2(List<Contact> aContact2) {
        contact2 = aContact2;
    }

    
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Address)) {
            return false;
        }
        Address that = (Address) other;
        if (this.getAddressId() != that.getAddressId()) {
            return false;
        }
        return true;
    }

    
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Address)) return false;
        return this.equalKeys(other) && ((Address)other).equalKeys(this);
    }

    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = (int)(getAddressId() ^ (getAddressId()>>>32));
        result = 37*result + i;
        return result;
    }

   
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Address |");
        sb.append(" addressId=").append(getAddressId());
        sb.append("]");
        return sb.toString();
    }


}
