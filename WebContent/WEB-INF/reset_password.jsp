<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <jsp:include page="./header.jsp"/>
 
 <% String token = (String) request.getAttribute("token"); %>
 
 <div class="auth">
    <div class="auth-box">
        <h4>
            Reset Password
        </h4>
        <form action="http://localhost:8080/Games/reset_password" method="post" class="mb-3">
            <div class="form-group">
                <label for="form_password">New Password</label>
                <input type="text" name="password" class="form-control" id="form_password" required>
            </div>
            <input type="hidden" name="token" value="${ token }">
            <button class="btn btn-block btn-primary" type="submit">Reset Password</button>
        </form>
    </div>
</div>
 
 <jsp:include page="./footer.jsp"/>