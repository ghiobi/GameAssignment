<%@page import="com.games.models.Game"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/snippets/header.html" />  
<% Game game = (Game) request.getAttribute("game"); %>
<%= game.getGame_description() %>

<jsp:include page="./WEB-INF/snippets/footer.html" />  