<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/snippets/header.html" />  

<div class="search">
    <div class="search-box">
    		<div class="text-center mb-4">
    			<img class="img-fluid logo c" src="http://localhost:8080/Games/assets/logo.png">
    		</div>
        <form action="" method="get">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Search for game...">
                <span class="input-group-btn">
                    <button class="btn btn-secondary" type="button">Search!</button>
                </span>
            </div>
        </form>
    </div>
</div>

<jsp:include page="./WEB-INF/snippets/footer.html" />  