/**
 * @author   : gbs02311 
 * Created on: Jun 25, 2013 9:20:39 PM
 * Project   : DemoJPA 
 * File Name : PhoneElemColl.java
 */
package it.sella.samplejpa.extendmap;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PhoneElemColl {

    @Column(name="PE_TYPE")
    private String type;
    
    @Column(name="PE_AREA_CODE")
    private String areaCode;

    @Column(name="PE_NUMBER")
    private String phNumber;
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    public String getPhNumber() {
        return phNumber;
    }
    public void setPhNumber(String phNumber) {
        this.phNumber = phNumber;
    }

    @Override
    public String toString() {
      return new StringBuilder("Phone [type=").append(type)
              .append(", areaCode=").append(areaCode)
              .append(", phNumber=").append(phNumber)
              .append("]").toString();
    }
}