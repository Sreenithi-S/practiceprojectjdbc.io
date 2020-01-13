<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Movies</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script src="js/script.js"></script>
</head>
<body>
<div class="topnav">
		<div class="home">MovieCruiser</div>
		<img src="images/logo.jpg"> <a
			href="ShowMoviesListAdmin">Menu</a>
	</div>

	<h1>Edit  movies</h1>
	<div class="body-content-colour">
		<form action="EditMovies"
			onsubmit="return validateForm()" name="editmovie"
			method="post">
			<div class="form-field-spacing">
				<label for="title">Title</label> <input type="text"
					class="text-box text-box-title" name="title" id="title"
					value="${movies.title}">
			</div>
			<div>
				<div class="form-field-spacing">
					<label for="gross">Gross</label> <input type="text"
						class="text-box" name="gross" id="gross" value="${movies.gross}">
				</div>
				<div class="form-field-spacing">
					<label for="active">Active</label> Yes<input class="radio"
						type="radio" name="active" value="yes"
						<c:if test="${movies.active eq 'true'}">checked</c:if>>
					No<input class="radio" type="radio" name="active" value="no"
						<c:if test="${movies.active eq 'false'}">checked</c:if>>
				</div>
				<div class="form-field-spacing">
					<label for="dateOfLaunch">Date of Launch</label> <input type="text"
						class="text-box" name="dateOfLaunch"
						value="<fmt:formatDate type='date' pattern='dd/MM/yyyy' value='${movies.dateOfLaunch}'/>">
				</div>
				<div class="form-field-spacing">
					<label for="genre">Genre</label> <select name="genre"
						class="dropdown">
						<option value="${movies.genre}">${movies.genre}</option>
						<option value="Science Fiction">Science Fiction</option>
						<option value="Super Hero">Super Hero</option>
						<option value="Romance">Romance</option>
						<option value="Adventure">Adventure</option>
						<option value="Thriller">Thriller</option>
						<option value="Comedy">Super Hero</option>
					</select>
				</div>
			</div>
			<div class="form-field-spacing">
				<label for="hasTeaser">Has Teaser</label> <input
					type="checkbox" name="hasTeaser">
					<c:if test="${movies.active eq 'true'}" ></c:if>
					<c:if test="${movies.active eq 'false'}" ></c:if>
			</div>
			<div>
				<input type="submit" class="button success-button" value="Save">
			</div>
			<div>
				<input type="hidden" name="id" value="${movies.id}">
			</div>
		</form>
	</div>
	<div class="footer">
		<h3>CopyRight @ 2019</h3>
	</div>

</body>
</html>