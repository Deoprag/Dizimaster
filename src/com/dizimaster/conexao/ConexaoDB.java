package com.dizimaster.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoDB {
	
	private static String path = "jdbc:mysql://localhost/dizimaster_db";
	private static String user = "root";
	private static String password = "";
	
	public static Connection conecta() throws SQLException {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(path, user, password);
			
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
			
		}
	}
}