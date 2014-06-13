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
<% String location="";
if(request.getAttribute("location")!=null)
{
location=(String)request.getAttribute("location");
}

%>
<form method="post" action="TaxiReportServlet">
<table >
<tr><td>Enter Location</td><td><input type="text" name="taxiLocation" value="<%= location %>"/>
</td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="submit"/></td></tr>
</table>
</form>
</body>
</html>