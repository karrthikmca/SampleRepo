package com.sella.training.ctb.persistence.sessionbeans.bookingbean;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import weblogic.javaee.JNDIName;

import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.core.properties.Status;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ITaxiBean;

@Stateful
@JNDIName("ITaxiBeanDetails")
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class TaxiBean implements ITaxiBean {

	@PersistenceContext(unitName = "TaxiDetails")
	private EntityManager entityManager;

	public List<Configuration> getTaxiDetails(String location)
			throws NoTaxiAvailableException {
		Query query = entityManager.createNamedQuery("findTaxi");
		query.setParameter("location", location);
		query.setParameter("status", "available");
		@SuppressWarnings("unchecked")
		List<Configuration> resultList = query.getResultList();
		return resultList;
	}

	public Configuration getTaxiByLocation(String locations)
			throws NoTaxiAvailableException {

		Query query = entityManager
				.createQuery("select t from Configuration t where t.taxiLocation=?1 and t.taxiStatus=?2");
		query.setParameter(1, locations);
		query.setParameter(2, Status.AVAILABLE.getStatus());
		return (Configuration) query.getSingleResult();
	}

	
}
