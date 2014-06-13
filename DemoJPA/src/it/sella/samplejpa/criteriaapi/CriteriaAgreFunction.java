/**
 * @author   : gbs02311 
 * Created on: Jun 20, 2013 6:44:17 PM
 * Project   : SamplesJPA 
 * File Name : CriteriaAgreFun.java
 */
package it.sella.samplejpa.criteriaapi;

import it.sella.samplejpa.entities.Book;
import it.sella.samplejpa.entities.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

public class CriteriaAgreFunction {
    private static final String PERSISTENCE_UNIT_NAME = "TestJpa"; //"todos";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;

    public static void  avg() {
        initEntityMgr();
        CriteriaBuilder criteriaBuilder = eMgr.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
        Root root = criteriaQuery.from(Employee.class);
        Expression avg = criteriaBuilder.avg(root.get("salary"));
        criteriaQuery.multiselect(avg.alias("1"), root.get("type").alias("2"));
        criteriaQuery.groupBy(root.get("type"));
        Query qry = eMgr.createQuery(criteriaQuery);
        List<Tuple> empList = qry.getResultList();
        printList(empList);
        closeEntityMgr();
    }
    
    private static void printList(List<Tuple> empList) {
        System.out.println("\n >>>> avg(): Total Number of EmployeeObj = " + empList.size());
        for(Tuple tuple : empList) {
            System.out.println("\n >>>> avg(): avg = " + tuple.get("1"));
            System.out.println("\n >>>> avg(): Type = " + tuple.get("2"));
        }
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