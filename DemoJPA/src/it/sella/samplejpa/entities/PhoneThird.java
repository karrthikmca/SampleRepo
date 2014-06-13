/**
 * @author   : gbs02311 
 * Created on: Jun 25, 2013 9:09:12 PM
 * Project   : DemoJPA 
 * File Name : PhoneThird.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PHONETHIRD")
@Table(name= "SAM_MA_PHONE3")
@SequenceGenerator(name="PN_SQ", sequenceName="SAM_SQ_PN_ID", allocationSize=1)
public class PhoneThird {

    @Id
    @Column(name="PN_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PN_SQ")
    private int id;
        
    @Column(name="PN_AREA_CODE")
    private String areaCode;

    @Column(name="PN_NUMBER")
    private String phNumber;
    
    public int getId() {
        return id;
    }    
    public void setId(int id) {
        this.id = id;
    }
    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getPhNumber() {
        return phNumber;
    }
    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }
    
    @Override
    public String toString() {
      return new StringBuilder("PhoneThird [id=").append(id)
              .append(", areaCode=").append(areaCode)
              .append(", phNumber=").append(phNumber)
              .append("]").toString();
    }
}