package com.cognizant.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavoritesEmptyException;

/**
 * Servlet implementation class RemoveFavoriteServlet
 */
@WebServlet("/RemoveFavorites")
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long userId = 1L;
		long moviesId = Long.parseLong(request.getParameter("id"));

		FavoritesDao favoriteDao = new FavoritesDaoSqlImpl();
		favoriteDao.removeFavoriteMovies(1, moviesId);

		try {
			request.setAttribute("favorite", favoriteDao.getAllFavoriteMovies(userId));
			request.setAttribute("message", true);
			request.setAttribute("deleteFavoriteStatus", true);
			request.getRequestDispatcher("favorite.jsp").forward(request, response);
		} catch (FavoritesEmptyException e) {
			request.getRequestDispatcher("favorite-empty.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
