/**
 * @author   : gbs02311 
 * Created on: Jun 24, 2013 10:06:08 PM
 * Project   : SamplesJPA 
 * File Name : Jpql2Test.java
 */
package it.sella.samplejpa.jpql;

import it.sella.samplejpa.entities.ContractEmployee;
import it.sella.samplejpa.entities.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpqlSamples {
    
    private static final String PERSISTENCE_UNIT_NAME = "TestJpa";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;


    /**
     * Based on DiscriminatorValue
     */
    public static void typeExpTest() {
        initEntityMgr();        
        System.out.println("typeExpTest() : ************** ");
        Query q = eMgr.createQuery("SELECT e FROM EMPLOYEE e WHERE type(e) = :param");
        q.setParameter("param", ContractEmployee.class);
        List<Employee> empList = q.getResultList();
        for (Employee emp : empList) {
            System.out.println(emp);
        }
        int bkRowCount = empList.size();
        System.out.println("typeExpTest: empRowCount: " + bkRowCount);
        closeEntityMgr();
        
    }
    
    public static void avgTest() {
        initEntityMgr();
        System.out.println("avgTest() :>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        Query q = eMgr.createQuery("SELECT AVG(e.salary) AS s, e.type FROM EMPLOYEE e GROUP BY e.type ORDER BY s");
        List<Object[]> empList = q.getResultList();
        for (Object[] emp : empList) {
            System.out.println(emp[0]);
            System.out.println(emp[1]);
        }
        int bkRowCount = empList.size();
        System.out.println("avgTest: empRowCount: " + bkRowCount);
        closeEntityMgr();
    }

    public static void caseTest() {
        initEntityMgr();
        System.out.println("caseTest() :>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        Query q = eMgr.createQuery("SELECT e.name, e.salary, CASE WHEN (e.salary >= 29000) THEN 1 WHEN (e.salary < 22000) THEN 2 ELSE 0 END FROM EMPLOYEE e");
        List<Object[]> empList = q.getResultList();
        for (Object[] emp : empList) {
            System.out.print("Name =" + emp[0]);
            System.out.print(", Salary =" + emp[1]);
            System.out.println(", Case = " + emp[2]);
        }
        int bkRowCount = empList.size();
        System.out.println("caseTest: empRowCount: " + bkRowCount);
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