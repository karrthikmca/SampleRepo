/**
 * @author   : gbs02311 
 * Created on: Jun 21, 2013 2:13:05 PM
 * Project   : SampleJPA 
 * File Name : PersistSamples.java
 */
package it.sella.samplejpa.persist;

import it.sella.samplejpa.entities.Author;
import it.sella.samplejpa.entities.Book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PersistSamples {
    private static final String PERSISTENCE_UNIT_NAME = "TestJpa"; //"todos";
    private static EntityManagerFactory eMgrFactory = null; 
    private static EntityManager eMgr = null;

    public static void  persistBook() {
        initEntityMgr();
   
        Book book = new Book();
        book.setName("HIBERNATE"); // Pro JPA 2
        book.setPublisher("Apress");
        
        Author author = new Author();
        author.setFirstName("Kavin"); //Mike
        author.setLastName("Keith");
        
        book.setAuthor(author);
        eMgr.getTransaction().begin();
        
        eMgr.persist(book);
        
        eMgr.getTransaction().commit();
        
        listOFBooks();
        
        closeEntityMgr();
    }
    
    public static void  mergeBook() {
        initEntityMgr();
        
        System.out.println("\n Before merge --> ");
        listOFBooks();
        
        Book book = eMgr.find(Book.class, 6);
        book.setPublisher("After Merge");
        
        eMgr.getTransaction().begin();
        
        eMgr.merge(book);
        
        eMgr.getTransaction().commit();
        
        
        closeEntityMgr();
    }
    
    public static void  deleteBook() {
        initEntityMgr();

        System.out.println("\n Before Delete --> ");
        listOFBooks();
        
        Book book = eMgr.find(Book.class, 6);
                
        eMgr.getTransaction().begin();
        
        eMgr.remove(book);
        
        eMgr.getTransaction().commit();
        
        System.out.println("\n After Delete --> ");
        listOFBooks();
        closeEntityMgr();
    }
    
    private static void listOFBooks() {
        Query q = eMgr.createQuery("select b from BOOK b");
        List<Book> bkList = q.getResultList();
        for (Book bk : bkList) {
            System.out.println(bk);
        }
        int bkRowCount = bkList.size();
        System.out.println("empRowCount: " + bkRowCount);
        System.out.println("\n Total Number of Book = " + bkList.size() + "\n List of of Book = " + bkList);
    }

    public static void listOfBookNames() {
        Query q = eMgr.createQuery("select b.name from BOOK b");
        List<Book> bkList = q.getResultList();
        for (Book bk : bkList) {
            System.out.println(bk);
        }
        int bkRowCount = bkList.size();
        System.out.println("\n >> listOFBookNames(): empRowCount: " + bkRowCount);
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