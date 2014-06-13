/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 8:00:46 PM
 * Project   : JpaWorkShop 
 * File Name : ExerciseTwo.java
 */
package it.sella.jpaworkshop.exercises;

import it.sella.jpaworkshop.entities.Person;
import it.sella.jpaworkshop.entities.Vehicle;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExerciseTwo {
    private static final String PERSISTENCE_UNIT_NAME = "TestJpa";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;

    public static void test() {
        initEntityMgr();        
        Query q = eMgr.createQuery("SELECT p FROM PERSON p");
        List<Person> personList = q.getResultList();
        int personCount = personList.size();
        System.out.println("elementCollection: empRowCount: " + personCount);
        for (Person emp : personList) {
            final List<Vehicle> vehicleList = emp.getVehicles();
            int count = vehicleList.size();
            System.out.println("elementCollection: count: " + count);            
            for(Vehicle vehicle : vehicleList) {
                System.out.print("Vehicle =" + vehicle);    
            }
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