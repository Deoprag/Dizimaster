package com.dizimaster.dao;

import java.sql.*;

public class DBConnection {
	public static String path = "jdbc:mysql://localhost/dizimaster_db";
	private static String user = "root";
	private static String password = "admin123";

	public static Connection conecta() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(path, user, password);

		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getException());
		}
	}
}