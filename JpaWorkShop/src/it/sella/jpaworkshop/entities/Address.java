/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 9:13:08 PM
 * Project   : JpaWorkShop 
 * File Name : Address.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.Column;


public class Address {

    @Column(name="CU_STREET")
    private String street;
    
    @Column(name="CU_CITY")
    private String city;
    
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
}