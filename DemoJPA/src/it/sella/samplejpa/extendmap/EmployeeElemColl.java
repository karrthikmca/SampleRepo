/**
 * @author   : gbs02311 
 * Created on: Jun 22, 2013 9:19:31 PM
 * Project   : DemoJPA 
 * File Name : EmployeeElemColl.java
 */
package it.sella.samplejpa.extendmap;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="EMP_ELEMENT")
@Table(name="SAM_MA_PERSON")
@SequenceGenerator(name="PR_SQ", sequenceName="SAM_SQ_PR_ID", allocationSize=1)
public class EmployeeElemColl {

    @Id
    @Column(name="PR_ID")
    @GeneratedValue(strategy=GenerationType.TABLE, generator="PR_SQ")
    private int id;
    
    @Column(name="PR_FIRST_NAME")
    private String firstName;
    
    @Column(name="PR_LAST_NAME")
    private String lastName;

    @Column(name="PR_SALARTY")
    private BigDecimal salary;
    
    @ElementCollection
    @CollectionTable(name="SAM_MA_PHONE_ELEMCOLL",
            joinColumns=@JoinColumn(name="PE_PR_ID"))
    private List<PhoneElemColl> phoneElemColl;

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
    public List<PhoneElemColl> getPhoneElemColl() {
        return phoneElemColl;
    }
    public void setPhoneElemColl(List<PhoneElemColl> phoneElemColl) {
        this.phoneElemColl = phoneElemColl;
    }    

    
    @Override
    public String toString() {
      return new StringBuilder("EmployeeElemColl [id=").append(id)
              .append(", firstName=").append(firstName)
              .append(", lastName=").append(lastName)
              .append(", salary=").append(salary)
              .append(", phoneElemColl List =").append(phoneElemColl)
              .append("]").toString();
    }
}