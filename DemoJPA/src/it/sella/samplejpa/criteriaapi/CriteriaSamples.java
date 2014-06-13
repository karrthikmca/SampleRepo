/**
 * @author : gbs02311 
 * Created on: Jun 20, 2013 1:51:13 PM 
 * Project : DemoJPA
 * File Name : CriteriaSamples.java
 */
package it.sella.samplejpa.criteriaapi;

import it.sella.samplejpa.entities.Book;
import it.sella.samplejpa.entities.Employee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class CriteriaSamples {

    private static final String PERSISTENCE_UNIT_NAME = "TestJpa"; //"todos";
    private static EntityManagerFactory eMgrFactory = null;
    private static EntityManager eMgr = null;

    public static void listOfBooks() {
        initEntityMgr();
        CriteriaBuilder criteriaBuilder = eMgr.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Book.class);
        //criteriaQuery.where(criteriaBuilder.equal(root.get("name"), "Pro JPA 2"));
        //criteriaQuery.where(criteriaBuilder.equal(root.get("name"), criteriaBuilder.upper(criteriaBuilder.parameter(String.class, "name"))));
        criteriaQuery.orderBy(criteriaBuilder.asc(criteriaBuilder.upper(root.get("name"))));
        Query qry = eMgr.createQuery(criteriaQuery);
        //qry.setParameter("name", "hibernate");
        List<Book> bookList = qry.getResultList();
        System.out.println("\n Total Number of Book = " + bookList.size() + "\n List of of Book = " + bookList);
        closeEntityMgr();
    }

    public static void listOfEmployees() {
        initEntityMgr();
        CriteriaBuilder criteriaBuilder = eMgr.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Employee.class);        
        //criteriaQuery.orderBy(criteriaBuilder.asc(criteriaBuilder.upper(root.get("name"))));
        Query qry = eMgr.createQuery(criteriaQuery);
        List<Employee> bookList = qry.getResultList();
        System.out.println("\n Total Number of Book = " + bookList.size() + "\n List of of Book = " + bookList);
        closeEntityMgr();
    }

    public static void select() {
        initEntityMgr();
        CriteriaBuilder criteriaBuilder = eMgr.getCriteriaBuilder();
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery();
        Root root = criteriaQuery.from(Book.class);
        //criteriaQuery.select(root.get("name"));
        //criteriaQuery.select(criteriaBuilder.construct(BookReport.class, root.get("name"), root.get("publisher")));
        //criteriaQuery.select(root.get("name"), root.get("publisher"));
        criteriaQuery.multiselect(root.get("name"), root.get("publisher"));
        Query qry = eMgr.createQuery(criteriaQuery);
        //List<String> bookList = qry.getResultList();
        //List<BookReport> bookList = qry.getResultList();
        List<Object[]> bookList = qry.getResultList();
        System.out.println("\n Total Number of Book = " + bookList.size() + "\n List of of Book = " + bookList);
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