package com.sella.training.ctb.controller.bookingdetails;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sella.training.ctb.core.exceptions.EjbIssuesException;
import com.sella.training.ctb.core.exceptions.InvalidCustomerException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.core.module.bookingmodule.BookingManagerProvider;
import com.sella.training.ctb.core.module.bookingmodule.IBookingManager;
import com.sella.training.ctb.core.view.bookingview.CustomerView;
import com.sella.training.ctb.core.view.bookingview.interfaces.ICustomerView;

/**
 * This servlet is used to get the customer details and then pass it to DB for
 * inserting the booking confirmation details
 */
@SuppressWarnings("serial")
public class BookingConfirmationServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		try
		{
		IBookingManager bookingManager = BookingManagerProvider.getBookingManager();
		ICustomerView customer = (CustomerView) request.getAttribute("customerView");
			try 
			{
				bookingManager.bookTaxi((CustomerView) customer);
				RequestDispatcher dispatcher = request.getRequestDispatcher("BookingSuccessful.jsp");
				dispatcher.forward(request, response);
			} 
			catch (InvalidCustomerException e)
			{
				out.println("Error:" + e.getMessage());
			}
			catch (EjbIssuesException e)
			{
				out.println("Error:" + e.getMessage());
			}
			catch (NoTaxiAvailableException e)
			{
				out.println("Error:" + e.getMessage());
			}
		}
		catch (NamingException e) 
		{
			out.println("Error:" + e.getMessage());
		}

	}

}
