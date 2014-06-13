/**
 * @author   : gbs02311 
 * Created on: Jun 24, 2013 8:52:28 PM
 * Project   : DemoJPA 
 * File Name : PhoneSecond.java
 */
package it.sella.samplejpa.entities;

import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PHONESECOND")
@Table(name= "SAM_MA_PHONE2")
@SequenceGenerator(name="PO_SQ", sequenceName="SAM_SQ_PO_ID", allocationSize=1)
public class PhoneSecond {
    @Id
    @Column(name="PO_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PO_SQ")
    private int id;
        
    @Column(name="PO_AREA_CODE")
    private String areaCode;

    @Column(name="PO_NUMBER")
    private String phNumber;

    @OneToMany(mappedBy="person")
    @MapKeyColumn(name="PO_PT_ID")
    private Map<PhoneType, Phone> phones;
    
    @ManyToOne
    private Person person;
    
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
    public Person getPersons() {
        return person;
    }
    public void setPersons(Person persons) {
        this.person = person;
    }

    @Override
    public String toString() {
      return new StringBuilder("Phone [id=").append(id)
              .append(", areaCode=").append(areaCode)
              .append(", phNumber=").append(phNumber)
              .append(", person=").append(person)
              .append("]").toString();
    }
}