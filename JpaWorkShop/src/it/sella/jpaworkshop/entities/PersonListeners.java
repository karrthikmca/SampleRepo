/*
 * @author   : gbs02311 
 * Created on: Jun 21, 2013 2:52:11 PM
 * Project   : SampleJPA 
 * File Name : EmployeeListeners.java
 */
package it.sella.jpaworkshop.entities;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class PersonListeners {

    @PrePersist
    public void prePresist() {
        System.out.println("Person --> prePersist CallBack Called");
    }

    @PostPersist
    public void postPresist() {
        System.out.println("Person --> postPersist CallBack Called");
    }
}