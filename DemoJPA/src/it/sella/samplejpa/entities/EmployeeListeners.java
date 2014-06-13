/**
 * @author   : gbs02311 
 * Created on: Jun 21, 2013 2:52:11 PM
 * Project   : DemoJPA 
 * File Name : EmployeeListeners.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class EmployeeListeners {

    @PrePersist
    public void prePresist(final Employee employee) {
        System.out.println("EmployeeListeners --> prePersist CallBack Called");
    }

    @PostPersist
    public void postPresist(final Employee employee) {
        System.out.println("EmployeeListeners --> postPersist CallBack Called");
    }

}