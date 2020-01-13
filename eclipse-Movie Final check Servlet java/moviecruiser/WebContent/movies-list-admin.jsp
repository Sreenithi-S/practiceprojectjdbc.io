<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movies list admin</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
</head>
<body>

	<div class="topnav">
		<div class="home">moviecruiser</div>
		<img src="images/logo.jpg"> <a
			href="ShowMoviesListAdmin">Menu</a>
	</div>
	<div class="page-title">
		<h2 id="s4">Movies</h2>
	</div>
	<table class="body-content-color">

		<tr style="width: 60%">

			<th id="c1">Title</th>
			<th>Box Office</th>
			<th>Active</th>
			<th>Date of Launch</th>
			<th>Genre</th>
			<th>Has Teaser</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${ moviesList}" var="movies">
			<tr>
				<td id="leftalign">${movies.title}</td>
				<fmt:setLocale value="en_US" />
				<td><fmt:formatNumber type="currency"
						value='${movies.gross }' /></td>
				<td><c:if test="${movies.active}">Yes</c:if> <c:if
						test="${!movies.active}">No</c:if></td>
				<td><fmt:formatDate type="date" pattern="dd/MM/yyyy"
						value="${movies.dateOfLaunch}" /></td>
				<td>${movies.genre}</td>
				<td><c:if test="${movies.hasTeaser}">Yes</c:if> <c:if
						test="${!movies.hasTeaser}">No</c:if></td>
				<td><a href="ShowEditMovies?id=${movies.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
	<div class="footer">
		<h3>CopyRight @ 2019</h3>
	</div>
</body>
</html>