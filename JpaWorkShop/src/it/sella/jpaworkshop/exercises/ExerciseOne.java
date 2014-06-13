/*
 * @author   : gbs02311 
 * Created on: Jun 27, 2013 7:26:47 PM
 * Project   : JpaWorkShop 
 * File Name : ExerciseOne.java
 */
package it.sella.jpaworkshop.exercises;

import it.sella.jpaworkshop.entities.Mobile;
import it.sella.jpaworkshop.entities.Phone;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ExerciseOne {

    private static final String PERSISTENCE_UNIT_NAME = "TestJpa"; //"todos";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;

    
    public static void phoneList() {
        initEntityMgr();
        Query q = eMgr.createQuery("SELECT m FROM TELEPHONE m");
        List<Phone> phoneList = q.getResultList();
        int count = phoneList.size();
        System.out.println("indexTest: Count: " + count);
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
        closeEntityMgr();
    }
    
    public static void mobileList() {
        initEntityMgr();
        Query q = eMgr.createQuery("SELECT m FROM MOBILE m");
        List<Mobile> mobileList = q.getResultList();
        int count = mobileList.size();
        System.out.println("indexTest: Count: " + count);
        for (Mobile mobile : mobileList) {
            System.out.println(mobile);
        }
        closeEntityMgr();
    }

    public static void mobilePersist() {
        initEntityMgr();
        Mobile mobile = new Mobile();
        mobile.setNumber("111111111");
        mobile.setType("CELL");                      
        eMgr.persist(mobile);
        closeEntityMgr();
    }

    public static void phonePersist() {
        initEntityMgr();
        Phone phone = new  Phone();
        phone.setNumber("111111111");
        phone.setType("PHONE");                      
        phone.setAreaCode("04546");
        eMgr.persist(phone);
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