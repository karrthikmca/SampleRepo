/**
 * @author   : gbs02311 
 * Created on: Jun 24, 2013 2:37:12 PM
 * Project   : DemoJPA 
 * File Name : Author.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "AUTHOR")
@Table(name= "SAM_MA_AUTHOR")
@SequenceGenerator(name="AU_SQ", sequenceName="SAM_SQ_AU_ID", allocationSize=1)
public class Author {

    @Id
    @Column(name="AU_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="AU_SQ")
    private int id;
    
    @Column(name="AU_FIRST_NAME")
    private String firstName;
    
    @Column(name="AU_LAST_NAME")
    private String lastName;
    
    public int getId() {
        return id;
    }    
    public void setId(int id) {
        this.id = id;
    }    
    public String getFirstName() {
        return firstName;
    }    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }    
    public String getLastName() {
        return lastName;
    }    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }  

    @Override
    public String toString() {
      return new StringBuilder("Author [id=").append(id)
              .append(", firstName=").append(firstName)
              .append(", lastName=").append(lastName)
              .append("]").toString();
    }
}