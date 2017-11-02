package com.games.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.games.models.Comment;
import com.games.models.Game;
import com.games.services.CommentService;
import com.games.services.GameService;

/**
 * Servlet implementation class GameDetailController for show a specific game
 */
@WebServlet("/game")
public class GameDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = -1;
		try {
			id =  Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.getWriter().append(e.getMessage());
			return;
		}
		
		Game game = getGameService().getGameById(id);
		
		if (game == null) {
			request.getServletContext().getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
		} 
	
		ArrayList<Comment> comments = getCommentSerivce().getCommentsGameById(game.getGameid());
		
		request.setAttribute("game", game);
		request.setAttribute("comments", comments);
		request.getServletContext().getRequestDispatcher("/WEB-INF/game_detail.jsp").forward(request, response);
	}
	
	protected GameService getGameService() {
		return  GameService.getInstance();
	}
	
	protected CommentService getCommentSerivce() {
		return  CommentService.getInstance();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
