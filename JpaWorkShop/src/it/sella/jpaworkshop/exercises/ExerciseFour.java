/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 9:53:18 PM
 * Project   : JpaWorkShop 
 * File Name : ExerciseFour.java
 */
package it.sella.jpaworkshop.exercises;

import it.sella.jpaworkshop.entities.Company;
import it.sella.jpaworkshop.entities.Customer;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExerciseFour {
    private static final String PERSISTENCE_UNIT_NAME = "TestJpa";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;

    public static void customerList() {
        initEntityMgr();        
        Query q = eMgr.createNamedQuery("Customer.findByCity");
        q.setParameter("CITY", " CHENNAI");
        List<Customer> customerList = q.getResultList();
        int count = customerList.size();
        System.out.println("Count =" + count);
        for (Customer customer : customerList) {
                System.out.print("Customer =" + customer);    
        }
        closeEntityMgr();        
    }
    
    private static void initEntityMgr() {
         eMgrFactory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
         eMgr = eMgrFactory.createEntityManager();
     }
     
     private static void closeEntityMgr() {
         eMgr.close();
         eMgrFactory.close();
     }
}