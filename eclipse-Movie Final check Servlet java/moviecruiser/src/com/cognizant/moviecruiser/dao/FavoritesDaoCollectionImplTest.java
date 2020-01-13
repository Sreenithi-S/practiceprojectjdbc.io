package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoCollectionImplTest {

	@SuppressWarnings("unchecked")
	public static void testAddFavoriteMovies() throws FavoritesEmptyException {

		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		favoritesDao.addFavoriteMovies(1, 2L);
		favoritesDao.addFavoriteMovies(1, 5L);
		favoritesDao.addFavoriteMovies(2, 1L);
		favoritesDao.addFavoriteMovies(2, 3L);
		List<Movies> moviesListCustomer = (List<Movies>) favoritesDao.getAllFavoriteMovies(1);
		System.out.println("User  added cart list for checkout");
		for (Movies movies : moviesListCustomer) {
			System.out.println(movies);

		}
		System.out.println("Number of favorites =" + moviesListCustomer.size());
	}

	@SuppressWarnings("unchecked")
	public static void testRemoveFavoriteMovies() throws FavoritesEmptyException {

		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		System.out.println("Item List for customer after remove");
		try {
			favoritesDao.removeFavoriteMovies(1, 5L);
			favoritesDao.removeFavoriteMovies(1, 2L);
			List<Movies> moviesListCustomer = (List<Movies>) favoritesDao.getAllFavoriteMovies(1);
			for (Movies movies : moviesListCustomer) {
				System.out.println(movies);
			}
			System.out.println("Number of favorites = " + moviesListCustomer.size());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void testGetAllFavoriteMovies() {

	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testAddFavoriteMovies();
		testRemoveFavoriteMovies();
		testGetAllFavoriteMovies();
	}

}
