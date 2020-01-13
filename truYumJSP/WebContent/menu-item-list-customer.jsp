<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/style/style.css">

<title>MenuItmListCustomer</title>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-dark.png"> <a href="ShowCart">Cart</a>
		<a href="http://localhost:8082/truYumJSP/ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="page-title"></div>
	<h1>MenuItem</h1>
	<c:if test="${addCartStatus}">
		<div class="success-message">Item added to Cart Successfully</div>
	</c:if>
	<div>
		<table class="body-content-color">

			<tr style="width: 60%">
				<th>Name</th>
				<th>Free Delivery</th>
				<th>Price</th>
				<th>Category</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${menuItemList}" var="menuItem">
				<tr>
					<td>${menuItem.name}</td>
					<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if
							test="${!menuItem.freeDelivery}">No</c:if></td>
					<fmt:setLocale value="en_IN" />
					<td><fmt:formatNumber type="currency"
							value='${menuItem.price }' /></td>
					<td>${menuItem.category}</td>
					<td><a href="AddToCartServlet?id=${menuItem.id}">Add to
							Cart</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>