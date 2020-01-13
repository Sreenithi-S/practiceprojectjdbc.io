<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>EditMenuItemServlet</title>
<link rel="stylesheet" type="text/css" href="style/style/style.css">
<script src="js/js/script.js"></script>
</head>
<body>
	<div class="topnav">
		<div class="home">truYum</div>
		<img src="images/truyum-logo-dark.png"> <a
			href="ShowMenuItemListAdmin">Menu</a>
	</div>

	<h1>Edit Menu Item</h1>
	<div class="body-content-colour">
		<form action="http://localhost:8082/truYumJSP/EditMenuItemServlet"
			onsubmit="return validateMenuItemForm()" name="MenuItemForm"
			method="post">
			<div class="form-field-spacing">
				<label for="name">Name</label> <input type="text"
					class="text-box text-box-title" name="name" id="name"
					value="${menuItem.name}">
			</div>
			<div>
				<div class="form-field-spacing">
					<label for="price">Price(Rs.)</label> <input type="text"
						class="text-box" name="price" id="price" value="${menuItem.price}">
				</div>
				<div class="form-field-spacing">
					<label for="inStock">Active</label> Yes<input class="radio"
						type="radio" name="active" value="yes"
						<c:if test="${menuItem.active eq 'true'}">checked</c:if>>
					No<input class="radio" type="radio" name="active" value="no"
						<c:if test="${menuItem.active eq 'false'}">checked</c:if>>
				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label> <input type="text"
						class="text-box" name="dateOfLaunch"
						value="<fmt:formatDate type='date' pattern='dd/MM/yyyy' value='${menuItem.dateOfLaunch}'/>">
				</div>
				<div class="form-field-spacing">
					<label for="">Category</label> <select name="category"
						class="dropdown">
						<option value="${menuItem.category}">${menuItem.category}</option>
						<option value="starters">Starter</option>
						<option value="main course">Main Course</option>
						<option value="dessert">Dessert</option>
						<option value="drinks">Drinks</option>
					</select>
				</div>
			</div>
			<div class="form-field-spacing">
				<label for="freeDelivery">Free Delivery</label> <input
					type="checkbox" name="freeDelivery"
					<c:if test="${menuItem.active eq 'true'}" >checked</c:if>
					<c:if test="${menuItem.active eq 'false'}" >unchecked</c:if>>
			</div>
			<div>
				<input type="submit" class="button success-button" value="Save">
			</div>
			<div>
				<input type="hidden" name="id" value="${menuItem.id}">
			</div>
		</form>
	</div>
	<div class="footer">
		<h3>Copyright � 2019</h3>
	</div>

</body>
</html>