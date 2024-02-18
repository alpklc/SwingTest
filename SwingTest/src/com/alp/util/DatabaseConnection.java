package com.alp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	private static DatabaseConnection instance = null;
	private Connection conn = null;
	
	private static final String URL = "jdbc:postgresql://localhost/SwingTest";
	private static final String USER = "postgres";
	private static final String PASSWORD = "1234";
	
	private DatabaseConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.println("Connected to the PostgreSQL server successfully.");
		} catch (ClassNotFoundException e) {
			System.out.println("Database connection is failed: " + e.getMessage());
		}
	}
	
	public static synchronized DatabaseConnection getInstance() {
		try {
			if (instance == null || instance.getConnection().isClosed())
				instance = new DatabaseConnection();
		} catch (SQLException e) {
			System.out.println("Database connection is failed: " + e.getMessage());
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
}
