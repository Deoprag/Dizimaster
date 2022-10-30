package com.dizimaster.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.dizimaster.app.*;

public class DatabaseUtils {
	
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
	
	public static boolean login(String user, String password) {
		try {
			TelaLogin tl = new TelaLogin();
			Connection con = DatabaseUtils.conecta();
			String sql = "select *from funcionario where cpf = ? and senha = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, user);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Sistema window = new Sistema();
				window.getFrmDizimasterSistema().setVisible(true);
				tl.getFrmLogin().dispose();
				stmt.close();
				con.close();
				return true;
			} else {
				JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos!");
				stmt.close();
				con.close();
				return false;
			}
			
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível se conectar com o banco de dados!");
		}
		return false;
	}
	
	public static void cadastro(String cpf, String nome, String sexo, String numero, String email) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into funcionario(cpf, nome, sexo, celular, email, senha) values (?,?,?,?,?,?)";
			
			PreparedStatement stmt = con.prepareCall(sql);
			
			stmt.setString(1, cpf.replace(".", "").replace("-", ""));
			stmt.setString(2, nome);
			stmt.setString(3, sexo);
			stmt.setString(4, numero.replace("(", "").replace(")", "").replace("-", ""));
			stmt.setString(5, email);
			stmt.setString(6, "dizi@2022");
			
			stmt.execute();
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
		} catch (SQLException e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Não foi possível cadastrar funcionário!");
		}
	}
}