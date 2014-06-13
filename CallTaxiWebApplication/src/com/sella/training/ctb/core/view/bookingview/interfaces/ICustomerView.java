package com.sella.training.ctb.core.view.bookingview.interfaces;

public interface ICustomerView {

	public abstract String getCustomerName();

	public abstract void setCustomerName(String customerName);

	public abstract String getCustomerAddress();

	public abstract void setCustomerAddress(String customerAddress);

	public abstract String getCustometContact();

	public abstract void setCustometContact(String custometContact);

	public abstract String getFromPlace();

	public abstract void setFromPlace(String fromPlace);

	public abstract String getToPlace();

	public abstract void setToPlace(String toPlace);

	public abstract String getDateOfBooking();

	public abstract void setDateOfBooking(String dateOfBooking);

	public abstract String getTimeOfBooking();

	public abstract void setTimeOfBooking(String timeOfBooking);

	public abstract String getAmount();

	public abstract void setAmount(String amount);

	public abstract String getStatus();

	public abstract void setStatus(String status);

}