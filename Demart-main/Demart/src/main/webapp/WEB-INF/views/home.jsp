<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
    
    <center><h1>Store DataTable</h1></center>
		<table border="3" align="center">
			<tr>
				<th>StockId</th>
				<th>ProductName</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		<c:forEach var="e" items="${storelist}">
			<tr>
				<td>${e.storeId}</td>
				<td>${e.productName}</td>
				<td>${e.quantity}</td>
				<td>${e.price}</td>
				<td>
        			<a href="editStore?storeId=${e.storeId}">Update</a>
        			</td>
        		<td>
        			<a href="deleteStore?storeId=${e.storeId}">Delete</a>
        		</td>
		</c:forEach>
		</table>
		<center>
		        <h3><a href="newStore">Add Demart</a></h3>
		</center>
    </body>
</html>
