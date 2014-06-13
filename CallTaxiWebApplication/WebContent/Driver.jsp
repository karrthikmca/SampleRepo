<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CallTaxi Booking Management</title>
</head>
<body>
<h1>Login Page</h1>
<center>
<form method="post" action="DriverServlet">
<table >
<tr><td> Driver Name </td><td><input type="text" name="driverName"/>
</td></tr>
<tr><td> Driver Address </td><td><input type="text" name="driverAddress"/>
</td></tr>
<tr><td> Driver Contact Number </td><td><input type="text" name="driverContact"/>
</td></tr>
<tr><td>Registration Number </td><td><input type="text" name="registrationNumber"/>
</td></tr>
<tr><td>&nbsp;</td><td><input type="submit" value="submit"/></td></tr>
</table>
        </form>
</center>
</body>
</html>
