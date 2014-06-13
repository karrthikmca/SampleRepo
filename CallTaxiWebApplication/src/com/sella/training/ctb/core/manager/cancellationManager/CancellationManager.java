package com.sella.training.ctb.core.manager.cancellationManager;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.EjbIssuesException;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.persistence.sessionbeans.cancellationbean.interfaces.ICancellationBean;

public class CancellationManager implements ICancellationManager {

	private ICancellationBean iCancellationBean;

	
	public void setiCancellationBean(ICancellationBean iCancellationBean) {
		this.iCancellationBean = iCancellationBean;
	}

	public CarBookingDetails getBookingById(Long bookingId) throws InvalidBookingDetailsException
	{
		return iCancellationBean.getBookingById(bookingId);
	}
	public void cancelBooking(CarBookingDetails booking)
			throws EjbIssuesException {
		iCancellationBean.cancelBooking(booking);
	}
	public Configuration getTaxiByLocation(String locations)
	throws NoTaxiAvailableException {
		return iCancellationBean.getTaxiByLocation(locations);
	}
}
