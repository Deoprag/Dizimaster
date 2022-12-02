package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dizimaster.model.Despesa;
import com.dizimaster.model.Dizimo;

public class DespesaDAO {
	
	public static boolean registraDespesa(Despesa despesa) {
		try {
			Connection con = DBConnection.conecta();
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
		} catch (SQLIntegrityConstraintViolationException e1) {
			JOptionPane.showMessageDialog(null, "A descrição não pode ser menor que 20 caracteres");
			e1.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static float somaDespesa(int mes, int ano) {
		float despesa = 0;
		try {
			Connection con = DBConnection.conecta();
			String sql = "SELECT SUM(valor) from despesa where DATE_FORMAT(data, '%m') = ? and DATE_FORMAT(data, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				despesa = rs.getFloat("SUM(valor)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return despesa;
	}
	
	public static List<Despesa> listaDespesa(int mes, int ano) {
		List<Despesa> despesaLista = new ArrayList<>();
		try {
			Connection con = DBConnection.conecta();
			String sql = "SELECT * from despesa where DATE_FORMAT(data, '%m') = ? and DATE_FORMAT(data, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rs = stmt.executeQuery();
			
			despesaLista.clear();
			while (rs.next()) {
				Despesa despesa = new Despesa();
				despesa.setId(rs.getInt("id"));
				despesa.setValor(rs.getFloat("valor"));
				despesa.setDescricao(rs.getString("descricao"));
				despesa.setFuncionario(rs.getInt("funcionario"));
				despesa.setData(rs.getDate("data").toLocalDate());
				despesa.setHora(rs.getString("hora"));
				despesaLista.add(despesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return despesaLista;
	}
}
