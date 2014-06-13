package com.sella.training.ctb.controller.cancellation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sella.training.ctb.core.entities.CarBookingDetails;
import com.sella.training.ctb.core.entities.Configuration;
import com.sella.training.ctb.core.exceptions.FastTrackException;
import com.sella.training.ctb.core.module.cancellationmodule.CancellationManagerProvider;
import com.sella.training.ctb.core.module.cancellationmodule.ICancellationManager;
import com.sella.training.ctb.core.properties.Status;
import com.sella.training.ctb.core.view.cancellationview.CancellationView;
import com.sella.training.ctb.core.view.cancellationview.interfaces.ICancellationView;

/**
 * This servlet is used to perform cancellation of booking Once the Booking ID
 * is given as input,this servlet is invoked If the BookingID does not exist, it
 * redirects to previous page and displays the error message
 */
@SuppressWarnings("serial")
public class BookingCancellationServlet extends HttpServlet 
{

	StringBuffer errorAppender = new StringBuffer();

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		ICancellationView cancellation = new CancellationView();
		String bookingId = request.getParameter("bookingId");
		
		try 
		{
			
			ICancellationManager cancelBooking = CancellationManagerProvider.getCancellationManager();
			CarBookingDetails bookingDetails = cancelBooking.getBookingById(Long.parseLong(bookingId));
			bookingDetails.setStatus(Status.CANCELLED.getStatus());
			Configuration config=cancelBooking.getTaxiByLocation(bookingDetails.getFromPlace());
			bookingDetails.setConfiguration(config);
			bookingDetails.getConfiguration().setTaxiStatus(Status.AVAILABLE.getStatus());
			cancelBooking.cancelBooking(bookingDetails);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CancelSuccessful.jsp");
			dispatcher.forward(request, response);
		} 
		catch (NumberFormatException e)
		{
			errorAppender.append(e.getMessage());
			request.setAttribute("error", errorAppender.toString());
			cancellation.setBookingId("");
			request.setAttribute("cancelView", cancellation);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CancelBooking.jsp");
			dispatcher.forward(request, response);
		} 
		
		catch (NamingException e) 
		{
			errorAppender.append(e.getMessage());
			out.println(errorAppender);
			request.setAttribute("error", errorAppender.toString());
			request.setAttribute("cancelView", cancellation);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CancelBooking.jsp");
			dispatcher.forward(request, response);
		} 
		catch (FastTrackException e) {
			
			errorAppender.append(e.getMessage());
			out.println(errorAppender);
			request.setAttribute("error", errorAppender.toString());
			request.setAttribute("cancelView", cancellation);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CancelBooking.jsp");
			dispatcher.forward(request, response);
		} 
		
	}

}
