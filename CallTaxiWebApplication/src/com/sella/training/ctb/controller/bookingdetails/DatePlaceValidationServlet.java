package com.sella.training.ctb.controller.bookingdetails;

import java.io.IOException;
import java.util.List;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sella.training.ctb.common.utility.IValidatorManager;
import com.sella.training.ctb.common.utility.ValidatorManager;
import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.InvalidDateException;
import com.sella.training.ctb.core.exceptions.InvalidLocationException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.core.module.bookingmodule.BookingManagerProvider;
import com.sella.training.ctb.core.module.bookingmodule.IBookingManager;
import com.sella.training.ctb.core.view.bookingview.CustomerView;
import com.sella.training.ctb.core.view.bookingview.interfaces.ICustomerView;

/**
 * This servlet is used to get the from place and date of booking from the user
 * Once the validation of date and place are true,this servlet also gets the
 * list of taxies available in specified location once,the taxi is available the
 * page is forwarded to get other details of customer
 */

@SuppressWarnings("serial")
public class DatePlaceValidationServlet extends HttpServlet {


	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		StringBuffer buffer = new StringBuffer();
		boolean validName = false, validDate = false;
		ICustomerView customerInsert = new CustomerView();
		IValidatorManager validator=new ValidatorManager();
		String fromPlace = request.getParameter("fromPlace");
		String travelDate = request.getParameter("travelDate");

		/**
		 * Validate From Place
		 */
		try 
		{
			validName = validator.isValidLocation(fromPlace);
		}
		catch (InvalidLocationException e1) 
		{
			customerInsert.setFromPlace("");
			customerInsert.setDateOfBooking(travelDate);
			request.setAttribute("customerView", customerInsert);
			buffer.append(e1.getMessage()).append("</br>");
			request.setAttribute("error", buffer.toString());
		}
		/**
		 * Validate Date of Booking i.e. Date should be in Valid format and
		 * valid date
		 */
		try
		{
			validDate =validator.isValidDate(travelDate);
		}
		catch (InvalidDateException e)
		{
			customerInsert.setDateOfBooking("");
			customerInsert.setFromPlace(fromPlace);
			request.setAttribute("customerView", customerInsert);
			buffer.append(e.getMessage()).append("</br>");
			request.setAttribute("error", buffer.toString());
		}
		/**
		 * If any of the validation fails, Control must redirect to previous JSP
		 * page to get correct details and also persist the correct values in
		 * the fields
		 */
		if ((validName != true) || (validDate != true)) 
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("InsertCustomer.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			/**
			 * If validations are correct,we need to find whether any taxies are
			 * present in the given from place.
			 */
			try
			{
				customerInsert.setFromPlace(fromPlace);
				customerInsert.setDateOfBooking(travelDate);

				@SuppressWarnings("unused")
				List<Configuration> taxiAvailability;
				IBookingManager manager = BookingManagerProvider.getBookingManager();
				taxiAvailability = manager.searchTaxiByLocation(customerInsert.getFromPlace());
				request.setAttribute("customer", customerInsert);
				

			}
			catch (NamingException e1)
			{
				buffer.append(e1.getMessage());
			}
			catch (NoTaxiAvailableException e)
			{
				buffer.append(e.getMessage());
				RequestDispatcher dispatcher = request.getRequestDispatcher("NoTaxiAvailable.jsp");
				dispatcher.forward(request, response);
			}
			/**
			 * If Taxi is present,then we will obtain the details of customer
			 * for booking
			 */
			if(validDate==true && validName==true)
			{
			RequestDispatcher dispatcher = request.getRequestDispatcher("Customer.jsp");
			dispatcher.forward(request, response);
			}
		}
	}

}
