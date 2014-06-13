/**
 * @author   : gbs02311 
 * Created on: Jun 25, 2013 4:19:20 PM
 * Project   : DemoJPA 
 * File Name : Phone.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PHONE")
@Table(name= "SAM_MA_PHONE")
@SequenceGenerator(name="PH_SQ", sequenceName="SAM_SQ_PH_ID", allocationSize=1)
public class Phone {

    @Id
    @Column(name="PH_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PH_SQ")
    private int id;
    
    @Column(name="PH_TYPE")
    private String type;
    
    @Column(name="PH_AREA_CODE")
    private String areaCode;

    @Column(name="PH_NUMBER")
    private String phNumber;

    @ManyToOne
    private Person person;
    
    public int getId() {
        return id;
    }    
    public void setId(int id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
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
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
      return new StringBuilder("Phone [id=").append(id)
              .append(", type=").append(type)
              .append(", areaCode=").append(areaCode)
              .append(", phNumber=").append(phNumber)
              .append(", person=").append(person)
              .append("]").toString();
    }
}