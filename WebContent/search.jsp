<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="./WEB-INF/header.jsp" />  

<div class="jumbotron">
	<div class="container">
		<h1>Search</h1>
	</div>
</div>

<div class="container">
	<div class="row">
		<div class="col-sm-10 col-md-6">
			<div class="search">
		        <form action="/Games/browse" method="GET">
		        		<input type="hidden" name="search" value="true">
		             <div class="form-group">
		                <label for="form_title">Title</label>
		                <input type="text" name="title" class="form-control" id="form_title" required>
		            </div>
		            <div class="form-group">
		                <label for="form_console">Console</label>
		                <select name="console" class="form-control" id="form_console">
		                		<option value="ANY">Any</option>
		                		<option value="Sony Playstation 3">Sony Playstation 3</option>
		                		<option value="Sega Genesis">Sega Genesis</option>
		                		<option value="PC">PC</option>
		                		<option value="Arcade">Arcade</option>
		                		<option value="Nintendo Entertainment System (NES)">Nintendo Entertainment System (NES)</option>
		                		<option value="Nintendo 64">Nintendo 64</option>
		                		<option value="Sega Saturn">Sega Saturn</option>
		                </select>
		            </div>
		            <div class="form-group">
		                <label for="form_publisher">Publisher</label>
		                <select name="publisher" class="form-control" id="form_publisher">
		                		<option value="ANY">Any</option>
		                		<option value="Taxan">Taxan</option>
		                		<option value="Electronic Arts">Electronic Arts</option>
		                		<option value="Taito">Taito</option>
		                		<option value="Blizzard">Blizzard</option>
		                		<option value="Kemco">Kemco</option>
		                		<option value="Sega">Sega</option>
		                		<option value="Konami">Konami</option>
		                </select>
		            </div>
		            <div class="form-group">
		                <label for="form_genre">Genre</label>
		                <select name="genre" class="form-control" id="form_genre">
		                		<option value="ANY">Any</option>
		                		<option value="Puzzle">Puzzle</option>
		                		<option value="Action">Action</option>
		                		<option value="Adventure">Adventure</option>
		                		<option value="Racing">Racing</option>
		                </select>
		            </div>
		            <button class="btn btn-primary" type="submit">Search</button>
		        </form>
			</div>
		</div>
	</div>
</div>

<jsp:include page="./WEB-INF/footer.jsp" />  