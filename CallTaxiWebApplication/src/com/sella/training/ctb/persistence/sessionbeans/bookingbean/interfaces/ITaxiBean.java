package com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces;

import java.util.List;

import javax.ejb.Remote;

import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;

@Remote
public interface ITaxiBean {

	@SuppressWarnings("rawtypes")
	public abstract List getTaxiDetails(String location)
			throws NoTaxiAvailableException;

	public abstract Configuration getTaxiByLocation(String location)
			throws NoTaxiAvailableException;

	

}