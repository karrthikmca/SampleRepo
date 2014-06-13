/**
 * @author   : gbs02311 
 * Created on: Jun 21, 2013 4:59:48 PM
 * Project   : DemoJPA 
 * File Name : ContractEmployee.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name="CONTRACT_EMP")
@DiscriminatorValue("Contract")
public class ContractEmployee extends Employee {
    
    @Column(name="EM_DUR_YEARS")
    private float duration;

    public float getDuration() {
        return duration;
    }
    public void setDuration(float duration) {
        this.duration = duration;
    }
}