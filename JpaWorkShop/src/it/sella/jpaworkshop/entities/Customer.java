/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 9:12:19 PM
 * Project   : JpaWorkShop 
 * File Name : Customer.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="CUSTOMER")
@Table(name="WS_MA_CUSTOMER")
@SequenceGenerator(name="CU_SQ", sequenceName="WS_SQ_CU_ID", allocationSize=1)
public class Customer {

    @Id
    @Column(name="CU_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="CU_SQ")
    private int id;
    
    @Column(name="CU_NAME")
    private String name;

    @Embedded
    private ContactInfo contactInfo;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    public void setContactInfo(ContactInfo contactInfo) {
        this.contactInfo = contactInfo;
    }
}