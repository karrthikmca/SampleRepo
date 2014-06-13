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
import com.sella.training.ctb.core.exceptions.InvalidBookingDetailsException;
import com.sella.training.ctb.core.exceptions.InvalidNameException;
import com.sella.training.ctb.core.exceptions.InvalidNumberFormatException;
import com.sella.training.ctb.core.exceptions.NoDataFoundException;
import com.sella.training.ctb.core.module.report.IReportManager;
import com.sella.training.ctb.core.module.report.ReportManagerProvider;

/**
 * This servlet is to handle the report to display the hired details of
 * particular driver on a particular month
 */
@SuppressWarnings("serial")
public class DriverReportServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		
		StringBuffer errorMessage = new StringBuffer();
		String driverId = request.getParameter("driverId");
		String month = request.getParameter("month");
		IReportManager report;
		try
		{
			IValidatorManager validate=new ValidatorManager();
			validate.isValidNumberFormat(driverId);
			validate.isNameValid(month);
			report = ReportManagerProvider.getReportManager();
			List<CarBookingDetails> bookingList = (List<CarBookingDetails>)report.getBookingDetailsByDate(month, Long.parseLong(driverId));
			if (!bookingList.isEmpty())
			{
				request.setAttribute("bookingList",bookingList);
				RequestDispatcher dispatcher = request.getRequestDispatcher("ViewHiredDriverReport.jsp");
				dispatcher.forward(request, response);
			}
		} 
		catch (NamingException e) 
		{
			errorMessage.append(e.getMessage());
			RequestDispatcher dispatcher = request.getRequestDispatcher("HiredDriverDetails.jsp");
			dispatcher.forward(request, response);
		} 
		catch (InvalidNumberFormatException e)
		{
			request.setAttribute("driverIdDetail", "");
			request.setAttribute("month", month);	
			errorMessage.append(e.getMessage());
			request.setAttribute("error", errorMessage.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("HiredDriverDetails.jsp");
			dispatcher.forward(request, response);
		} catch (InvalidNameException e)
		{
			
			request.setAttribute("driverIdDetail", driverId);
			request.setAttribute("month", "");
			errorMessage.append(e.getMessage());
			request.setAttribute("error", errorMessage.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("HiredDriverDetails.jsp");
			dispatcher.forward(request, response);
		} 
		catch (NoDataFoundException e) 
		{
			errorMessage.append(e.getMessage());
			request.setAttribute("error", errorMessage.toString());
			request.setAttribute("driverIdDetail", "");
			request.setAttribute("month", "");
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("HiredDriverDetails.jsp");
			dispatcher.forward(request, response);
		} 
		catch (InvalidBookingDetailsException e) 
		{
			request.setAttribute("driverIdDetail", "");
			request.setAttribute("month", "");
			errorMessage.append(e.getMessage());
			request.setAttribute("error", errorMessage.toString());
			RequestDispatcher dispatcher = request.getRequestDispatcher("HiredDriverDetails.jsp");
			dispatcher.forward(request, response);
		}
	}

}
