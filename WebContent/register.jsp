<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/header.jsp" />  

<% String flashDanger = (String) request.getSession().getAttribute("flashDanger"); %>

<div class="jumbotron">
	<div class="container">
		<h1>
			Register
		</h1>
		<div class="lead">Already have an account? <a href="/Games/login.jsp">Sign In</a></div>
	</div>
</div>
<div class="container mb-5 pb-5">
      <c:if test="${not empty flashDanger}">
       	<div class="alert alert-danger" role="alert">
		  ${flashDanger}
		</div>
	</c:if>
    <form action="/Games/register" method="POST">
		<div class="row mb-3">
			<div class="col-md-6">
	            <div class="form-group">
	                <label for="form_firstname">First Name</label>
	                <input type="text" name="firstname" class="form-control" id="form_firstname" required>
	            </div>
	            <div class="form-group">
	                <label for="form_lastname">Last Name</label>
	                <input type="text" name="lastname" class="form-control" id="form_lastname" required>
	            </div>
	            <div class="form-group">
	                <label for="form_email">Email</label>
	                <input type="email" name="email" class="form-control" id="form_email" required>
	            </div>
	            <div class="form-group">
	                <label for="form_address1">Address 1</label>
	                <input type="text" name="address1" class="form-control" id="form_address1" required>
	            </div>
	            <div class="form-group">
	                <label for="form_address2">Address 2 - <span class="text-muted">Optional</span></label>
	                <input type="text" name="address2" class="form-control" id="form_address2">
	            </div>
	            <div class="form-group">
	                <label for="form_city">City</label>
	                <select name="city" class="form-control" id="form_city" required>
	                		<option value="Montreal">Montreal</option>
	                		<option value="New York">New York</option>
	                		<option value=Toronto>Toronto</option>
	                </select>
	            </div>
	            <div class="form-group">
	                <label for="form_state">State</label>
	                <input type="text" name="state" class="form-control" id="form_state" required>
	            </div>
	            <div class="form-group">
	                <label for="form_zip">Zip</label>
	                <input type="text" name="zip" class="form-control" id="form_zip" required>
	            </div>
	        </div>
			<div class="col-md-6">
	            <div class="form-group">
	                <label for="form_country">Country</label>
	                <select name="country" class="form-control" id="form_country" required>
	                		<option value="Canada">Canada</option>
	                		<option value="USA">USA</option>
	                </select>
	            </div>
	            <div class="form-group">
	                <label for="form_"credit_card_type"">Credit Card Type</label>
	                <select name="credit_card_type" class="form-control" id="form_"credit_card_type"">
	                		<option value="">Select One</option>
	                		<option value="Visa">Visa</option>
	                		<option value="MasterCard">MasterCard</option>
	                </select>
	            </div>
	            <div class="form-group">
	                <label for="form_credit_card_number">Credit Card Number - <span class="text-muted">Optional</span></label>
	                <input type="text" name="credit_card_number" class="form-control" id="form_credit_card_number">
	            </div>
	            <div class="form-group">
	                <label for="form_credit_card_cvv">Credit Card CVV - <span class="text-muted">Optional</span></label>
	                <input type="text" name="credit_card_cvv" class="form-control" id="form_credit_card_cvv">
	            </div>
	            <div class="form-group">
	                <label for="form_credit_card_expiry">Credit Card Expiry - <span class="text-muted">Optional</span></label>
	                <input type="date" name="credit_card_expiry" class="form-control" id="credit_card_expiry">
	            </div>
	            <div class="form-group">
	                <label for="form_password">Password</label>
	                <input type="password" name="password" class="form-control" id="form_password" required>
	            </div>
			</div>
		</div>
		<button class="btn btn-block btn-primary" type="submit">Register</button>
	</form>
</div>

<jsp:include page="./WEB-INF/footer.jsp" />  