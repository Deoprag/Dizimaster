package com.dizimaster.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
	
	public static boolean cadastro(String cpf, String nome, String nascimento, String sexo, String numero, String salario, String email) {
		try {
			
			LocalDate data = LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into funcionario(cpf, nome, nascimento, sexo, celular, salario, email, senha) values (?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmt = con.prepareCall(sql);
		
			stmt.setString(1, cpf.replace(".", "").replace("-", ""));
			stmt.setString(2, nome);
			stmt.setDate(3, java.sql.Date.valueOf(data));
			stmt.setString(4, sexo);
			stmt.setString(5, numero.replace("(", "").replace(")", "").replace("-", ""));
			stmt.setFloat(6, Float.valueOf(salario.replace("R", "").replace("$", "")));
			stmt.setString(7, email);
			stmt.setString(8, "dizi@2022");
			
			stmt.execute();
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}