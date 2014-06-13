/**
 * @author   : gbs02311 
 * Created on: Jun 21, 2013 4:39:48 PM
 * Project   : DemoJPA 
 * File Name : Address.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name="EM_STREET")
    private String street;

    @Column(name="EM_CITY")
    private String city;

    @Column(name="EM_PINCODE")
    private long pinCode;

    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public long getPinCode() {
        return pinCode;
    }
    public void setPinCode(long pinCode) {
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
      return "Address [street=" + street + ", City=" + city + ", pinCode=" + pinCode + "]";
    }    
}


