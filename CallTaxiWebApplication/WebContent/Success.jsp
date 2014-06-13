<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CallTaxi Booking Management</title>
</head>
<body>
<h2>
<%
String name=session.getAttribute("username").toString();
%>
<c:out value="Hi ${username}" /> 
</h2>
<br>
<h1>Data has been inserted Successfully!!!!</h1>
<a href="index.jsp">Home</a>
<a href="logout.jsp">logout</a>
</body>
</html>