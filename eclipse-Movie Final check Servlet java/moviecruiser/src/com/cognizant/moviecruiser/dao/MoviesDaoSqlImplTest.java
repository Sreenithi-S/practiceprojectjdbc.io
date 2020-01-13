package com.cognizant.moviecruiser.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.DateUtil.DateUtil;
import com.cognizant.moviecruiser.model.Movies;

public class MoviesDaoSqlImplTest {
	public static void testGetMoviesAdmin() {
		
//		Connection connection = ConnectionHandler.getConnection();
//		System.out.println(connection);
		System.out.println("\nMovies for Admin");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		List<Movies> moviesList =  new MoviesDaoSqlImpl().getMoviesAdmin();
		System.out.format("%-10s%-20s%-10s%-15s%-15s%-20s%-10s", "Id", "Name", "Box Office", "Active", "Date of Launch",
				"Genre", "Has Teaser");
		String active;
		String hasTeaser;

		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "yes";
			} else {
				active = "no";
			}
			if (movies.getHasTeaser() == true) {
				hasTeaser = "yes";
			} else {
				hasTeaser = "no";
			}
			System.out.format("\n%-10s%-20s%-10s%-15s%-15s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(),
					hasTeaser);
		}
	}
		public static void testGetMoviesCustomer() {
			
			Connection connection = ConnectionHandler.getConnection();
			System.out.println(connection);
			System.out.println("\nMovies for Customer");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			List<Movies> moviesList =  new MoviesDaoSqlImpl().getMoviesAdmin();
			System.out.format("%-10s%-20s%-10s%-15s%-15s%-20s%-10s", "Id", "Name", "Box Office", "Active", "Date of Launch",
					"Genre", "Has Teaser");
			String active;
			String hasTeaser;

			for (Movies movies : moviesList) {
				if (movies.getActive() == true) {
					active = "yes";
				} else {
					active = "no";
				}
				if (movies.getHasTeaser() == true) {
					hasTeaser = "yes";
				} else {
					hasTeaser = "no";
				}
				System.out.format("\n%-10s%-20s%-10s%-15s%-15s%-20s%-10s", movies.getId(), movies.getTitle(),
						movies.getGross(),active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(),
						hasTeaser);
			
		}
		}
		public static void testModifyMovies() {
				Movies movies = new Movies(101L, "Bahubali", 4326347658L, true, new DateUtil().convertToDate("12/09/2020"),
						"Action", true);
				MoviesDaoSqlImpl moviesDaoSqlImpl = new MoviesDaoSqlImpl();

				moviesDaoSqlImpl.modifyMovies(movies);
				System.out.println("Modified");
				
			}
	

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		testGetMoviesAdmin();
		testModifyMovies();
		testGetMoviesAdmin();
		testGetMoviesCustomer();
	}
}