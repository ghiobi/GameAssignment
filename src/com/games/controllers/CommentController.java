package com.games.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.games.models.Game;
import com.games.models.User;
import com.games.services.AuthService;
import com.games.services.CommentService;
import com.games.services.GameService;

/**
 * Servlet implementation class CommentController for commenting on games
 */
@WebServlet("/comment")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user = getAuthService().isAuthenticated(request);
		String comment = request.getParameter("comment");
		
		if (user == null || comment == null) {
			send404(request, response);
			return;
		}
		
		int gameId = 0;
		try {
			gameId = Integer.parseInt(request.getParameter("game_id"));
		} catch (NumberFormatException e) {
			send404(request, response);
			return;
		}
		
		Game game = getGameService().getGameById(gameId);
		
		if (game == null) {
			send404(request, response);
			return;
		}
		
		getCommentService().createComment(game, user, comment);
		response.sendRedirect("/Games/game?id=" + game.getGameId());
	}
	
	private void send404(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
	}
	
	protected AuthService getAuthService() {
		return AuthService.getInstance();
	}
	
	protected CommentService getCommentService() {
		return CommentService.getInstance();
	}
	
	protected GameService getGameService() {
		return GameService.getInstance();
	}

}
