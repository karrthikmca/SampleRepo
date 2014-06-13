package com.sella.training.ctb.core.manager.report;

import java.util.List;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.NoDataFoundException;
import com.sella.training.ctb.persistence.sessionbeans.reportbean.interfaces.IReportBean;

public interface IReportManager {

	public abstract void setiReportBean(IReportBean iReportBean);

	public abstract List<CarBookingDetails> getBookingDetailsByTaxiID(
			Long taxiID, String date) throws NoDataFoundException;

	public abstract List<CarBookingDetails> getBookingDetailsByDate(
			String month, Long driverID) throws InvalidBookingDetailsException,
			NoDataFoundException;

}