package com.sella.training.ctb.persistence.sessionbeans.reportbean.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.NoDataFoundException;

@Remote
public interface IReportBean {

	public abstract List<CarBookingDetails> getBookingDetailsByDate(
			String month, Long driverId) throws InvalidBookingDetailsException,
			NoDataFoundException;

	public abstract List<CarBookingDetails> getBookingDetailsByTaxiNumber(
			Long taxiNumber, String date) throws NoDataFoundException;

}