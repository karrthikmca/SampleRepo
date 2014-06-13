package com.sella.training.ctb.core.manager.report;

import java.util.List;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.NoDataFoundException;
import com.sella.training.ctb.persistence.sessionbeans.reportbean.interfaces.IReportBean;

public class ReportManager implements IReportManager {

	private IReportBean iReportBean;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sella.training.ctb.manager.IReportManager#setiReportBean(com.sella
	 * .training.ctb.interfaces.IReportBean)
	 */
	public void setiReportBean(IReportBean iReportBean) {
		this.iReportBean = iReportBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.sella.training.ctb.manager.IReportManager#getBookingDetailsByTaxiID
	 * (java.lang.Long, java.lang.String)
	 */
	public List<CarBookingDetails> getBookingDetailsByTaxiID(Long taxiID,
			String date) throws NoDataFoundException {
		List<CarBookingDetails> bookingDetails = iReportBean.getBookingDetailsByTaxiNumber(taxiID, date);
		return bookingDetails;
	}

	public List<CarBookingDetails> getBookingDetailsByDate(String month,
			Long driverID) throws InvalidBookingDetailsException,
			NoDataFoundException {
		List<CarBookingDetails> bookingDetailsByDate = iReportBean
				.getBookingDetailsByDate(month, driverID);
		return bookingDetailsByDate;
	}
}
