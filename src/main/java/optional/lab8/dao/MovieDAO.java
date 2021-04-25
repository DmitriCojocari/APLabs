package optional.lab8.dao;

import optional.lab8.connection.ConnectionManager;
import optional.lab8.model.Movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<>();
        try {
            String queryString = "SELECT * FROM movie_imdb";
            getResultSet(queryString);
            while (resultSet.next()) {
                movies.add(new Movie(resultSet.getString("movie_id"),
                        resultSet.getString("title"),
                        resultSet.getString("release_year"),
                        resultSet.getInt("movie_duration"),
                        resultSet.getFloat("rating")
                ));

            }
            return movies;
        } catch (SQLException e) {
            e.printStackTrace();
            return movies;
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
