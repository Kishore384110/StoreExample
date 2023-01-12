<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center><h1>Update Store</h1></center>
<form method="get" action="updateStore">
   <center>
		Store Id : 
		<input type="number" name="storeId" value=${store.storeId} readonly/>
		<br/><br/> 
		 ProductName : 
		<input type="text" name="productName" value=${store.productName} /> 
		<br/><br/>
		Quantity : 
		<input type="number" name="quantity" value=${store.quantity} /> 
		<br/><br/> 
		Price : 
		<input type="number" name="price" value=${store.price} /> 
		<br/><br/> 
		<input type="submit" value="Update" />
	</center>
</form>
</body>
</html>