package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.dizimaster.model.Dizimo;
import com.dizimaster.model.Oferta;

public class DizimoDAO {
	
	public static boolean registraDizimo(Dizimo dizimo) {
		try {
			Connection con = DBConnection.conecta();
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
	
	public static float somaDizimo(int mes, int ano) {
		float dizimo = 0;
		try {
			Connection con = DBConnection.conecta();
			String sql = "SELECT SUM(valor) from dizimo where DATE_FORMAT(data, '%m') = ? and DATE_FORMAT(data, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				dizimo = rs.getFloat("SUM(valor)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dizimo;
	}
	
	public static List<Dizimo> listaDizimo(int mes, int ano) {
		List<Dizimo> dizimoLista = new ArrayList<>();
		try {
			Connection con = DBConnection.conecta();
			String sql = "SELECT * from dizimo where DATE_FORMAT(data, '%m') = ? and DATE_FORMAT(data, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rs = stmt.executeQuery();
			
			dizimoLista.clear();
			while (rs.next()) {
				Dizimo dizimo = new Dizimo();
				dizimo.setId(rs.getInt("id"));
				dizimo.setDizimista(rs.getInt("dizimista"));
				dizimo.setValor(rs.getFloat("valor"));
				dizimo.setObservacao(rs.getString("observacao"));
				dizimo.setFuncionario(rs.getInt("funcionario"));
				dizimo.setData(rs.getDate("data").toLocalDate());
				dizimo.setHora(rs.getString("hora"));
				dizimoLista.add(dizimo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dizimoLista;
	}
}
