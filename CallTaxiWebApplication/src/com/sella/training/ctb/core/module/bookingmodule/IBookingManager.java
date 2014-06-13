package com.sella.training.ctb.core.module.bookingmodule;

import java.util.List;

import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.EjbIssuesException;
import com.sella.training.ctb.core.exceptions.InvalidCustomerException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.core.view.bookingview.CustomerView;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ICustomerBean;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ITaxiBean;

public interface IBookingManager {

	public abstract void setiTaxiBean(ITaxiBean iTaxiBean);

	public abstract void setiCustomerBean(ICustomerBean iCustomerBean);

	public abstract void bookTaxi(CustomerView customerView)
			throws InvalidCustomerException, EjbIssuesException,
			NoTaxiAvailableException;

	public abstract List<Configuration> searchTaxiByLocation(String Location)
			throws NoTaxiAvailableException;
}