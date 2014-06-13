/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 9:14:18 PM
 * Project   : JpaWorkShop 
 * File Name : ContactInfo.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.Column;


public class ContactInfo {

    private Address address;
    
    @Column(name="CU_MAIL")
    private String mail;
    
    @Column(name="CU_CONTACT_NO")
    private String number;
    
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}