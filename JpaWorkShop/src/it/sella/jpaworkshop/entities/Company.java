/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 9:33:05 PM
 * Project   : JpaWorkShop 
 * File Name : Company.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="COMPANY")
@Table(name="WS_MA_COMPANY")
@SequenceGenerator(name="CO_SQ", sequenceName="WS_SQ_CO_ID", allocationSize=1)
public class Company {

    @Id
    @Column(name="CO_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="CO_SQ")
    private int id;
    
    @Column(name="CO_NAME")
    private String name;

    @Column(name="CO_PRODUCT")
    private String product;
    
    private Address address;
    
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
    public String getProduct() {
        return product;
    }
    public void setProduct(String product) {
        this.product = product;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}