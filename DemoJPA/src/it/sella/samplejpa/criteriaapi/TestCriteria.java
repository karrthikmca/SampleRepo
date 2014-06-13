/**
 * @author   : gbs02311 
 * Created on: Jun 22, 2013 1:36:34 PM
 * Project   : SampleJPA 
 * File Name : TestCriteria.java
 */
package it.sella.samplejpa.criteriaapi;


public class TestCriteria {

    public static void main(String[] args) {
        
        CriteriaSamples.listOfBooks();
        
        CriteriaSamples.listOfEmployees();
        
        CriteriaSamples.select();
        
        //CriteriaSamples.metaModel();
        
        CriteriaJoinSamples.join();
       
        CriteriaAgreFunction.avg();
    }
}