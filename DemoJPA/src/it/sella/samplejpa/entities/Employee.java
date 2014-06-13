/**
 * @author   : gbs02311 
 * Created on: Jun 19, 2013 8:04:51 PM
 * Project   : SampleJPA 
 * File Name : Employee.java
 */
package it.sella.samplejpa.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="EMPLOYEE")
@EntityListeners({EmployeeListeners.class})
@Table(name="SAM_MA_EMP")
@SequenceGenerator(name="EMP_SQ", sequenceName="SAM_SQ_EM_ID", allocationSize=1)
@DiscriminatorColumn(name="EM_TYPE")
@DiscriminatorValue("Permanent")
@NamedQuery(name="Employee.findByEmpType", query="SELECT emp FROM EMPLOYEE emp where emp.type = :TYPE")
public class Employee {

    @Id
    //@TableGenerator()
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMP_SQ")
    @Column(name="EM_ID")
    private int id;
    
    @Column(name="EM_NAME", nullable=false, length = 10)
    private String name;
    
    @Column(name="EM_DOJ")
    @Temporal(TemporalType.DATE)
    //@Version
    private Date doj;
    
    @Column(name="EM_LEVEL", precision = 4)
    private float level;
    
    @Column(name="EM_SALARY")
    private BigDecimal salary;
    
    @Embedded 
    /*@AttributeOverrides({
            @AttributeOverride(name="city", column=@Column(name ="ST_CITY")),
            @AttributeOverride(name="pinCode", column=@Column(name ="ST_PINCODE"))
    })*/
            
    private Address address;
    
    @Column(name="EM_TYPE")
    private String type;

    @ManyToOne
    @JoinColumn(name="EM_DP_ID")
    private Department depmt;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDoj() {
        return doj;
    }
    public void setDoj(Date doj) {
        this.doj = doj;
    }
    public float getLevel() {
        return level;
    }
    public void setLevel(float level) {
        this.level = level;
    }
    public Address getAddress() {
        return address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public BigDecimal getSalary() {
        return salary;
    }
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public Department getDepmt() {
        return depmt;
    }
    public void setDepmt(Department depmt) {
        this.depmt = depmt;
    }


/*    @PrePersist
    public void prePresist() {
        System.out.println("Employee--> prePersist CallBack Called");
    }

    @PostPersist
    public void postPresist() {
        System.out.println("Employee--> postPersist CallBack Called");
    }
*/

    @Override
    public String toString() {
      return new StringBuilder("Employee [id=").append(id)
              .append(", name=").append(name)
              .append(", doj=").append(doj)
              .append(", salary=").append(salary)
              .append(", level=").append(level)
              .append(", Address=").append(address).append(", Department=").append(depmt).append("]").toString();
    }
}