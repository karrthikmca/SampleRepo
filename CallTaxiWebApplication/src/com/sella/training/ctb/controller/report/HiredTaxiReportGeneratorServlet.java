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
import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.exceptions.InvalidDateException;
import com.sella.training.ctb.core.exceptions.InvalidNumberFormatException;
import com.sella.training.ctb.core.exceptions.NoDataFoundException;
import com.sella.training.ctb.core.module.report.IReportManager;
import com.sella.training.ctb.core.module.report.ReportManagerProvider;

/**
 * This servlet is used to handle the report that is used to display
 * the taxi details based on taxiId and Booking date
 */
@SuppressWarnings("serial")
public class HiredTaxiReportGeneratorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		String taxiId = request.getParameter("taxiId");
		String date = request.getParameter("bookingDate");
		StringBuffer error = new StringBuffer();
		boolean hiredDate = false,taxiDetail=false;
		IValidatorManager validator=new ValidatorManager();
	
		try
		{
			IReportManager manage = ReportManagerProvider.getReportManager();
			hiredDate = validator.isValidDate(date);
			taxiDetail=validator.isValidNumberFormat(taxiId);
			{
				List<CarBookingDetails> details = manage.getBookingDetailsByTaxiID(Long.parseLong(taxiId), date);
				request.setAttribute("listOfBooking", details);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("ViewHiredTaxi.jsp");
			dispatcher.forward(request, response);
		}
		catch (NamingException e)
		{
			error.append(e.getMessage());

		}
		catch (InvalidDateException e) 
		{
			error.append(e.getMessage());
			request.setAttribute("error",error.toString());
			request.setAttribute("bookingDate", "");
			request.setAttribute("taxiId", taxiId);
		} 
		catch (InvalidNumberFormatException e) 
		{
			error.append(e.getMessage());
			request.setAttribute("error",error.toString());
			request.setAttribute("bookingDate", date);
			request.setAttribute("taxiId", "");
		} 
		catch (NoDataFoundException e) {
			error.append(e.getMessage());
			request.setAttribute("error",error.toString());
			request.setAttribute("bookingDate", "");
			request.setAttribute("taxiId", "");
		}
		if(hiredDate!=true||taxiDetail!=true)
		{
			request.setAttribute("error", error.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("HiredTaxiDetails.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
