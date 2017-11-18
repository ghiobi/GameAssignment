<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.games.models.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.getSession().removeAttribute("flashDanger"); %>
<% request.getSession().removeAttribute("flashSuccess"); %>
</body>
</html>