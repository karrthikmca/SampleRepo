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
<h1></h1>
<center>
<form method="post" action="TaxiServlet">
<table >
<tr><td> Taxi Name </td><td><input type="text" name="taxiName"/>
</td></tr>
<tr><td> Taxi Type </td><td><input type="text" name="taxiType"/>
</td></tr>
<tr><td> Minimum Amount </td><td><input type="text" name="minimumAmount"/>
</td></tr>
<tr><td>Amount Per Kilometre </td><td><input type="text" name="amtPerKm"/>
</td></tr>
<tr><td> Taxi Location </td><td><input type="text" name="taxiLocation"/>
</td></tr>
<tr><td> Taxi Status </td><td><input type="text" name="taxiStatus"/>
</td></tr>
<tr><td> Taxi Contact Number </td><td><input type="text" name="taxiContact"/>
</td></tr>


<tr><td>&nbsp;</td><td><input type="submit" value="submit"/></td></tr>
</table>
        </form>
</center>
</body>
</html>
