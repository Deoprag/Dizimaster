package com.dizimaster.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.dizimaster.view.*;

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
			Connection con = DatabaseUtils.conecta();
			String sql = "select *from funcionario where cpf = ? and senha = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				SistemaForm window = new SistemaForm();
				window.getFrmDizimasterSistema().setVisible(true);
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

	public static boolean cadastroFuncionario(String cpf, String nome, String nascimento, String sexo, String numero,
			String salario, String email) {
		try {

			LocalDate data = LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into funcionario(cpf, nome, nascimento, sexo, celular, salario, email) values (?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, cpf.replace(".", "").replace("-", ""));
			stmt.setString(2, nome);
			stmt.setDate(3, java.sql.Date.valueOf(data));
			stmt.setString(4, sexo);
			stmt.setString(5, numero.replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
			stmt.setFloat(6, Float.valueOf(salario.replace(",", ".")));
			stmt.setString(7, email);

			stmt.execute();
			stmt.close();
			con.close();

			JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
			return true;
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "CPF já cadastrado. Tente novamente!");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}