/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 8:40:47 PM
 * Project   : JpaWorkShop 
 * File Name : Person.java
 */
package it.sella.jpaworkshop.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="PERSON")
@Table(name="WS_MA_PERSON")
@SequenceGenerator(name="PR_SQ", sequenceName="WS_SQ_PR_ID", allocationSize=1)
public class Person {

    @Id
    @Column(name="PR_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PR_SQ")
    private int id;
    
    @Column(name="PR_NAME")
    private String name;
    
    @Column(name="PR_BIRTH_DATE")
    private Date dob;
    
    private List<Vehicle> vehicles;
    
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
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public List<Vehicle> getVehicles() {
        return vehicles;
    }
    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}