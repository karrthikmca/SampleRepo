package com.sella.training.ctb.core.view.bookingview;

import javax.servlet.http.HttpServletRequest;

import com.sella.training.ctb.core.view.bookingview.interfaces.ICustomerView;

public class CustomerView implements ICustomerView {

	private String customerName;
	private String customerAddress;
	private String custometContact;
	private String fromPlace;
	private String toPlace;
	private String dateOfBooking;
	private String timeOfBooking;
	private String amount;
	private String status;

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

	public String getCustometContact() {
		return custometContact;
	}

	public void setCustometContact(String custometContact) {
		this.custometContact = custometContact;
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

	public String getAmount()
	{
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public CustomerView() {
		super();
		this.customerName = "";
		this.customerAddress = "";
		this.custometContact = "";
		this.fromPlace = "";
		this.toPlace = "";
		this.dateOfBooking = "";
		this.timeOfBooking = "";
		this.amount ="";
		this.status = "";
	}

	public CustomerView(HttpServletRequest request) {
		this.customerName = request.getParameter("customerName");
		this.customerAddress = request.getParameter("customerAddress");
		this.custometContact = request.getParameter("customerContact");
		this.fromPlace = request.getParameter("fromPlace");
		this.toPlace = request.getParameter("toPlace");
		this.dateOfBooking = request.getParameter("dateOfBooking");
		this.timeOfBooking = request.getParameter("timeOfBooking");
		this.amount = (request.getParameter("amount"));
		this.status = request.getParameter("status");
	}

}
