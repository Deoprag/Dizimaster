package com.dizimaster.controller;

import java.sql.*;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

import com.dizimaster.model.Despesa;
import com.dizimaster.model.Dizimista;
import com.dizimaster.model.Dizimo;
import com.dizimaster.model.Funcionario;
import com.dizimaster.model.Oferta;
import com.dizimaster.view.*;

public class DatabaseUtils {
	public static String path = "jdbc:mysql://localhost/dizimaster_db";
	private static String user = "root";
	private static String password = "";
	private static Funcionario funcionario;

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
			String sql = "select * from funcionario where cpf = ? and senha = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setString(1, user);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				funcionario = new Funcionario();
				funcionario.setId(rs.getInt("id"));
				funcionario.setCpf(rs.getString("cpf"));
				funcionario.setNome(rs.getString("nome"));
				funcionario.setNascimento(rs.getDate("nascimento").toLocalDate());
				funcionario.setSexo(rs.getString("sexo").charAt(0));
				funcionario.setEmail(rs.getString("email"));
				funcionario.setDataCadastro(rs.getDate("dataCadastro").toLocalDate());
				funcionario.setSenha(rs.getString("senha"));
				funcionario.setAtivo(rs.getBoolean("ativo"));
				funcionario.setAdmin(rs.getBoolean("isAdmin"));
				if (rs.getBoolean("ativo") == true) {
					if (!password.equals("dizi@2022")) {
						FormSistema window = new FormSistema();
						window.setFuncionario(funcionario);
						window.getFrmDizimasterSistema().setVisible(true);
						stmt.close();
						con.close();
						return true;
					} else {
						FormAlterarSenha window = new FormAlterarSenha();
						window.setFuncionario(funcionario);
						window.setVisible(true);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Cadastro desativado! Entre em contato com um administrador");
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

	public static boolean cadastroFuncionario(Funcionario cadFuncionario) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into funcionario(cpf, nome, nascimento, sexo, celular, email, dataCadastro, isAdmin) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, cadFuncionario.getCpf());
			stmt.setString(2, cadFuncionario.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(cadFuncionario.getNascimento()));
			stmt.setString(4, String.valueOf(cadFuncionario.getSexo()));
			stmt.setString(5, cadFuncionario.getCelular());
			stmt.setString(6, cadFuncionario.getEmail());
			stmt.setDate(7, Date.valueOf(cadFuncionario.getDataCadastro()));
			stmt.setBoolean(8, cadFuncionario.isAdmin());

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

	public static boolean cadastroDizimista(Dizimista cadDizimista) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into dizimista(cpf, nome, nascimento, sexo, celular, salario, dataCadastro, ativo) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, cadDizimista.getCpf());
			stmt.setString(2, cadDizimista.getNome());
			stmt.setDate(3, java.sql.Date.valueOf(cadDizimista.getNascimento()));
			stmt.setString(4, String.valueOf(cadDizimista.getSexo()));
			stmt.setString(5, cadDizimista.getCelular());
			stmt.setFloat(6, cadDizimista.getSalario());
			stmt.setDate(7, Date.valueOf(cadDizimista.getDataCadastro()));
			stmt.setBoolean(8, cadDizimista.isAtivo());

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

