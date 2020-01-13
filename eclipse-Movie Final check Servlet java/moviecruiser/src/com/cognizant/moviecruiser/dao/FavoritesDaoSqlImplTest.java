package com.cognizant.moviecruiser.dao;

import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {
	
	public static void testAddFavoriteMovies() {
		SimpleDateFormat sdf = new  SimpleDateFormat("dd/MM/yyyy");
		List<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesAdmin();
		
		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		favoritesDao.addFavoriteMovies(4L, 104);
	}
	public static void testGetFavoriteMovies() throws FavoritesEmptyException {
		FavoritesDaoSqlImpl favoritesDaoSqlImpl = new FavoritesDaoSqlImpl();
	    Favorites favorites = favoritesDaoSqlImpl.getAllFavoriteMovies(3L);
	   
	    System.out.println(favorites.getMoviesList());
	    System.out.println("Total favorites= "+favorites.getTotal());
		
	}
	public static void testRemoveFavoriteMovies() {
		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		favoritesDao.removeFavoriteMovies(1l,102);
	}
	public static void main(String[] args) throws FavoritesEmptyException {
		
		//testAddFavoriteMovies();
		testGetFavoriteMovies();
		//testRemoveFavoriteMovies();
		

	}

}
