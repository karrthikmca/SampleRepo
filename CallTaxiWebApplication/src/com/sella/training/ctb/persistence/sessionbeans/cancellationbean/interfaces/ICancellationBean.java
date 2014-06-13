package com.sella.training.ctb.persistence.sessionbeans.cancellationbean.interfaces;

import javax.ejb.Remote;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.EjbIssuesException;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;

@Remote
public interface ICancellationBean {

	public abstract void cancelBooking(CarBookingDetails booking)
			throws EjbIssuesException;
	public abstract CarBookingDetails getBookingById(Long bookingId)
	throws InvalidBookingDetailsException;
	
	public abstract Configuration getTaxiByLocation(String location)
	throws NoTaxiAvailableException;


}