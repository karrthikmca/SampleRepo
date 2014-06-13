<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ page import="java.io.*" %>
        <%@ page isELIgnored="false" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script language="javascript">
javascript:window.history.forward(1);
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Call Taxi Booking Management</title>
</head>
<body>
<%
String username=request.getParameter("username");
String password=request.getParameter("password");
%>
<% session.setAttribute("username",username);%>
<c:choose>
<c:when test='${(param.username==("dinakar")&&param.password==("123"))}'>

<c:redirect	url="index.jsp"/>
</c:when>
<c:otherwise>
<c:redirect	url="Error.jsp"/>
</c:otherwise>
</c:choose>
</body>
</html>