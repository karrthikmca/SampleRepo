package com.sella.training.ctb.persistence.sessionbeans.cancellationbean;

import javax.ejb.EJBException;
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
import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.EjbIssuesException;
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.core.properties.ErrorMessages;
import com.sella.training.ctb.persistence.sessionbeans.cancellationbean.interfaces.ICancellationBean;

@Stateless
@JNDIName("ICancellationBeanDetails")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CancellationBean implements ICancellationBean {

	@PersistenceContext(unitName = "TaxiDetails")
	private EntityManager entityManager;

	public void cancelBooking(CarBookingDetails booking)
			throws EjbIssuesException {
		try {
			
			entityManager.merge(booking);
		} catch (EJBException e) {
			throw new EjbIssuesException(e,
					ErrorMessages.TECHNICAL_PROBLEM.getError());
		}
	}

	public CarBookingDetails getBookingById(Long bookingId)
			throws InvalidBookingDetailsException {
		Query query = entityManager.createQuery("select b from CarBookingDetails b where b.bookingId=:bookid");
		query.setParameter("bookid", bookingId);
		CarBookingDetails booking = (CarBookingDetails) query.getSingleResult();
		return booking;
		
	}

	public Configuration getTaxiByLocation(String locations)
			throws NoTaxiAvailableException {

		Query query = entityManager
				.createQuery("select t from Configuration t where t.taxiLocation=?1 and t.taxiStatus=?2");
		query.setParameter(1, locations);
		query.setParameter(2, "unavailable");
		return (Configuration) query.getSingleResult();
	}

}
