<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<center>To Display the details of hired Taxi based On taxi Number and Hired Date</center>
<body>
<font color="red">
<%if(request.getAttribute("error")!=null)
{%>
	<%=(String)request.getAttribute("error") %>
	<%} %>
	</font>
<% String date="";
String id="";
if(request.getAttribute("bookingDate")!=null) 
{
date=(String)request.getAttribute("bookingDate");
}
if( request.getAttribute("taxiId")!=null)
{
id=(String)request.getAttribute("taxiId");
}

%>
<form method="post" action="HiredTaxiReportGeneratorServlet">
<table >
<tr><td>Enter Taxi ID</td><td><input type="text" name="taxiId" value="<%= id %>"/>
</td></tr>
<tr><td>Enter Hired Date</td><td><input type="text" name="bookingDate" value="<%= date %>"/>
</td></tr>

<tr><td>&nbsp;</td><td><input type="submit" value="submit"/></td></tr>
</table>
</form>
</body>
</html>