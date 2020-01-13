package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImpl implements FavoritesDao {
	public static final String ADD_MOVIES_TO_FAVORITES = "INSERT INTO `favorites` (`fs_us_id`, `fs_mo_id`) VALUES (?,?)";
    public static final String GET_FAVORITE_MOVIES = "SELECT * FROM movies inner join favorites on fs_mo_id=mo_id where fs_us_id=?";
    public static final String GET_TOTAL = "SELECT count(mo_id) as No_of_Favorites FROM movies inner join favorites on fs_mo_id=mo_id where fs_us_id=?";
    public static final String DELETE = "delete from favorites where fs_us_id=? and fs_mo_id=? limit 1";

	public void addFavoriteMovies(long userId, long moviesId) {
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = connection.prepareStatement(ADD_MOVIES_TO_FAVORITES);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows == 0) {
				System.out.println("no insertion");
			} else {
				System.out.println("inserted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}
	}
	@Override
	public Favorites getAllFavoriteMovies(long userId) throws FavoritesEmptyException {
		// TODO Auto-generated method stub

		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatementTotal = null;
		ArrayList<Movies> moviesList = new ArrayList<Movies>();
		ResultSet resultSetList = null;
		ResultSet resultSetTotal = null;
		Movies movies = null;
		Favorites favorites = new Favorites();
		try {
			preparedStatement = connection.prepareStatement(GET_FAVORITE_MOVIES);
			preparedStatement.setLong(1, userId);
			resultSetList = preparedStatement.executeQuery();
			preparedStatementTotal = connection.prepareStatement(GET_TOTAL);
			preparedStatementTotal.setLong(1, userId);
			resultSetTotal = preparedStatementTotal.executeQuery();
			while (resultSetList.next()) {
				movies = new Movies();
				movies.setId(resultSetList.getLong("mo_id"));
				movies.setTitle(resultSetList.getString("mo_title"));
				movies.setGross(resultSetList.getLong("mo_box_office"));
				movies.setActive(resultSetList.getString("mo_active").equals("yes"));
				movies.setDateOfLaunch(resultSetList.getDate("mo_date_of_launch"));
				movies.setGenre(resultSetList.getString("mo_genre"));
				movies.setHasTeaser(resultSetList.getString("mo_has_teaser").equals("yes"));
				moviesList.add(movies);
			}
			while (resultSetTotal.next()) {
				favorites.setTotal(resultSetTotal.getInt("no_of_Favorites"));
			}
			if (moviesList.size() == 0) {
				throw new FavoritesEmptyException();
			}
			favorites.setMoviesList(moviesList);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSetList != null)
					resultSetList.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (resultSetTotal != null)
					resultSetTotal.close();
				if (preparedStatementTotal != null)
					preparedStatementTotal.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return favorites;

		
	}
	@Override
	public void removeFavoriteMovies(long userId, long moviesId) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setLong(1, userId);
			preparedStatement.setLong(2, moviesId);
			int noOfRows = preparedStatement.executeUpdate();
			if (noOfRows == 0) {
				System.out.println("Deletion not occurs");
			} else {
				System.out.println("Deleted");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}
		
	
}
