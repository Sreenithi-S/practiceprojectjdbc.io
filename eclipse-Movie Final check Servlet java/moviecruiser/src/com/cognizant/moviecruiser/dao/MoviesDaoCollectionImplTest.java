package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.DateUtil.DateUtil;

import com.cognizant.moviecruiser.model.Movies;

public class MoviesDaoCollectionImplTest {

	public static void testGetMoviesListAdmin() {
		List<Movies> moviesList = new MoviesDaoCollectionImpl().getMoviesAdmin();
		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testGetMoviesListCustomer() {
		System.out.println("Movie List for Customer");

		MoviesDao moviesDao = new MoviesDaoCollectionImpl();

		List<Movies> moviesList = moviesDao.getMoviesCustomer();

		for (Movies movies : moviesList) {
			System.out.println(movies);
		}
	}

	public static void testModifyMovies() {

		Movies item = new Movies(5L, "Batman            ", 2750760348L, true,
				new DateUtil().convertToDate("02/12/2022"), "Superhero    ", true);
		MoviesDao moviesDao = new MoviesDaoCollectionImpl();
		moviesDao.modifyMovies(item);
		System.out.println("***Modified List***");
		testGetMoviesListAdmin();
		Movies modified_item = moviesDao.getMovies(item.getId());
		System.out.println("Modified item detail\n" + modified_item);
	}

	public static void main(String[] args) {
		// testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();
	}

}
