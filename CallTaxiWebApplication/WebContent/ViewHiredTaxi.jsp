<%@page import="com.sella.training.ctb.core.entities.CarBookingDetails"%>
<%@page import="java.util.*,java.io.*,java.lang.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Taxi Hired Details</h1>
<table align="center" border="1">
<tr><td><b>Booking Id</b></td>
<td><b>Source Place</b></td>
<td><b>Destination Place</b></td></tr>
<%

List<CarBookingDetails> taxiList=(List<CarBookingDetails>)request.getAttribute("listOfBooking");
for(Iterator<CarBookingDetails> it = taxiList.iterator();it.hasNext();)
{ 
CarBookingDetails bookingDetail=(CarBookingDetails)it.next();%>
<tr><td><%=bookingDetail.getBookingId()%></td>
<td><%=bookingDetail.getFromPlace()%></td>
<td><%=bookingDetail.getToPlace()%></td></tr>
<%} %>
</table>
</body>
</html>