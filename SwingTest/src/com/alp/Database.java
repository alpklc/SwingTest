package com.alp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

	private static final String url = "jdbc:postgresql://localhost/SwingTest";
	private static final String user = "postgres";
	private static final String password = "1234";

	
	/**
	 * @return
	 * @throws SQLException 
	 */
	public static Connection connect() throws SQLException {
		Connection conn = null;
		conn = DriverManager.getConnection(url, user, password);
		System.out.println("Connected to the PostgreSQL server successfully.");
		
		return conn;
	}
	
}
