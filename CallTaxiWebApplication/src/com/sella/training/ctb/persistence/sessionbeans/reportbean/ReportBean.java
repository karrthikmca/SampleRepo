package com.sella.training.ctb.persistence.sessionbeans.reportbean;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import weblogic.javaee.JNDIName;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.NoDataFoundException;
import com.sella.training.ctb.core.properties.ErrorMessages;
import com.sella.training.ctb.persistence.sessionbeans.reportbean.interfaces.IReportBean;

@Stateless
@JNDIName("IReportBeanDetails")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
/**
 * This Report Bean Class is used to obtain various reports 
 */
public class ReportBean implements IReportBean {

	@PersistenceContext(unitName = "TaxiDetails")
	private EntityManager entityManager;

	/**
	 * This method is used to get the hired details of particular driver on a
	 * particular month
	 */
	@SuppressWarnings("unchecked")
	public List<CarBookingDetails> getBookingDetailsByDate(String month,
			Long driverId) throws InvalidBookingDetailsException,
			NoDataFoundException {
		List<CarBookingDetails> bookingDetails;
		Query query = entityManager
				.createNativeQuery("select b.cb_booking_id,b.CB_DATE_OF_BOOKING,b.CB_FROM_PLACE,b.CB_TIME_OF_BOOKING,b.CB_TO_PLACE,b.CB_AMOUNT  from CT_TR_CARBOOKING b,CT_TR_CONFIG_TD_DRI d where b.CB_CON_CONFIG_ID =d.CON_CONFIG_ID and to_char(b.CB_DATE_OF_BOOKING,'mon') like ? and d.CON_DRI_DRIVER_ID=?", CarBookingDetails.class);
		query.setParameter(1, month);
		query.setParameter(2, driverId);
		bookingDetails = query.getResultList();
		if (bookingDetails.isEmpty()) {
			throw new NoDataFoundException(
					ErrorMessages.NO_DATA_FOUND.getError());
		}
		return bookingDetails;
	}

	/**
	 * This method is used to get the details of hired Taxi based on Taxi number
	 * and hired date
	 */
	@SuppressWarnings("unchecked")
	public List<CarBookingDetails> getBookingDetailsByTaxiNumber(
			Long taxiNumber, String date) throws NoDataFoundException {
		List<CarBookingDetails> listOfBookingDetails;
		Query query = entityManager.createNativeQuery("select b.cb_booking_id,b.CB_FROM_PLACE,b.CB_TIME_OF_BOOKING,b.CB_TO_PLACE,b.CB_AMOUNT from CT_TR_CARBOOKING b,CT_TR_CONFIG_TD_DRI d where b.CB_CON_CONFIG_ID =d.CON_CONFIG_ID and (b.CB_DATE_OF_BOOKING=? and d.CON_TD_TAXI_ID =?)",CarBookingDetails.class);
		query.setParameter(1, date);
		query.setParameter(2, taxiNumber);
		listOfBookingDetails =query.getResultList();
		if (listOfBookingDetails.isEmpty()) {
			throw new NoDataFoundException(
					ErrorMessages.NO_DATA_FOUND.getError());
		}
		return listOfBookingDetails;
	}

}
