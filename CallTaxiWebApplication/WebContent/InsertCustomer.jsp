<%@page import="com.sella.training.ctb.core.view.bookingview.*"%>
<%@page import="com.sella.training.ctb.core.view.bookingview.interfaces.ICustomerView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.io.*" %>
         <%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CallTaxi Booking Management</title>
</head>
<body>
<font color="red">
<%if(request.getAttribute("error")!=null)
{%>
	<%=(String)request.getAttribute("error") %>
	<%} %>
	</font>
<% ICustomerView cusView=new CustomerView();
if(request.getAttribute("customerView")!=null)
{
	cusView=(CustomerView)request.getAttribute("customerView");
}
%>
<center>
<form method="post" action="DatePlaceValidationServlet">
<table >
<tr><td> Enter From Place </td><td><input type="text" name="fromPlace" value="<%= cusView.getFromPlace() %>" />
</td></tr>
<tr><td> Enter Travelling Date (dd-MMM-yyyy) </td><td><input type="text" name="travelDate" value="<%= cusView.getDateOfBooking() %>"/>
</td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="submit"/></td></tr>
</table>
        </form>
</center>
</body>
</html>
