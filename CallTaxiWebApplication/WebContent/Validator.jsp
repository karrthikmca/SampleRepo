<%@page import="com.sella.training.ctb.common.utility.*"%>
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
<% IValidatorManager validate=new ValidatorManager();
	String dateBooking=request.getParameter("travelDate");
	if(validate.isValidDate(dateBooking))
	{

%>
<jsp:forward page="SearchTaxiByLocationServlet"></jsp:forward>
<% } 
else
{
%>
<jsp:forward page="InsertCustomer.jsp"></jsp:forward>
<% } %>
</body>
</html>