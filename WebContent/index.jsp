<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.games.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/header.jsp" />  

<% User user = (User) request.getSession().getAttribute("user"); %>

<div class="jumbotron">
	<div class="container">
		<h1>Welcome to Game Shop  
		<c:if test="${not empty user}">
			, ${user.getFirstName()} ${user.getLastName()}
		</c:if>
		</h1>
		<p class="lead">Get the best games here!</p>
		<a class="btn btn-primary" href="/Games/browse">Browse</a>
	</div>
</div>

<jsp:include page="./WEB-INF/footer.jsp" />  