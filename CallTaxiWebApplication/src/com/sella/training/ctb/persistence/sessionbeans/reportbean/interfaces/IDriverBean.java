package com.sella.training.ctb.persistence.sessionbeans.reportbean.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;

@Remote
public interface IDriverBean {

	public abstract List<CarBookingDetails> getDriverHiredDetails(Long driverID)
			throws InvalidBookingDetailsException;

}