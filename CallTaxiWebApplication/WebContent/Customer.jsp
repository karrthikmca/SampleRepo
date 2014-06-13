<%@page import="com.sella.training.ctb.core.view.bookingview.CustomerView"%>
<%@page import="com.sella.training.ctb.core.view.bookingview.interfaces.ICustomerInsertionView"%>
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
<font color="red">
<%if(request.getAttribute("error message")!=null)
{%>
	<%=(String)request.getAttribute("error message") %>
	<%} %>
	</font>
<% CustomerView customer=new CustomerView();
if(request.getAttribute("customer")!=null)
{
	customer=(CustomerView)request.getAttribute("customer");
}

%>
<form method="post" action="CustomerValidationServlet">
<table >
<tr><td>Customer Name</td><td><input type="text" name="customerName" value="<%= customer.getCustomerName()%>"/>
</td></tr>
<tr><td>Customer Address</td><td><input type="text" name="customerAddress" value="<%= customer.getCustomerAddress()%>"/>
</td></tr>
<tr><td>Customer contact Number</td><td><input type="text" name="customerNumber" value="<%= customer.getCustometContact()%>"/>
</td></tr>
<tr><td>From Place</td><td><input type="text" name="fromPlace" value="<%= customer.getFromPlace()%>" readonly="readonly"/>
</td></tr>
<tr><td>To Place</td><td><input type="text" name="toPlace" value="<%= customer.getToPlace()%>"/>
</td></tr>
<tr><td>Date Of Booking</td><td><input type="text" name="dateOfBooking"  value="<%= customer.getDateOfBooking()%>" readonly="readonly"/>
</td></tr>
<tr><td>Time Of Booking</td><td><input type="text" name="timeOfBooking" value="<%= customer.getTimeOfBooking()%>"/>
</td></tr>
<tr><td>Amount</td><td><input type="text" name="amount" value="<%= customer.getAmount()%>"/>
</td></tr>
<tr><td>Status</td><td><input type="text" name="status" value="Booked" readonly="readonly"/>
</td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="submit"/></td></tr>
</table>
        </form>
</body>
</html>