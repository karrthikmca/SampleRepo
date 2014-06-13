<%@page import="com.sella.training.ctb.core.view.cancellationview.*"%>
<%@page import="com.sella.training.ctb.core.view.cancellationview.interfaces.ICancellationView"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">
<%if(request.getAttribute("error")!=null)
{%>
	<%=(String)request.getAttribute("error") %>
	<%} %>
	</font>
<% ICancellationView cancelView=new CancellationView();
if(request.getAttribute("cancelView")!=null)
{
	cancelView=(CancellationView)request.getAttribute("cancelView");
}
%>
<center>
<form method="post" action="BookingCancellationServlet">
<table >
<tr><td> Enter Booking ID </td><td><input type="text" name="bookingId" value="<%= cancelView.getBookingId() %>" />
</td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="submit"/></td></tr>
</table>
        </form>
</center>
</body>
</html>