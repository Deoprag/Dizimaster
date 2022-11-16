package com.dizimaster.util;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import com.dizimaster.model.Dizimista;
import com.dizimaster.view.*;

public class DatabaseUtils {
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

	public static boolean login(String user, String password) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "select *from funcionario where cpf = ? and senha = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				if (!password.equals("dizi@2022")) {
					SistemaForm window = new SistemaForm();
					window.setFuncionario(rs.getInt("id"));
					window.getFrmDizimasterSistema().setVisible(true);
					stmt.close();
					con.close();
					return true;
				} else {
					FormAlterarSenha window = new FormAlterarSenha();
					window.setCpf(user);
					window.setSenha(password);
					window.setVisible(true);
				}
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
			String email) {
		try {
			LocalDate data = LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			Connection con = DatabaseUtils.conecta();
			String sql = "insert into funcionario(cpf, nome, nascimento, sexo, celular, email, dataCadastro) values (?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, cpf.replace(".", "").replace("-", ""));
			stmt.setString(2, nome);
			stmt.setDate(3, java.sql.Date.valueOf(data));
			stmt.setString(4, sexo);
			stmt.setString(5, numero.replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
			stmt.setString(6, email);
			stmt.setDate(7, Date.valueOf(GenericUtils.dataAtual()));

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

	public static boolean cadastroDizimista(String cpf, String nome, String nascimento, String sexo, String numero,
			String salario) {
		try {

			LocalDate data = LocalDate.parse(nascimento, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

			Connection con = DatabaseUtils.conecta();
			String sql = "insert into dizimista(cpf, nome, nascimento, sexo, celular, salario, dataCadastro) values (?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, cpf.replace(".", "").replace("-", ""));
			stmt.setString(2, nome);
			stmt.setDate(3, java.sql.Date.valueOf(data));
			stmt.setString(4, sexo);
			stmt.setString(5, numero.replace("(", "").replace(")", "").replace(" ", "").replace("-", ""));
			stmt.setFloat(6, Float.parseFloat(salario.replace(",", ".")));
			stmt.setDate(7, Date.valueOf(GenericUtils.dataAtual()));

			stmt.execute();
			stmt.close();
			con.close();

			JOptionPane.showMessageDialog(null, "Dizimista cadastrado com sucesso!");
			return true;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "O salário inserido é inválido!");
			return false;
		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "CPF já cadastrado. Tente novamente!");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Dizimista procurarDizimista(String cpf) {
		try {
			Dizimista dizimista = new Dizimista();
			Connection con = DatabaseUtils.conecta();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dizimista where cpf = " + cpf);
			if (rs.next()) {
				if (rs.getBoolean("ativo") == true) {
					dizimista.setId(rs.getInt("id"));
					dizimista.setNome(rs.getString("nome"));
					dizimista.setSalario(rs.getFloat("salario"));
					return dizimista;
				}
			} else {
				JOptionPane.showMessageDialog(null, "CPF não encontrado!");
			}
			con.close();
			stmt.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao procurar CPF!");
			e.printStackTrace();
		}
		return null;
	}

	public static boolean alterarSenha(String cpf, String senha, String senhaNova) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "update funcionario set senha = ? where senha = ? and cpf = ?";
			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, senhaNova);
			stmt.setString(2, senha);
			stmt.setString(3, cpf);

			stmt.execute();
			con.close();
			stmt.close();
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao alterar senha!");
			e.printStackTrace();
		}
		return false;
	}

	public static boolean registraDizimo(int funcionario, float valor, String obs, int dizimista) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into dizimo(dizimista, valor, observacao, funcionario, data, hora) values (?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setInt(1, dizimista);
			stmt.setFloat(2, valor);
			stmt.setString(3, obs);
			stmt.setInt(4, funcionario);
			stmt.setDate(5, Date.valueOf(GenericUtils.dataAtual()));
			stmt.setTime(6, Time.valueOf(GenericUtils.horaAtual()));

			stmt.execute();
			stmt.close();
			con.close();

			JOptionPane.showMessageDialog(null, "Dízimo registrado com sucesso!");
			return true;
		} catch (NumberFormatException e1) {
			JOptionPane.showMessageDialog(null, "O valor inserido é inválido!");
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static boolean registraOferta(int funcionario, boolean isDizimista, String nome, float valor, String obs,
			int dizimista) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into oferta(dizimista, isDizimista, nome, valor, observacao, funcionario, data, hora) values (?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setInt(1, dizimista);
			stmt.setBoolean(2, isDizimista);
			stmt.setString(3, nome);
			stmt.setFloat(4, valor);
			stmt.setString(5, obs);
			stmt.setInt(6, funcionario);
			stmt.setDate(7, Date.valueOf(GenericUtils.dataAtual()));
			stmt.setTime(8, Time.valueOf(GenericUtils.horaAtual()));

			stmt.execute();
			stmt.close();
			con.close();

			JOptionPane.showMessageDialog(null, "Oferta registrada com sucesso!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}