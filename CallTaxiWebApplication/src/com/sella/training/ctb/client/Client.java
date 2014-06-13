/**
 * This is the sample client coding
 * for check and testing
 *//*

package com.sella.training.ctb.client;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.entities.Customer;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ICustomerBean;
import com.sella.training.ctb.persistence.sessionbeans.bookingbean.interfaces.ITaxiBean;

public class Client {

	public static void main(String[] args) throws Exception {
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY,
				"weblogic.jndi.WLInitialContextFactory");
		env.put(Context.PROVIDER_URL, "t3://192.50.51.45:7001");
		InitialContext ctx = new InitialContext(env);
		
		// -----------------------------------------------------------------------------------------------------
		*//** Get Taxi By Location - Related to TaxiBean *//*
		ITaxiBean taxiDetails = (ITaxiBean) ctx.lookup("ITaxiBeanDetails");

		Configuration taxiDetailsView = (taxiDetails
				.getTaxiByLocation("guindy"));
		// System.out.println(taxiDetailsView.toString());
		// CarBookingDetails car=taxiDetails.getBookingDetailsbyId(3154L);
		// System.out.println(car.getFromPlace());
		// -----------------------------------------------------------------------------------------------------

		*//** This is for Booking details Insertion- CustomerBean *//*
		ICustomerBean customerInsertion = (ICustomerBean) ctx
				.lookup("ICustomerBeanDetails");
		CarBookingDetails bookingDetails = new CarBookingDetails();
		Customer customer = new Customer();
		taxiDetailsView.setTaxiStatus("booked");
		// //config.setTaxiDetails(taxiDetailsView);
		customer.setCustomerName("arjun"); // --> Inserting Customer Details
		customer.setCustomerAddress("triplicane");
		customer.setCustomerContact(9940616337L);
		bookingDetails.setConfiguration(taxiDetailsView);
		bookingDetails.setCustomerDetails(customer);
		bookingDetails.setAmount(300.00);
		bookingDetails.setDateOfBooking("10-mar-2014");
		bookingDetails.setFromPlace("triplicane");
		bookingDetails.setToPlace("taramani");
		bookingDetails.setStatus(taxiDetailsView.getTaxiStatus());
		bookingDetails.setTimeOfBooking(bookingDetails.getDateOfBooking()
				.concat("08.55.00"));
		customerInsertion.insertCustomer(bookingDetails); // -> calls insertion
															// dao in
															// CustomerBean
		// ----------------------------------------------------------------------------------------------------

		*//** -> cancellation of status *//*

		
		 * System.out.println(ctx); ICancellationBean
		 * cancel=(ICancellationBean)ctx.lookup("ICancellationBeanDetails");
		 * CarBookingDetails booking=taxiDetails.getBookingDetailsbyId(4804L);
		 * booking.setStatus("cancelled");
		 * booking.setConfiguration(taxiDetailsView);
		 * System.out.println(booking.getConfiguration().getTaxiStatus());
		 * booking.getConfiguration().setTaxiStatus("available");
		 * cancel.cancelBooking(booking);
		 * //--------------------------------------
		 * ----------------------------------- /** -> get hired details of
		 * particular driver based on driver ID
		 

		
		 * IDriverBean driver=(IDriverBean)ctx.lookup("IDriverBeanDetails");
		 * 
		 * @SuppressWarnings("unused") List<CarBookingDetails>
		 * bookingByDriverId=driver.getDriverHiredDetails(3L); //get the booking
		 * details for particular driver ID
		 
		// -----------------------------------------------------------------------------------
	}

}
*/