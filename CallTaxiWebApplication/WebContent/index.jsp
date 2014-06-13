<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page isELIgnored="false" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Call Taxi Booking Management</title>
</head>
<body>
<br/><br/><br/><br/>
<center>
<h2>
<%
String name=session.getAttribute("username").toString();
%>
<c:out value="CallTaxi Booking Management System"></c:out>
</br>
</br>
<c:out value="Welcome ${username}" /> 
</h2>
<br/><br/><br/><br/>
</center>
<table>
<tr><td><h4 align="justify"><a href="InsertCustomer.jsp">Book Taxi</a></h4></td></tr>
<tr><td><h4 align="justify"><a href="CancelBooking.jsp">Cancel Booking</a></h4></td></tr>
<tr><td><h4 align="justify"><a href="Report.jsp">Report</a></h4></td></tr>
<tr><td><h4 align="justify"><a href="Taxi.jsp">Add Taxi</a></h4></td></tr>
<tr><td><h4 align="justify"><a href="Driver.jsp">Add Driver</a></h4></td></tr>
<tr><td>&nbsp;</td><td></td></tr>
</table>
<center><a href="logout.jsp">logout</a></center>
</body>
