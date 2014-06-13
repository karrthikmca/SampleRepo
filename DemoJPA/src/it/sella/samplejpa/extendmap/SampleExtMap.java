/**
 * @author   : gbs02311 
 * Created on: Jun 26, 2013 9:12:32 PM
 * Project   : DemoJPA 
 * File Name : SampleExtMap.java
 */
package it.sella.samplejpa.extendmap;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SampleExtMap {
    
    private static final String PERSISTENCE_UNIT_NAME = "TestJpa";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;

    public static void elementCollection() {
        initEntityMgr();        
        System.out.
        println("elementCollection() : >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
        Query q = eMgr.createQuery("SELECT e FROM EMP_ELEMENT e");

        List<EmployeeElemColl> empList = q.getResultList();
        int empCount = empList.size();
        System.out.println("elementCollection: empRowCount: " + empCount);
        
        System.out.println("\n \n /************** EMPLOYEE WITH PHONE **************/ \n");
        
        for (EmployeeElemColl emp : empList) {
        
            
            final List<PhoneElemColl> phoneList = emp.getPhoneElemColl();
            System.out.println(emp + ", Collection =" + phoneList + "\n ################# PHONE ####################### \n ");
            int phCount = phoneList.size();
            System.out.println("elementCollection: phoneCount: " + phCount);            
            for(PhoneElemColl phone : phoneList) {
                System.out.print("Phone=" + phone);    
            }
            
            System.out.println("\n \n /************** NEXT EMPLOYEE WITH PHONE **************/ \n");            
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