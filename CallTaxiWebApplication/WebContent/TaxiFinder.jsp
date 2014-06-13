<%@page import="com.sella.training.ctb.core.entities.Configuration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sella.training.ctb.core.entities.CarBookingDetails"%>
<%@page import="java.util.*,java.io.*,java.lang.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Taxi Details</h1>
<table align="center" border="1">
<tr><td><b>Taxi Id</b></td>
<td><b>Taxi Name</b></td>
<td><b>Minimum Amount</b></td>
<td><b>Taxi Type</b></td>
<td><b>Amount per Kilometre</b></td></tr>
<%

List<Configuration> taxiList=(List<Configuration>)request.getAttribute("taxiList");
for(Iterator<Configuration> it = taxiList.iterator();it.hasNext();)
{ 
Configuration configDetail=(Configuration)it.next();%>
<tr><td><%=configDetail.getTaxiDetails().getTaxiId()%></td>
<td><%=configDetail.getTaxiDetails().getTaxiName()%></td>
<td><%=configDetail.getTaxiDetails().getMinimumAmount()%></td>
<td><%=configDetail.getTaxiDetails().getTaxiType()%></td>
<td><%=configDetail.getTaxiDetails().getAmountPerKm()%></td></tr>
<%} %>
</table>
</body>
</html>