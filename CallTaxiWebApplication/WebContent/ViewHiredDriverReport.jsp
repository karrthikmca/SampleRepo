<%@page import="java.util.List"%>
<%@page import="com.sella.training.ctb.core.entities.CarBookingDetails"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table align="center" border="1">
<tr><td><b>Booking Id</b></td>
<td><b>Booking Date</b></td>
<td><b>Booking Time</b></td>
<td><b>From Place</b></td>
<td><b>To Place</b></td>
<td><b>Amount</b></td></tr>
<% List<CarBookingDetails> bookingDetails=(List<CarBookingDetails>)request.getAttribute("bookingList");
	for(CarBookingDetails element:bookingDetails)
	{
		%>
	<tr><td><%=element.getBookingId() %></td>
	<td><%=element.getDateOfBooking() %></td>
	<td><%=element.getTimeOfBooking() %></td>	
	<td><%=element.getFromPlace() %></td>	
	<td><%=element.getToPlace() %></td>
	<td><%=element.getAmount() %></td>
	</tr>
<% }%>

</table>
</body>
</html>