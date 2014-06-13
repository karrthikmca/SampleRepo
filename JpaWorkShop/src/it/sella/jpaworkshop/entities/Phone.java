/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 7:36:15 PM
 * Project   : JpaWorkShop 
 * File Name : Mobile.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name="TELEPHONE")
public class Phone extends Mobile {

    @Column(name="PH_AREA_CODE")
    private String areaCode;

    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
}