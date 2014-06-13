/**
 * @author   : gbs02311 
 * Created on: Jun 21, 2013 9:08:05 PM
 * Project   : DemoJPA 
 * File Name : PersonPhone.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.Basic;
import javax.persistence.Embeddable;

@Embeddable
public class PersonPhone {

    @Basic
    private String type;

    
    public String getType() {
        return type;
    }

    
    public void setType(String type) {
        this.type = type;
    }
}