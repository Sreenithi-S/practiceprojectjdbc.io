<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>menu item list admin</title>
<link rel="stylesheet" type="text/css" href="style/style/style.css">
<script src="js/script.js" type="text/javascript"></script>
</head>
<body>


	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-dark.png"> <a
			href="http://localhost:8082/truYumJSP/ShowMenuItemListAdmin">Menu</a>
	</div>
	<div class="page-title">
		<h2 id="s4">Menu Items</h2>
	</div>
	<table class="body-content-color">

		<tr style="width: 60%">

			<th id="c1">Name</th>
			<th>Price</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Category</th>
			<th>Free Delivery</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${ menuItemList}" var="menuItem">
			<tr>
				<td id="c1">${menuItem.name}</td>
				<fmt:setLocale value="en_IN" />
				<td><fmt:formatNumber type="currency"
						value='${menuItem.price }' /></td>
				<td><c:if test="${menuItem.active}">Yes</c:if> <c:if
						test="${!menuItem.active}">No</c:if></td>
				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${menuItem.dateOfLaunch}" /></td>
				<td>${menuItem.category}</td>
				<td><c:if test="${menuItem.freeDelivery}">Yes</c:if> <c:if
						test="${!menuItem.freeDelivery}">No</c:if></td>
				<td><a href="ShowEditMenuItem?id=${menuItem.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>

</body>
</html>