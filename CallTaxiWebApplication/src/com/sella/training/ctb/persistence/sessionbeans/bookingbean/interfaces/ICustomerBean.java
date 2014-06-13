package com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces;

import javax.ejb.Remote;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.EjbIssuesException;

@Remote
public interface ICustomerBean {

	public abstract void insertCustomer(CarBookingDetails booking)
			throws EjbIssuesException;

}