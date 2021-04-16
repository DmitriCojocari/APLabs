package compulsory.lab8.dao;

import compulsory.lab8.connection.ConnectionManager;
import compulsory.lab8.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieDAO {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public MovieDAO() {

    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionManager.getInstance().getConnection();
        return conn;
    }

    public void add(Movie movie) {
        try {
            String queryString = "INSERT INTO movies(id, title, release_date, movie_duration, rating) VALUES(?,?,?,?,?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, movie.getId());
            preparedStatement.setString(2, movie.getTitle());
            preparedStatement.setDate(3, movie.getReleaseDate());
            preparedStatement.setInt(4, movie.getDuration());
            preparedStatement.setFloat(5, movie.getRating());
            preparedStatement.executeUpdate();
            System.out.println("Data Added Successfully");
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
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public void findAll() {
        try {
            String queryString = "SELECT * FROM movies";
            getResultSet(queryString);
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt("id")
                        + ", Title: " + resultSet.getString("title")
                        + ", Release Date: " + resultSet.getDate("release_date")
                        + ", Duration (in minutes) " + resultSet.getInt("movie_duration")
                        + " Rating: " + resultSet.getFloat("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeResources();
        }
    }

    public void findByTitle(String movieTitle) {
        try {
            String queryString = String.format("SELECT * FROM movies WHERE title='%s'", movieTitle);
            getResultSet(queryString);
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt("id")
                        + ", Title: " + resultSet.getString("title")
                        + ", Release Date: " + resultSet.getDate("release_date")
                        + ", Duration (in minutes) " + resultSet.getInt("movie_duration")
                        + " Rating: " + resultSet.getFloat("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeResources();
        }
    }

    public void findByID(int idToBeFound) {
        try {
            String queryString = String.format("SELECT * FROM movies WHERE id='%d'", idToBeFound);
            getResultSet(queryString);
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt("id")
                        + ", Title: " + resultSet.getString("title")
                        + ", Release Date: " + resultSet.getDate("release_date")
                        + ", Duration (in minutes) " + resultSet.getInt("movie_duration")
                        + " Rating: " + resultSet.getFloat("rating"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeResources();
        }
    }

    private void getResultSet(String queryString) throws SQLException {
        connection = getConnection();
        preparedStatement = connection.prepareStatement(queryString);
        resultSet = preparedStatement.executeQuery();
    }

    private void freeResources() {
        try {
            if (resultSet != null)
                resultSet.close();
            if (preparedStatement != null)
                preparedStatement.close();
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
