/**
 * @author   : gbs02311 
 * Created on: Jun 25, 2013 8:48:45 PM
 * Project   : DemoJPA 
 * File Name : PhoneType.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PHONETYPE")
@Table(name= "SAM_MA_PHONETYPE")
@SequenceGenerator(name="PT_SQ", sequenceName="SAM_SQ_PT_ID", allocationSize=1)
public class PhoneType {

    @Id
    @Column(name="PT_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PT_SQ")
    private int id;
    
    @Column(name="PT_TYPE")
    private String type;

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
    @Override
    public String toString() {
      return new StringBuilder("PhoneType [id=").append(id)
              .append(", type=").append(type)
              .append("]").toString();
    }    
}