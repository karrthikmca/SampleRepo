/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 9:50:33 PM
 * Project   : JpaWorkShop 
 * File Name : ExerciseThree.java
 */
package it.sella.jpaworkshop.exercises;

import it.sella.jpaworkshop.entities.Company;

import java.util.List;

import javax.persistence.AttributeOverrides;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExerciseThree {
    private static final String PERSISTENCE_UNIT_NAME = "TestJpa";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;

    public static void test() {
        initEntityMgr();        
        Query q = eMgr.createQuery("SELECT c FROM COMPANY c");
        List<Company> companyList = q.getResultList();
        int count = companyList.size();
        System.out.println("Count =" + count);
        for (Company company : companyList) {
                System.out.print("Company =" + company);    
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