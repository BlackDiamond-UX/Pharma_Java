package com.youcode.pharmajava.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.youcode.pharmajava.model.Pharma;


public class PharmaDAO {
	private String jdbcURL = "jdbc:mysql://localhost:3306/pharmajava?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_ITEM_SQL = "INSERT INTO medic" + "  (item, company, price) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_ITEM_BY_ID = "select id,item,company,price from medic where id =?";
	private static final String SELECT_ALL_ITEM = "select * from medic";
	private static final String DELETE_ITEM_SQL = "delete from medic where id = ?;";
	private static final String UPDATE_ITEM_SQL = "update medic set item = ?,company= ?, price =? where id = ?;";

	public PharmaDAO() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertItem(Pharma medic) throws SQLException {
		System.out.println(INSERT_ITEM_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ITEM_SQL)) {
			preparedStatement.setString(1, medic.getItem());
			preparedStatement.setString(2, medic.getCompany());
			preparedStatement.setString(3, medic.getPrice());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Pharma selectItem(int id) {
		Pharma medic = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ITEM_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String item = rs.getString("item");
				String company = rs.getString("company");
				String price = rs.getString("price");
				medic = new Pharma(id, item, company, price);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return medic;
	}

	public List<Pharma> selectAllItem() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Pharma> items = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ITEM);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String item = rs.getString("item");
				String company = rs.getString("company");
				String price = rs.getString("price");
				items.add(new Pharma(id, item, company, price));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return items;
	}

	public boolean deleteItem(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ITEM_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateItem(Pharma medic) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ITEM_SQL);) {
			statement.setString(1, medic.getItem());
			statement.setString(2, medic.getCompany());
			statement.setString(3, medic.getPrice());
			statement.setInt(4, medic.getId());

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