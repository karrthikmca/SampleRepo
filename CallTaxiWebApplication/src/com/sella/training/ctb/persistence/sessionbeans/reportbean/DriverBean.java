package com.sella.training.ctb.persistence.sessionbeans.reportbean;

import java.util.Iterator;
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
import com.sella.training.ctb.persistence.sessionbeans.reportbean.interfaces.IDriverBean;

@Stateless
@JNDIName("IDriverBeanDetails")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class DriverBean implements IDriverBean {

	@PersistenceContext(unitName = "TaxiDetails")
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<CarBookingDetails> getDriverHiredDetails(Long driverID)
			throws InvalidBookingDetailsException {
		Query query = entityManager
				.createQuery(" select b from CarBookingDetails b where b.configuration.driverDetails.driverId=?");
		query.setParameter(0, driverID);
		query.executeUpdate();
		List<CarBookingDetails> list = query.getResultList();
		for (Iterator<CarBookingDetails> iterator = list.iterator(); iterator
				.hasNext();) {
			CarBookingDetails driverObj = (CarBookingDetails) iterator.next();
			driverObj.getBookingId();
		}
		return list;// return null

	}

}
