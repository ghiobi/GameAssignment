<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/snippets/header.html" />  

<div class="auth">
    <div class="auth-box">
        <div class="h4">
            Register
        </div>
        <form action="" method="POST">
            <div class="form-group">
                <label for="form_firstname">First Name</label>
                <input type="text" name="firstname" class="form-control" id="form_firstname">
            </div>
            <div class="form-group">
                <label for="form_lastname">Last Name</label>
                <input type="text" name="lastname" class="form-control" id="form_lastname">
            </div>
            <div class="form-group">
                <label for="form_email">Email</label>
                <input type="email" name="email" class="form-control" id="form_email">
            </div>
            <div class="form-group">
                <label for="form_address1">Address 1</label>
                <input type="text" name="address1" class="form-control" id="form_address1">
            </div>
            <div class="form-group">
                <label for="form_address2">Address 2</label>
                <input type="text" name="address2" class="form-control" id="form_address2">
            </div>
            <div class="form-group">
                <label for="form_city">City</label>
                <input type="text" name="city" class="form-control" id="form_city">
            </div>
            <div class="form-group">
                <label for="form_state">State</label>
                <input type="text" name="state" class="form-control" id="form_state">
            </div>
            <div class="form-group">
                <label for="form_zip">Zip</label>
                <input type="text" name="zip" class="form-control" id="form_zip">
            </div>
            <div class="form-group">
                <label for="form_country">Country</label>
                <input type="text" name="country" class="form-control" id="form_country">
            </div>
            <div class="form-group">
                <label for="form_password">Password</label>
                <input type="password" name="email" class="form-control" id="form_password">
            </div>
            <button class="btn btn-block btn-primary" type="submit">Login</button>
        </form>
    </div>
</div>

<jsp:include page="./WEB-INF/snippets/footer.html" />  