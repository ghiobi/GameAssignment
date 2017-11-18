<%@page import="com.games.models.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.games.models.Game" %>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

 <jsp:include page="./header.jsp"/>

<% ArrayList<Game> games = (ArrayList<Game>) request.getAttribute("games");%>
<% User user = (User) request.getSession().getAttribute("specials"); %>

<div class="container">
	<div class="lead mt-5 mb-5">Found ${games.size()} results. <small class="text-muted float-right"><a href="/Games/search.jsp">New Search</a></small></div>
	<c:forEach items="${games}" var="game">
		<div class="media mt-3">
		  <img class="align-self-start mr-3" src="${game.getFrontBoxArt()}" alt="${game.getGameName()}" width="100">
			  <div class="media-body">
			    <h3 class="mt-0"><a href="/Games/game?id=${game.getGameId()}">${game.getGameName()}</a>
			    		<small>
			    			<c:choose>
						    <c:when test="${not empty user && game.getDiscount() != 0}">
						        <del>$${game.getPrice()}</del> $${game.getPrice() - game.getDiscount()} -
			    					<small>$${game.getDiscount()} OFF</small>
						    </c:when>    
						    <c:otherwise>
						        $${game.getPrice()}
						    </c:otherwise>
						</c:choose>
			    		</small>
			    </h3>
			    <p>${game.getGameDescription()}</p>
			  </div>
			</div>
		    <div>      
	    </div>
	</c:forEach>
	
</div>

 <jsp:include page="./footer.jsp"/>
