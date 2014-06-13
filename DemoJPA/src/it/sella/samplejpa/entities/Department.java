/**
 * @author   : gbs02311 
 * Created on: Jun 21, 2013 10:29:42 PM
 * Project   : DemoJPA 
 * File Name : Department.java
 */
package it.sella.samplejpa.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity(name="DEPARTMENT")
@Table(name="SAM_MA_DEPARTMENT")
@SequenceGenerator(name="DEPT_SQ", sequenceName="SAM_SQ_DP_ID", allocationSize=1)
public class Department implements Serializable {

    @Id
    @Column(name="DP_ID")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="DEPT_SQ")
    private int id;    
    
    @Column(name="DP_NAME")
    private String name;
    
    //@Column(name="DP_EMPID")    
    @OneToMany(mappedBy="depmt")
    @OrderBy("name asc")
    //@JoinColumn(name="DP_EMPID")
    private List<Employee> employees;
    
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
    public List<Employee> getEmployees() {
        return employees;
    }
    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    
   public void addEmployeeemp(final Employee emp) {
       if( employees == null) {
           employees = new ArrayList<Employee>();
       }
       employees.add(emp);
       
   }
    
    @Override
    public String toString() {
        return new StringBuilder("Department id: ").append(id).append(", name: ").append(name).toString();
    }
}