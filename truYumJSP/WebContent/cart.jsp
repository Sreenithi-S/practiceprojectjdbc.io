<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
<link rel="stylesheet" type="text/css" href="style/style/style.css">
<script src="js/js/script.js" type="text/javascript"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-light.png"> <a href="ShowCart">Cart</a>
		<a href="ShowMenuItemListCustomer">Menu</a>
	</div>
	<div class="page-title"></div>
	<h1>Cart</h1>
	<c:if test="${deleteCartStatus}">
		<div class="success-message">
			<h2 id="s4">Item deleted from cart successfully</h2>
		</div>
	</c:if>

	<table id="rh">

		<tr style="width: 60%">
			<th>Name</th>
			<th>Free Delivery</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action</th>
		</tr>



		<c:forEach items="${cart.menuItemList}" var="menuItem">
			<tr style="text-align: center">

				<td>${menuItem.name}</td>
				<td><c:if test="${menuItem.freeDelivery eq 'true'}">Yes</c:if>
					<c:if test="${menuItem.freeDelivery eq 'false'}">No</c:if></td>
				<fmt:setLocale value="en_IN" />
				<td><fmt:formatNumber type="currency" value='${menuItem.price}' /></td>
				<td>${menuItem.category}</td>
				<td><a href="RemoveCartItem?id=${menuItem.id}">Delete</a></td>

			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td id="s9">Total</td>
			<td id="s9">Rs.<fmt:formatNumber value="${cart.total}"
					pattern="#,##,##,##,###.00" />
			</td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright � 2019</h3>
	</div>
</body>
</html>