	public static boolean registraDizimo(Dizimo dizimo) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into dizimo(dizimista, valor, observacao, funcionario, data, hora) values (?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setInt(1, dizimo.getDizimista());
			stmt.setFloat(2, dizimo.getValor());
			stmt.setString(3, dizimo.getObservacao());
			stmt.setInt(4, dizimo.getFuncionario());
			stmt.setDate(5, Date.valueOf(dizimo.getData()));
			stmt.setTime(6, Time.valueOf(dizimo.getHora()));

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

	public static boolean registraOferta(Oferta oferta) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into oferta(dizimista, isDizimista, nome, valor, observacao, funcionario, data, hora) values (?,?,?,?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setInt(1, oferta.getDizimista());
			stmt.setBoolean(2, oferta.isDizimista());
			stmt.setString(3, oferta.getNome());
			stmt.setFloat(4, oferta.getValor());
			stmt.setString(5, oferta.getObservacao());
			stmt.setInt(6, oferta.getFuncionario());
			stmt.setDate(7, Date.valueOf(oferta.getData()));
			stmt.setTime(8, Time.valueOf(oferta.getHora()));

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

	public static boolean registraDespesa(Despesa despesa) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "insert into despesa(valor, descricao, funcionario, data, hora) values (?,?,?,?,?)";

			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setFloat(1, despesa.getValor());
			stmt.setString(2, despesa.getDescricao());
			stmt.setInt(3, despesa.getFuncionario());
			stmt.setDate(4, Date.valueOf(despesa.getData()));
			stmt.setTime(5, Time.valueOf(despesa.getHora()));

			stmt.execute();
			stmt.close();
			con.close();

			JOptionPane.showMessageDialog(null, "Despesa registrada com sucesso!");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public static Funcionario pesquisaFuncionario(String cpf) {
		Funcionario funcionarioPesquisa;
		funcionarioPesquisa = null;

		try {
			Connection con = DatabaseUtils.conecta();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from funcionario where cpf = " + cpf);

			if (rs.next()) {
				funcionarioPesquisa = new Funcionario();
				funcionarioPesquisa.setId(rs.getInt("id"));
				funcionarioPesquisa.setCpf(rs.getString("cpf"));
				funcionarioPesquisa.setNome(rs.getString("nome"));
				funcionarioPesquisa.setNascimento(rs.getDate("nascimento").toLocalDate());
				funcionarioPesquisa.setSexo(rs.getString("sexo").charAt(0));
				funcionarioPesquisa.setEmail(rs.getString("email"));
				funcionarioPesquisa.setCelular(rs.getString("celular"));
				funcionarioPesquisa.setSenha(rs.getString("senha"));
				funcionarioPesquisa.setDataCadastro(rs.getDate("dataCadastro").toLocalDate());
				funcionarioPesquisa.setAtivo(rs.getBoolean("ativo"));
				funcionarioPesquisa.setAdmin(rs.getBoolean("isAdmin"));

				con.close();
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return funcionarioPesquisa;
	}

	public static boolean alterarFuncionario(Funcionario altFuncionario, Boolean senha) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "update funcionario set nome = ?, celular = ?, email = ?, nascimento = ?, sexo = ?, isAdmin = ?, ativo = ?, senha = ? where cpf = ?";
			if (senha == true) {
				altFuncionario.setSenha("dizi@2022");
			}
			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, altFuncionario.getNome());
			stmt.setString(2, altFuncionario.getCelular());
			stmt.setString(3, altFuncionario.getEmail());
			stmt.setDate(4, Date.valueOf(altFuncionario.getNascimento()));
			stmt.setString(5, String.valueOf(altFuncionario.getSexo()));
			stmt.setBoolean(6, altFuncionario.isAdmin());
			stmt.setBoolean(7, altFuncionario.isAtivo());
			stmt.setString(8, altFuncionario.getSenha());
			stmt.setString(9, altFuncionario.getCpf());

			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!");
			e.printStackTrace();
		}
		return false;
	}

	public static Dizimista pesquisaDizimista(String cpf) {
		Dizimista dizimistaPesquisa;
		dizimistaPesquisa = null;

		try {
			Connection con = DatabaseUtils.conecta();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dizimista where cpf = " + cpf);

			if (rs.next()) {
				dizimistaPesquisa = new Dizimista();
				dizimistaPesquisa.setId(rs.getInt("id"));
				dizimistaPesquisa.setCpf(rs.getString("cpf"));
				dizimistaPesquisa.setNome(rs.getString("nome"));
				dizimistaPesquisa.setNascimento(rs.getDate("nascimento").toLocalDate());
				dizimistaPesquisa.setSexo(rs.getString("sexo").charAt(0));
				dizimistaPesquisa.setCelular(rs.getString("celular"));
				dizimistaPesquisa.setSalario(rs.getFloat("salario"));
				dizimistaPesquisa.setDataCadastro(rs.getDate("dataCadastro").toLocalDate());
				dizimistaPesquisa.setAtivo(rs.getBoolean("ativo"));

				con.close();
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return dizimistaPesquisa;
	}

	public static boolean alterarDizimista(Dizimista altDizimista) {
		try {
			Connection con = DatabaseUtils.conecta();
			String sql = "update dizimista set nome = ?, celular = ?, salario = ?, nascimento = ?, sexo = ?, ativo = ? where cpf = ?";
			PreparedStatement stmt = con.prepareCall(sql);

			stmt.setString(1, altDizimista.getNome());
			stmt.setString(2, altDizimista.getCelular());
			stmt.setFloat(3, altDizimista.getSalario());
			stmt.setDate(4, Date.valueOf(altDizimista.getNascimento()));
			stmt.setString(5, String.valueOf(altDizimista.getSexo()));
			stmt.setBoolean(6, altDizimista.isAtivo());
			stmt.setString(7, altDizimista.getCpf());

			stmt.execute();
			stmt.close();
			con.close();
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
			return true;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados!");
			e.printStackTrace();
		}
		return false;
	}

	public static Funcionario getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(Funcionario funcionario) {
		DatabaseUtils.funcionario = funcionario;
	}

	public static float valorMensal(int dizimista, int mesInicio, int mesFim, int ano) {
		try {
			float somaDizimo = 0, somaOferta = 0;
			float total = 0;
			Connection con = DatabaseUtils.conecta();
			String sql = "SELECT SUM(valor) from oferta where dizimista = ? and DATE_FORMAT(data, '%m') >= ? and DATE_FORMAT(data, '%m') <= ? and DATE_FORMAT(data, '%Y') = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, dizimista);
			stmt.setInt(2, mesInicio);
			stmt.setInt(3, mesFim);
			stmt.setInt(4, ano);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				somaOferta = rs.getFloat("SUM(valor)");
			}

			sql = "SELECT SUM(valor) from dizimo where dizimista = ? and DATE_FORMAT(data, '%m') >= ? and DATE_FORMAT(data, '%m') <= ? and DATE_FORMAT(data, '%Y') = ?;";
			stmt = con.prepareStatement(sql);

			stmt.setInt(1, dizimista);
			stmt.setInt(2, mesInicio);
			stmt.setInt(3, mesFim);
			stmt.setInt(4, ano);

			rs = stmt.executeQuery();
			while (rs.next()) {
				somaDizimo = rs.getFloat("SUM(valor)");
			}

			rs.close();
			stmt.close();
			con.close();
			total = somaDizimo + somaOferta;
			System.out.println(somaDizimo);
			System.out.println(somaOferta);
			return total;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
}