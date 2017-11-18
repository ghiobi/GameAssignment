<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.games.models.Game" %>
<%@page import="com.games.models.User"%>
<%@page import="com.games.models.Comment"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./header.jsp" />  

<% Game game = (Game) request.getAttribute("game"); %>
<% ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments"); %>

<% User user = (User) request.getSession().getAttribute("user"); %>

<div class="container mt-5 mb-5">
	<div class="row">
		<div class="col-sm-3">
			<p>
				<img class="img-fluid" src="<%= game.getFrontBoxArt() %>">
			</p>
			<c:if test="${not empty game.getBackBoxArt()}">
				<p>
			    		<img class="img-fluid" src="<%= game.getBackBoxArt() %>">
			 	</p>
			</c:if>
		</div>
		<div class="col-sm-9">
			<h2><%= game.getGameName() %> - <small class="text-muted"><%= game.getConsole() %></small></h2>
			<p><%= game.getGameDescription() %></p>
			<c:if test="not empty game.getLogo()">
				<p class="text-center"><img class="img-fluid" src="<%= game.getLogo() %>"></p>
			</c:if>
			<table class="table">
				<tbody>
					<tr>
						<th>Price</th>
						<td>
				    			<c:choose>
							    <c:when test="${not empty user && game.getDiscount() != 0}">
							        <del>$${game.getPrice()}</del> $${game.getPrice() - game.getDiscount()} -
				    					<small>$${game.getDiscount()} OFF</small>
							    </c:when>    
							    <c:otherwise>
							        $${game.getPrice()}
							    </c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>Number of Players</td>
						<td><%= game.getNumPlayers() %></td>
					</tr>
					<tr>
						<th>Has COOP</td>
						<td>
							${ game.isCoop()? "Yes" : "No" }
						</td>
					</tr>
					<tr>
						<th>Release Date</td>
						<td><%= game.getReleaseDate().toString() %></td>
					</tr>
					<tr>
						<th>Number of Players</td>
						<td><%= game.getNumPlayers() %></td>
					</tr>
					<tr>
						<th>Developer</td>
						<td><%= game.getDeveloper() %></td>
					</tr>
					<tr>
						<th>Publisher</td>
						<td><%= game.getPublisher() %></td>
					</tr>
					<tr>
						<th>Publisher Logo</td>
						<td><img src="<%= game.getDeveloperLogo() %>"></td>
					</tr>
				</tbody>
			</table>
			<hr>
			<c:forEach items="${comments}" var="comment">
				<h6 class="mb-0">
					Comment by user ${comment.getUserId()}: <small class="float-right text-muted">${comment.getCommentDate().toString()} | Rating ${comment.getRatings()}</small>
				</h6>
				<p>
					${comment.getCommentDetails()} 
				</p>
			</c:forEach>
			<c:if test="${empty comments}">
				<div class="mt-5 mb-5 text-center">
					No Comments :(
				</div>
			</c:if>
			<c:if test="${not empty user}">
				<h5>Leave a Comment</h3>
				<form action="/Games/comment" method="POST">
					<input type="hidden" name="game_id" value="${game.getGameId()}">
					<div class="input-group">
						<textarea name="comment" class="form-control" required></textarea>
						<span class="input-group-btn">
							<button class="btn btn-primary h-100" type="submit">Comment</button>
						</span>
					</div>
				</form>
			</c:if>
		</div>
	</div>
</div>

<jsp:include page="./footer.jsp" />  