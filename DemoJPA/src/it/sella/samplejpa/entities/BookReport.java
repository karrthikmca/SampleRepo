/**
 * @author   : gbs02311 
 * Created on: Jun 20, 2013 5:09:38 PM
 * Project   : DemoJPA 
 * File Name : BookReport.java
 */
package it.sella.samplejpa.entities;

public class BookReport {

    private String name;
    private String publisher;
    
    public BookReport() {        
    }
    
    public BookReport(String name, String publisher) {
        this.name = name;
        this.publisher= publisher;
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
    
    @Override
    public String toString() {
      return new StringBuilder("BookReport [name=").append(name)
              .append(", publisher=").append(publisher).append("]").toString();
    }
}