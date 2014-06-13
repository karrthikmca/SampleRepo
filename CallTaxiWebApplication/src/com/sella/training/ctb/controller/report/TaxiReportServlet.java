package com.sella.training.ctb.controller.report;

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
import com.sella.training.ctb.core.exceptions.InvalidLocationException;
import com.sella.training.ctb.core.exceptions.NoTaxiAvailableException;
import com.sella.training.ctb.core.module.bookingmodule.BookingManagerProvider;
import com.sella.training.ctb.core.module.bookingmodule.IBookingManager;

/**
 * Servlet implementation class TaxiReportServlet
 * This servlet is used to handle the report to display the list of taxies available in specified location
 */
@SuppressWarnings("serial")
public class TaxiReportServlet extends HttpServlet {

	

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{

		StringBuffer errorMessage = new StringBuffer();
		String taxiLocation = request.getParameter("taxiLocation");
		IValidatorManager validate=new ValidatorManager();
		try
		{
			validate.isValidLocation(taxiLocation);
			IBookingManager report = BookingManagerProvider.getBookingManager();
			List<Configuration> taxiDetails = report.searchTaxiByLocation(taxiLocation);
			if (taxiDetails.size() > 0) 
				{
				request.setAttribute("taxiList", taxiDetails);
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("TaxiFinder.jsp");
				dispatcher.forward(request, response);
				}
			} 
		catch (NamingException e) {
			errorMessage.append(e.getMessage());

		}
		catch (NoTaxiAvailableException e) {

			errorMessage.append(e.getMessage());
			request.setAttribute("location", taxiLocation);
			request.setAttribute("error", errorMessage.toString());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("TaxiLocation.jsp");
			dispatcher.forward(request, response);
		} 
		catch (InvalidLocationException e) {
			
			errorMessage.append(e.getMessage());
			request.setAttribute("location", taxiLocation);
			request.setAttribute("error", errorMessage.toString());
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("TaxiLocation.jsp");
			dispatcher.forward(request, response);
		}
	}

}
