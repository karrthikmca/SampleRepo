package com.sella.training.ctb.persistence.sessionbeans.bookingbean;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import weblogic.javaee.JNDIName;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.EjbIssuesException;
import com.sella.training.ctb.core.properties.ErrorMessages;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ICustomerBean;

@Stateless
@JNDIName("ICustomerBeanDetails")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class CustomerBean implements ICustomerBean {
	@PersistenceContext(unitName = "TaxiDetails")
	private EntityManager entityManager;

	public void insertCustomer(CarBookingDetails booking)
			throws EjbIssuesException {
		try {
			entityManager.persist(booking);
			entityManager.merge(booking);

		} catch (EJBException exc) {
			throw new EjbIssuesException(exc,
					ErrorMessages.TECHNICAL_PROBLEM.getError());
		}
	}
}
