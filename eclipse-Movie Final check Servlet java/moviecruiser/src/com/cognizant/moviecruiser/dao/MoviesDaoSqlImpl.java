package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.DateUtil.DateUtil;
import com.cognizant.moviecruiser.model.Movies;

public class MoviesDaoSqlImpl implements MoviesDao {
	public static final String MOVIES_LIST_ADMIN = "Select * from movies";
	public static final String MOVIES_LIST_CUSTOMER = "select * from movies where mo_active='yes' and mo_date_of_launch>(select curdate())";
	public static final String MODIFY_MOVIES = "UPDATE movies set mo_title=?, mo_box_office=?, mo_active=?, mo_date_of_launch=?, mo_genre=?, mo_has_teaser=? where mo_id=?";
    public static final String GET_MOVIES="select * from movies where mo_id=?";
	@Override
	public List<Movies> getMoviesAdmin() {
		// TODO Auto-generated method stub
		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(MOVIES_LIST_ADMIN);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("yes"));
				moviesList.add(movies);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return moviesList;
	}

	@Override
	public List<Movies> getMoviesCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Movies> moviesList = new ArrayList<>();
		Connection connection = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Movies movies = null;
		try {
			preparedStatement = connection.prepareStatement(MOVIES_LIST_CUSTOMER);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				movies = new Movies();
				movies.setId(resultSet.getLong("mo_id"));
				movies.setTitle(resultSet.getString("mo_title"));
				movies.setGross(resultSet.getLong("mo_box_office"));
				movies.setActive(resultSet.getString("mo_active").equals("yes"));
				movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
				movies.setGenre(resultSet.getString("mo_genre"));
				movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("yes"));
				moviesList.add(movies);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return moviesList;
	}

	@Override
	public void modifyMovies(Movies movies) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = connection.prepareStatement(MODIFY_MOVIES);
			preparedStatement.setLong(7, movies.getId());
			preparedStatement.setString(1, movies.getTitle());
			preparedStatement.setFloat(2, movies.getGross());
			preparedStatement.setString(3, movies.getActive() ? "yes" : "no");
			preparedStatement.setDate(4, DateUtil.convertToSqlDate(movies.getDateOfLaunch()));
			preparedStatement.setString(5, movies.getGenre());
			preparedStatement.setString(6, movies.getHasTeaser() ? "yes" : "no");
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {

				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public Movies getMovies(Long moviesId) {
		// TODO Auto-generated method stub
		Connection connection = ConnectionHandler.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Movies movies = null;
        try {
            preparedStatement = connection.prepareStatement(GET_MOVIES);
            preparedStatement.setLong(1, moviesId);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                movies = new Movies();
                movies.setId(resultSet.getLong("mo_id"));
                movies.setTitle(resultSet.getString("mo_title"));
                movies.setGross(resultSet.getLong("mo_box_office"));
            movies.setActive(resultSet.getString("mo_active").equals("Yes"));
            movies.setDateOfLaunch(resultSet.getDate("mo_date_of_launch"));
                movies.setGenre(resultSet.getString("mo_genre"));
            movies.setHasTeaser(resultSet.getString("mo_has_teaser").equals("Yes"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movies;

		
	}

}
