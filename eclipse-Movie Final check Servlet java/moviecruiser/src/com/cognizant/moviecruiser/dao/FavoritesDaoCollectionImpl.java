package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;

import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		super();
		if (userFavorites == null) {
			userFavorites = new HashMap<>();
		}
	}

	@Override
	public void addFavoriteMovies(long userId, long moviesId) {
		
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		Movies movies = moviesDao.getMovies(moviesId);
		if (userFavorites.containsKey(userId)) {
			userFavorites.get(userId).getMoviesList().add(movies);
		} else {
			
			Favorites favorites = new Favorites();
			ArrayList<Movies> moviesList = new ArrayList<>();
			moviesList.add(movies);
			favorites.setMoviesList(moviesList);
			userFavorites.put(userId, favorites);
		}
	}

	@Override
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		//List<Movies> moviesList = userFavorites.get(userId).getMoviesList();
		Favorites favorites = userFavorites.get(userId);
		int total = 0;
		if (favorites == null ||favorites.getMoviesList().isEmpty()) {
			throw new FavoritesEmptyException();
		} 
		List<Movies> moviesList = favorites.getMoviesList();
		total += moviesList.size();
		favorites.setTotal(total);
		return favorites;
	}

	@Override
	public void removeFavoriteMovies(long userId, long moviesId) {

		List<Movies> moviesList = userFavorites.get(userId).getMoviesList();
		// 2. Iterate through the List of Movies
		for (int i = 0; i < moviesList.size(); i++) {
			// a. Check if the moviesId of each menu item from the list matches with this
			// methods input parameter
			if (moviesList.get(i).getId() == moviesId) {
				moviesList.remove(i);
				return;
			}
		}
	}

}
