/**
 * @author   : gbs02311 
 * Created on: Jun 20, 2013 2:05:53 PM
 * Project   : DemoJPA 
 * File Name : Book.java
 */
package it.sella.samplejpa.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity(name="BOOK")
@Table(name="SAM_MA_BOOK")
@SequenceGenerator(name="BK_SQ", sequenceName="SAM_SQ_BK_ID", allocationSize=1)
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.TABLE, generator="BK_SQ")
    @Column(name="BK_ID")
    private int id;
    
    @Column(name="BK_NAME")
    private String name;

    @Column(name="BK_PUBLISHER")
    private String publisher;

    //@Column(name="BK_AUTHOR")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)    
    @JoinColumn(name="BK_AU_ID", insertable=true, updatable=true, nullable=true, unique=true)
    //private String author;
    private Author author;

    @Column(name="BK_VERSION")
    @Version
    private long version;

    public Book() {        
    }
    
    public Book(String name) {
        this.name = name;
    }
    
    public Book(String name, String publisher) {
        this.name = name;
        this.publisher= publisher;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public long getVersion() {
        return version;
    }
    public void setVersion(long version) {
        this.version = version;
    }
    
    @Override
    public String toString() {
      return new StringBuilder("Book [id=").append(id)
              .append(", name=").append(name)
              .append(", publisher=").append(publisher)
              .append(", version=").append(version)
              .append(", Author=").append(author).append("]").toString();
    }
}