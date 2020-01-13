<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>MoviesListCustomer</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
</head>
<body>
<div class="topnav">
		<div class="home">MovieCruiser</div>
		<img src="images/logo.jpg"><a href="ShowFavorite">Favorite</a>
		<a href="ShowMoviesListCusomer">Movies</a>
	</div>
	<div class="page-title"></div>
	<h1>Movies</h1>
	<c:if test="${addFavoriteStatus}">
		<div class="success-message">Movie added to Favorite Successfully</div>
	</c:if>
	<div>
		<table class="body-content-color">

			<tr style="width: 60%">
				<th>Title</th>
				<th>Has Teaser</th>
				<th>Gross</th>
				<th>Genre</th>
				<th>Action</th>
			</tr>

			<c:forEach items="${moviesList}" var="movies">
				<tr>
					<td>${movies.title}</td>
					<td><c:if test="${movies.hasTeaser}">Yes</c:if> <c:if
							test="${!movies.hasTeaser}">No</c:if></td>
					<fmt:setLocale value="en_US" />
					<td><fmt:formatNumber type="currency"
							value='${movies.gross }' /></td>
					<td>${movies.genre}</td>
					<td><a href="AddToFavorite?id=${movies.id}">Add to
							Favorite</a></td>
				</tr>

			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h3>CopyRight @ 2019</h3>
	</div>

</body>
</html>