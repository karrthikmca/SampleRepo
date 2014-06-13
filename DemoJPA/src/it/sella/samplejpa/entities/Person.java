/**
 * @author   : gbs02311 
 * Created on: Jun 22, 2013 4:19:09 PM
 * Project   : DemoJPA 
 * File Name : Person.java
 */
package it.sella.samplejpa.entities;

import java.math.BigDecimal;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name = "PERSON")
@Table(name= "SAM_MA_PERSON")
@SequenceGenerator(name="PR_SQ", sequenceName="SAM_SQ_PR_ID", allocationSize=1)
public class Person {

    @Id
    @Column(name="PR_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PR_SQ")
    private int id;
    
    @Column(name="PR_FIRST_NAME")
    private String firstName;
    
    @Column(name="PR_FIRST_NAME")
    private String lastName;

    @Column(name="PR_SALARTY")
    private BigDecimal salary;
    
    @OneToMany(mappedBy="person")
    @MapKeyColumn(name="PH_TYPE")
    private Map<String, Phone> phone;
    
    @OneToMany(mappedBy="phones")
    @MapKeyJoinColumn(name="PO_PT_ID")
    private Map<String, Phone> phoneByType;
    
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

    
    public BigDecimal getSalary() {
        return salary;
    }

    
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
 
    @Override
    public String toString() {
      return new StringBuilder("Author [id=").append(id)
              .append(", firstName=").append(firstName)
              .append(", lastName=").append(lastName)
              .append(", salary=").append(salary)
              .append("]").toString();
    }
}