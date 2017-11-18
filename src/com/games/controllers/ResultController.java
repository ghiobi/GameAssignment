package com.games.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.games.models.Game;
import com.games.services.AuthService;
import com.games.services.GameService;

/**
 * Servlet implementation class ResultController for return results for specials, search results, or browsing all games.
 */
@WebServlet("/browse")
public class ResultController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Game> games = null;
		
		if (request.getParameter("search") != null) {
			
			String title = request.getParameter("title");
			String console = request.getParameter("console");
			String publisher = request.getParameter("publisher");
			String genre = request.getParameter("genre");
			
			games = getGameService().getGamesByNameConsolePublisherGenre(title, console, publisher, genre);
			
		} else if (request.getParameter("specials") != null) {
			if (getAuthService().isAuthenticated(request) == null) {
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
				return;
			}
			request.setAttribute("specials", "true");
			games = getGameService().getSpecials();
		} else {
			games = getGameService().getAllGames();
		}
		
		
		request.setAttribute("games", games);
		request.getServletContext().getRequestDispatcher("/WEB-INF/game_results.jsp").include(request, response);
		return;
	}
	
	protected GameService getGameService() {
		return GameService.getInstance();
	}
	
	
	protected AuthService getAuthService() {
		return AuthService.getInstance();
	}

}
