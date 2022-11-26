package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.dizimaster.model.Dizimista;

public class DizimistaDAO {
	
	public static boolean cadastroDizimista(Dizimista cadDizimista) {
		try {
			Connection con = DBConnection.conecta();
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
	
	public static Dizimista pesquisaDizimista(String cpf) {
		Dizimista dizimistaPesquisa;
		dizimistaPesquisa = null;

		try {
			Connection con = DBConnection.conecta();
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
			Connection con = DBConnection.conecta();
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
}
