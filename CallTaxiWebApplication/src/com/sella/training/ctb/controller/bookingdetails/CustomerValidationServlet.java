package com.sella.training.ctb.controller.bookingdetails;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sella.training.ctb.common.utility.IValidatorManager;
import com.sella.training.ctb.common.utility.ValidatorManager;
import com.sella.training.ctb.core.exceptions.InvalidAmountException;
import com.sella.training.ctb.core.exceptions.InvalidNameException;
import com.sella.training.ctb.core.exceptions.InvalidNumberException;
import com.sella.training.ctb.core.exceptions.InvalidTimeFormatException;
import com.sella.training.ctb.core.view.bookingview.CustomerView;
import com.sella.training.ctb.core.view.bookingview.interfaces.ICustomerView;

/**
 * This servlet is used to validate the customer details once it has been
 * entered in the "customer.jsp"
 */
@SuppressWarnings("serial")
public class CustomerValidationServlet extends HttpServlet {

	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		StringBuffer errorMessage = new StringBuffer();
		boolean validPlace=false,validAddress=false,validName = false, validNumber = false, validTime = false, validAmount = false;
		IValidatorManager validationManager = new ValidatorManager();
	
		String customerName = request.getParameter("customerName");
		String customerAddress=request.getParameter("customerAddress");
		String customerContact = request.getParameter("customerNumber");
		String timeOfBooking = request.getParameter("timeOfBooking");
		String toPlace=request.getParameter("toPlace");
		String amount = request.getParameter("amount");
		ICustomerView customerDetails = new CustomerView(request);
		/**
		 * Validate Customer Name
		 */
		try
		{
			validName = validationManager.isNameValid(customerName);
			customerDetails.setCustomerName(customerName);
		}
		catch (InvalidNameException e)
		{
			customerDetails.setCustomerName("");
			request.setAttribute("customer", customerDetails);
			errorMessage.append(e.getMessage()).append("</br>");
			request.setAttribute("error message", errorMessage.toString());
		}
		/**
		 * Validate Customer Address
		 * 
		 */
		try
		{
			validAddress=validationManager.isNameValid(customerAddress);
			customerDetails.setCustomerAddress(customerAddress);
		}
		catch (InvalidNameException e)
		{
			customerDetails.setCustomerAddress("");
			request.setAttribute("customer", customerDetails);
			errorMessage.append(e.getMessage()).append("</br>");
			request.setAttribute("error message", errorMessage.toString());
		}
		/**
		 * Validate Customer Contact Number
		 */
		try 
		{
			validNumber = validationManager.isValidContactNumber(customerContact);
			customerDetails.setCustometContact(customerContact);
		}
		catch (InvalidNumberException e)
		{

			customerDetails.setCustometContact("");
			request.setAttribute("customer", customerDetails);
			errorMessage.append(e.getMessage()).append("</br>");
			request.setAttribute("error message", errorMessage.toString());
		}
		/**
		 * Validate Booking Time
		 */
		try 
		{
			validTime = validationManager.isValidTime(timeOfBooking);
			customerDetails.setTimeOfBooking(customerDetails.getDateOfBooking().concat(timeOfBooking));
		}
		catch (InvalidTimeFormatException e)
		{
			customerDetails.setTimeOfBooking("");
			request.setAttribute("customer", customerDetails);
			errorMessage.append(e.getMessage()).append("</br>");
			request.setAttribute("error message", errorMessage.toString());
		}
		/**
		 * Validate Amount
		 */
		try
		{
			validAmount = validationManager.isValidAmount(amount);
			customerDetails.setAmount(amount);
		} 
		catch (InvalidAmountException e)
		{

			customerDetails.setAmount("");
			request.setAttribute("customer", customerDetails);
			errorMessage.append(e.getMessage()).append("</br>");
			request.setAttribute("error message", errorMessage.toString());
		}
		/**
		 * Validate To Place
		 */
		try
		{
			validPlace = validationManager.isNameValid(toPlace);
			customerDetails.setToPlace(toPlace);
		}
		catch (InvalidNameException e)
		{
			customerDetails.setToPlace("");
			request.setAttribute("customer", customerDetails);
			errorMessage.append(e.getMessage()).append("</br>");
			request.setAttribute("error message", errorMessage.toString());
		}
		/**
		 * If any of the validations fail, Redirect To previous page and also
		 * persist the previous values
		 */
		if (validName!=true || validNumber!=true || validTime!=true|| validAmount!=true||validPlace!=true||validAddress!=true) 
		{
			request.setAttribute("customer", customerDetails);
			request.setAttribute("error message", errorMessage.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("Customer.jsp");
			dispatcher.forward(request, response);
		} 
		
			/**
			 * Once,all the details of customer are validated to true,The
			 * details are passed to BookingConfirmation Servlet
			 */
			request.setAttribute("customerView", customerDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("BookingConfirmationServlet");
			dispatcher.forward(request, response);

		
	}
	
}
