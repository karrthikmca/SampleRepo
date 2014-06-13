/**
 * @author   : gbs02311 
 * Created on: Jun 20, 2013 5:24:06 PM
 * Project   : SamplesJPA 
 * File Name : CriteriaJoinSamples.java
 */
package it.sella.samplejpa.criteriaapi;

import it.sella.samplejpa.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

public class CriteriaJoinSamples {

    private static final String PERSISTENCE_UNIT_NAME = "TestJpa"; //"todos";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;
    
    /**
     * SELECT t1.BK_ID, t1.BK_NAME, t1.BK_PUBLISHER, t1.BK_VERSION, t1.BK_AU_ID 
     * FROM   SAM_MA_AUTHOR t0, SAM_MA_BOOK t1  
     * WHERE ((t0.AU_FIRST_NAME = ?) AND (t0.AU_ID = t1.BK_AU_ID))
     * 
     * SELECT t1.BK_ID, t1.BK_NAME, t1.BK_PUBLISHER, t1.BK_VERSION, t1.BK_AU_ID 
     * FROM   SAM_MA_AUTHOR t0, SAM_MA_BOOK t1 
     * WHERE ((t0.AU_FIRST_NAME = ?) AND (t0.AU_ID = t1.BK_AU_ID))
     */
    public static void join() {
        initEntityMgr();
        CriteriaBuilder criteriaBuilder = eMgr.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root<Book> root = criteriaQuery.from(Book.class);
        Join join = root.join("author"); 
        //Join join = root.join("author", JoinType.RIGHT);        
        //Join join1 = root.join("author");
        criteriaQuery.where(criteriaBuilder.equal(join.get("firstName"), "Mike"));
        //criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("publisher"), "Apress"), criteriaBuilder.equal(root.get("name"), "Pro JPA 2")));
        Query query = eMgr.createQuery(criteriaQuery);
        System.out.println(">>>>>> join = " + query.getResultList());        
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