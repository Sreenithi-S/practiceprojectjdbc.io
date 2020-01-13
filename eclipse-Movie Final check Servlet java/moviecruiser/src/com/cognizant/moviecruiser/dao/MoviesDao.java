package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movies;

public interface MoviesDao {

	public List<Movies> getMoviesAdmin();

	public List<Movies> getMoviesCustomer();

	public void modifyMovies(Movies movies);

	public Movies getMovies(Long moviesId);
}
