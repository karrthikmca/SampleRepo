package com.sella.training.ctb.core.manager.bookingManager;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sella.training.ctb.common.utility.connectionprovider.InitialContextManager;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ICustomerBean;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ITaxiBean;

public class BookingManagerProvider {

	public static IBookingManager getBookingManager() throws NamingException {
		BookingManager bookManager = new BookingManager();
		InitialContext initialContext = InitialContextManager.getInstance()
				.getInitialContextInstance();
		bookManager.setiCustomerBean((ICustomerBean) initialContext
				.lookup("ICustomerBeanDetails"));
		bookManager.setiTaxiBean((ITaxiBean) initialContext
				.lookup("ITaxiBeanDetails"));
		return bookManager;
	}

}
