<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Favorites</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>

</head>
<body>
<div class="topnav">
		<div class="home">moviecruiser</div>
		<img src="images/logo.jpg"> 
		<a href="ShowFavorites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<h1>Favorites</h1>
	<div class="page-title"></div>
	<c:if test="${deleteFavoriteStatus}">
		<div class="success-message">
			<h2 id="s4">Movie deleted from favorites successfully</h2>
		</div>
	</c:if>

	<table class="body-content-color">

		<tr style="width: 60%">
			<th>Title</th>
			<th>Has Teaser</th>
			<th>Box Office</th>
			<th>Genre</th>
			<th>Action</th>
		</tr>



		<c:forEach items="${favorite.moviesList}" var="movies">
			<tr style="text-align: center">

				<td>${movies.title}</td>
				<td><c:if test="${movies.hasTeaser eq 'true'}">Yes</c:if>
					<c:if test="${movies.hasTeaser eq 'false'}">No</c:if></td>
				
				<td><fmt:formatNumber type="currency" value='${movies.gross}' pattern="$###.###"/></td>
				<td>${movies.genre}</td>
				<td><a href="RemoveFavorites?id=${movies.id}">Delete</a></td>

			</tr>
		</c:forEach>
		<tr>
			<td></td>
			<td>No. of favorites</td>
			<td >${favorite.total}</td>
		</tr>
	</table>
	<div class="footer">
		<h3>Copyright © 2019</h3>
	</div>
</body>
</html>