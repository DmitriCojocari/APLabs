package compulsory.lab8.dao;

import compulsory.lab8.connection.ConnectionManager;
import compulsory.lab8.model.Genre;

import java.sql.*;

public class GenreDAO {

    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public GenreDAO() {

    }

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionManager.getInstance().getConnection();
        return conn;
    }

    public void add(Genre genre) {
        try {
            String queryString = "INSERT INTO genres(id, genre_name) VALUES(?,?)";
            connection = getConnection();
            preparedStatement = connection.prepareStatement(queryString);
            preparedStatement.setInt(1, genre.getId());
            preparedStatement.setString(2, genre.getName());
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
            String queryString = "SELECT * FROM genres";
            getResultSet(queryString);
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt("id")
                        + ", Genre name: " + resultSet.getString("genre_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            freeResources();
        }
    }

    public void findByTitle(String genreTitle) {
        try {
            String queryString = String.format("SELECT * FROM genres WHERE genre_name='%s'",  genreTitle);
            getResultSet(queryString);
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt("id")
                        + ", Genre Name: " + resultSet.getString("genre_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            freeResources();
        }
    }

    public void findByID(int idToBeFound) {
        try {
            String queryString = String.format("SELECT * FROM genres WHERE id='%d'",  idToBeFound);
            getResultSet(queryString);
            while (resultSet.next()) {
                System.out.println("Id " + resultSet.getInt("id")
                        + ", Genre Name: " + resultSet.getString("genre_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
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


