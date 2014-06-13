/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 8:46:11 PM
 * Project   : JpaWorkShop 
 * File Name : Vehicle.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.Column;

public class Vehicle {
    
    @Column(name="VE_TYPE")
    private String type;   // Example: Cycle, Bike, Car
    
    @Column(name="PR_MODEL")
    private String model;   // Example: BSA, Hero, BMW  
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getName() {
        return model;
    }    
    public void setName(String model) {
        this.model = model;
    }
}