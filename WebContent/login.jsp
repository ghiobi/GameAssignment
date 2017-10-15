<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/snippets/header.html" />  

<div class="auth">
    <div class="auth-box">
        <div class="h4">
            Login
        </div>
        <form action="http://localhost:8080/Games/login" method="post">
            <div class="form-group">
                <label for="form_email">Email</label>
                <input type="text" name="email" class="form-control" id="form_email">
            </div>
            <div class="form-group">
                <label for="form_password">Password</label>
                <input type="password" name="password" class="form-control" id="form_password">
            </div>
            <button class="btn btn-block btn-primary" type="submit">Login</button>
        </form>
    </div>
</div>

<jsp:include page="./WEB-INF/snippets/footer.html" />  