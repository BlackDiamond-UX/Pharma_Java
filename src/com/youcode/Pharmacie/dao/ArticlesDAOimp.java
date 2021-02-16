package com.youcode.Pharmacie.dao;

import com.youcode.Pharmacie.model.Article;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.youcode.Pharmacie.Connection.Connectionfactory.getConnection;

public class ArticlesDAOimp implements com.youcode.Pharmacie.dao.DAO {



    private static final String SELECT_ALL_ARTICLES = "select * from public.\"Article\"";
    private static final String SELECT_ARTICLES_BY_ID = "select nom,company,price,qun,description from public.\"Article\" where id =?";
    private static final String DELETE_ARTICLES_SQL = "delete from public.\"Article\" where id = ?;";
    private static final String UPDATE_ARTICLES_SQL = "update public.\"Article\" set nom = ?,company= ?, price =?,qun=?,description=? where id = ?;";
    private static final String INSERT_ARTICLES_SQL = "INSERT INTO public.\"Article\"" + "  (nom, company, price,qun,description) VALUES "
            + " (?, ?, ?,?,?);";

    public void save(Article item) throws SQLException {
        System.out.println(INSERT_ARTICLES_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ARTICLES_SQL)) {
            preparedStatement.setString(1, item.getNom());
            preparedStatement.setString(2, item.getCompany());
            preparedStatement.setInt(3, item.getPrice());
            preparedStatement.setInt(4, item.getQun());
            preparedStatement.setString(5, item.getDescription());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public Article getById(int id) {
        Article item = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ARTICLES_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String nom = rs.getString("nom");
                String company = rs.getString("company");
                int price = rs.getInt("price");
                int qun = rs.getInt("qun");
                String description = rs.getString("description");
                item = new Article(id, nom, company, price,qun,description);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return item;
    }

    public List<Article> getAll() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Article> article = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ARTICLES);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String company = rs.getString("company");
                int price = rs.getInt("price");
                int qun = rs.getInt("qun");
                String description = rs.getString("description");
                article.add(new Article(id, nom, company, price,qun,description));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return article;
    }

    public boolean delete(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ARTICLES_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean update(Article item) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ARTICLES_SQL);) {
            statement.setString(1, item.getNom());
            statement.setString(2, item.getCompany());
            statement.setInt(3, item.getPrice());
            statement.setInt(4, item.getQun());
            statement.setString(5, item.getDescription());
            statement.setInt(6, item.getId());


            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
