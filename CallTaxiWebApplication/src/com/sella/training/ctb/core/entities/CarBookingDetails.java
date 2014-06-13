package com.sella.training.ctb.core.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "CT_TR_CARBOOKING")
public class CarBookingDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CT_SQ_CB_BOOKING_ID")
	@Column(name = "CB_BOOKING_ID")
	private Long bookingId;
	@Column(name = "CB_DATE_OF_BOOKING")
	private String dateOfBooking;
	@Column(name = "CB_TIME_OF_BOOKING")
	private String timeOfBooking;
	@Column(name = "CB_FROM_PLACE")
	private String fromPlace;
	@Column(name = "CB_TO_PLACE")
	private String toPlace;
	@Column(name = "CB_STATUS")
	private String status;
	@Column(name = "CB_AMOUNT")
	private Double amount;
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "CB_CUS_CUSTOMER_ID", referencedColumnName = "CUS_CUSTOMER_ID")
	private Customer customerDetails;
	@ManyToOne(targetEntity = Configuration.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "CB_CON_CONFIG_ID", referencedColumnName = "CON_CONFIG_ID")
	private Configuration configuration;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public String getDateOfBooking() {
		return dateOfBooking;
	}

	public void setDateOfBooking(String dateOfBooking) {
		this.dateOfBooking = dateOfBooking;
	}

	public String getTimeOfBooking() {
		return timeOfBooking;
	}

	public void setTimeOfBooking(String timeOfBooking) {
		this.timeOfBooking = timeOfBooking;
	}

	public String getFromPlace() {
		return fromPlace;
	}

	public void setFromPlace(String fromPlace) {
		this.fromPlace = fromPlace;
	}

	public String getToPlace() {
		return toPlace;
	}

	public void setToPlace(String toPlace) {
		this.toPlace = toPlace;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Customer getCustomerDetails() {
		return customerDetails;
	}

	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}

	public Configuration getConfiguration() {
		return configuration;
	}

	public void setConfiguration(Configuration configuration) {
		this.configuration = configuration;
	}

}
