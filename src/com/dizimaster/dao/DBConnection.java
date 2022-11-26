package com.dizimaster.dao;

import java.sql.*;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.dizimaster.model.Despesa;
import com.dizimaster.model.Dizimista;
import com.dizimaster.model.Dizimo;
import com.dizimaster.model.Funcionario;
import com.dizimaster.model.Oferta;
import com.dizimaster.view.*;

public class DBConnection {
	public static String path = "jdbc:mysql://localhost/dizimaster_db";
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