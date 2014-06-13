package com.sella.training.ctb.core.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CT_TR_CUSTOMER")
public class Customer implements Serializable {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CT_SQ_CUS_CUSTOMER_ID")
	@Column(name = "CUS_CUSTOMER_ID")
	private Long customerId;
	@Column(name = "CUS_CUSTOMER_NAME")
	private String customerName;
	@Column(name = "CUS_CUSTOMER_ADDRESS")
	private String customerAddress;
	@Column(name = "CUS_CUSTOMER_CONTACT")
	private Long customerContact;
	@OneToMany(targetEntity = CarBookingDetails.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	private Set<CarBookingDetails> carbooking;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Long getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(Long customerContact) {
		this.customerContact = customerContact;
	}

	public Set<CarBookingDetails> getCarbooking() {
		return carbooking;
	}

	public void setCarbooking(Set<CarBookingDetails> carbooking) {
		this.carbooking = carbooking;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [customerId=");
		builder.append(customerId);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", customerAddress=");
		builder.append(customerAddress);
		builder.append(", customerContact=");
		builder.append(customerContact);
		builder.append(", carbooking=");
		builder.append(carbooking);
		builder.append("]");
		return builder.toString();
	}
}
