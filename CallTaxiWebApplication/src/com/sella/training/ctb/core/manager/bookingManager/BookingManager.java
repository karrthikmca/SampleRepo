package com.sella.training.ctb.core.manager.bookingManager;

import java.util.List;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.entities.Customer;
import com.sella.training.ctb.core.exceptions.EjbIssuesException;
import com.sella.training.ctb.core.exceptions.InvalidCustomerException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.core.properties.ErrorMessages;
import com.sella.training.ctb.core.view.bookingview.CustomerView;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ICustomerBean;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ITaxiBean;

public class BookingManager implements IBookingManager {

	private ITaxiBean iTaxiBean;
	private ICustomerBean iCustomerBean;

	public void setiTaxiBean(ITaxiBean iTaxiBean) {
		this.iTaxiBean = iTaxiBean;
	}

	public void setiCustomerBean(ICustomerBean iCustomerBean) {
		this.iCustomerBean = iCustomerBean;
	}

	public List<Configuration> searchTaxiByLocation(String Location)
			throws NoTaxiAvailableException {
		@SuppressWarnings("unchecked")
		List<Configuration> taxiDetails = iTaxiBean.getTaxiDetails(Location);

		if (taxiDetails.isEmpty()) {
			throw new NoTaxiAvailableException(
					ErrorMessages.NO_TAXI_AVAILABLE.getError());
		} else {
			return taxiDetails;
		}
	}

	public void bookTaxi(CustomerView customerView)
			throws InvalidCustomerException, EjbIssuesException,
			NoTaxiAvailableException {
		Customer customer = new Customer();
		String customerName = customerView.getCustomerName();
		String customerAddress = customerView.getCustomerAddress();
		String customerContact = customerView.getCustometContact();
		customer.setCustomerName(customerName);
		customer.setCustomerAddress(customerAddress);
		customer.setCustomerContact(Long.parseLong(customerContact));
		CarBookingDetails booking = getBooking(customerView);
		booking.setCustomerDetails(customer);
		Configuration config = iTaxiBean.getTaxiByLocation(customerView
				.getFromPlace());
		config.setTaxiStatus("unavailable");
		booking.setConfiguration(config);
		iCustomerBean.insertCustomer(booking);
	}

	private CarBookingDetails getBooking(CustomerView customerView) {
		CarBookingDetails bookingDetails = new CarBookingDetails();
		bookingDetails.setDateOfBooking(customerView.getDateOfBooking());
		bookingDetails.setTimeOfBooking(customerView.getTimeOfBooking());
		bookingDetails.setFromPlace(customerView.getFromPlace());
		bookingDetails.setToPlace(customerView.getToPlace());
		bookingDetails.setAmount(Double.parseDouble(customerView.getAmount()));
		bookingDetails.setStatus(customerView.getStatus());
		return bookingDetails;
	}
}
