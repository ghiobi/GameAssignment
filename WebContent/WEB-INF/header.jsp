<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.games.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>Game</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
	<link rel="stylesheet" href="http://localhost:8080/Games/assets/styles.css">
	
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
	
</head>
<body>

<% User user = (User) request.getSession().getAttribute("user"); %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="/Games">Game Shop</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav w-100">
	    		<li class="nav-item active">
	      		<a class="nav-link" href="/Games">Home <span class="sr-only">(current)</span></a>
	    		</li>
	    		<c:if test="${empty user}">
		    <li class="nav-item">
		     	<a class="nav-link" href="/Games/login.jsp">Sign In</a>
		    </li>
		    <li class="nav-item">
		     	<a class="nav-link" href="/Games/register.jsp">Register</a>
		    </li>
		    </c:if>
		    <li class="nav-item">
		      	<a class="nav-link" href="/Games/search.jsp">Search</a>
		    </li>
		    <c:if test="${not empty user}">
  		  		<li class="nav-item">
			      	<a class="nav-link" href="/Games/browse?specials=true">Specials</a>
			    </li>
		    </c:if>
	    		<c:if test="${not empty user}">
		    <li class="nav-item ml-auto">
		  		<a class="nav-link" href="/Games/logout">Sign out</a>
			</li>
			</c:if>
	  	</ul>
	</div>
</nav>
