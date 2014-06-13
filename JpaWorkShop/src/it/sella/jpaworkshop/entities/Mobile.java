/**
 * @author   : gbs02311 
 * Created on: Jun 25, 2013 4:19:20 PM
 * Project   : DemoJPA 
 * File Name : Phone.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "MOBILE")
@Table(name= "WS_MA_PHONE")
@SequenceGenerator(name="PH_SQ", sequenceName="SAM_SQ_PH_ID", allocationSize=1)

public class Mobile {

    @Id
    @Column(name="PH_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PH_SQ")
    private int id;
    
    @Column(name="PH_TYPE")
    private String type;
    
    @Column(name="PH_NUMBER")
    private String number;

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
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
      return new StringBuilder("MOBILE [id=").append(id)
              .append(", type=").append(type)
              .append(", number=").append(number)
              .append("]").toString();
    }
}