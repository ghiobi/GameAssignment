<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/header.jsp" />  

<% String flashDanger = (String) request.getSession().getAttribute("flashDanger"); %>
<% String flashSuccess = (String) request.getSession().getAttribute("flashSuccess"); %>

<div class="auth">
    <div class="auth-box">
    		<div id="login">
	        <h4>
	            Login
	        </h4>
	        <c:if test="${not empty flashDanger}">
		        <div class="alert alert-danger" role="alert">
				  ${flashDanger}
				</div>
			</c:if>
			<c:if test="${not empty flashSuccess}">
		        <div class="alert alert-success" role="alert">
				  ${flashSuccess}
				</div>
			</c:if>
	        <form action="http://localhost:8080/Games/login" method="post" class="mb-3">
	            <div class="form-group">
	                <label for="form_email">Email</label>
	                <input type="text" name="email" class="form-control" id="form_email" required>
	            </div>
	            <div class="form-group">
	                <label for="form_password" class="d-flex justify-content-between align-items-end">
	                		Password 
	                		<small><a href id="forgot" tabindex="-1">Forgot Password?</a></small>
	                </label>
	                <input type="password" name="password" class="form-control" id="form_password" required>
	            </div>
	            <button class="btn btn-block btn-primary" type="submit">Login</button>
	        </form>
    		</div>
		<div id="reset" style="display: none">
	  		<h4>Reset Password</h4>
		  	<form action="http://localhost:8080/Games/request_reset_password" method="post" class="mb-3">
	            <div class="form-group">
	                <label for="form_email">Email</label>
	                <input type="text" name="email" class="form-control" id="form_email" required>
	            </div>
	            <button class="btn btn-block btn-primary" type="submit">Send Reset</button>
	        </form>
		</div>
		<script>
			$('#forgot').click(function ($event) {
				$event.preventDefault();
				
				$('#reset').toggle();
				$('#login').toggle();
			});
		</script>
        <div class="text-center">
        		Don't have an account? <a href="/Games/register.jsp">Register</a>
        </div>
    </div>
</div>

<jsp:include page="./WEB-INF/footer.jsp" />  