package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.dizimaster.model.Funcionario;
import com.dizimaster.view.FormAlterarSenha;
import com.dizimaster.view.FormSistema;

public class FuncionarioDAO {
	private static Funcionario funcionario;
	
	public static boolean login(String user, String password) {
		try {
			Connection con = DBConnection.conecta();
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
			Connection con = DBConnection.conecta();
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
	
	public static boolean alterarSenha(String cpf, String senha, String senhaNova) {
		try {
			Connection con = DBConnection.conecta();
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
	
	public static Funcionario pesquisaFuncionario(String cpf) {
		Funcionario funcionarioPesquisa;
		funcionarioPesquisa = null;

		try {
			Connection con = DBConnection.conecta();
			String sql = "select * from funcionario where cpf = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, cpf);
			
			ResultSet rs = stmt.executeQuery();

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
	
	public static Funcionario pesquisaFuncionarioId(String id) {
		Funcionario funcionarioPesquisa;
		funcionarioPesquisa = null;

		try {
			Connection con = DBConnection.conecta();
			String sql = "select * from funcionario where id = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
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
			Connection con = DBConnection.conecta();
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
	
	public static Funcionario getFuncionario() {
		return funcionario;
	}

	public static void setFuncionario(Funcionario funcionario) {
		FuncionarioDAO.funcionario = funcionario;
	}
}
