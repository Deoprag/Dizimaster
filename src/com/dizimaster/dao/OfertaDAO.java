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

import com.dizimaster.model.Oferta;

public class OfertaDAO {

	public static boolean registraOferta(Oferta oferta) {
		try {
			Connection con = DBConnection.conecta();
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

	public static float somaOferta(int mes, int ano) {
		float oferta = 0;
		try {
			Connection con = DBConnection.conecta();
			String sql = "SELECT SUM(valor) from oferta where DATE_FORMAT(data, '%m') = ? and DATE_FORMAT(data, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				oferta = rs.getFloat("SUM(valor)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return oferta;
	}

	public static List<Oferta> listaOferta(int mes, int ano) {
		List<Oferta> ofertaLista = new ArrayList<>();
		try {
			Connection con = DBConnection.conecta();
			String sql = "SELECT * from oferta where DATE_FORMAT(data, '%m') = ? and DATE_FORMAT(data, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, mes);
			stmt.setInt(2, ano);
			ResultSet rs = stmt.executeQuery();
			
			ofertaLista.clear();
			while (rs.next()) {
				Oferta oferta = new Oferta();
				oferta.setId(rs.getInt("id"));
				oferta.setDizimista(rs.getInt("dizimista"));
				oferta.setIsDizimista(rs.getBoolean("isDizimista"));
				oferta.setNome(rs.getString("nome"));
				oferta.setValor(rs.getFloat("valor"));
				oferta.setObservacao(rs.getString("observacao"));
				oferta.setFuncionario(rs.getInt("funcionario"));
				oferta.setData(rs.getDate("data").toLocalDate());
				oferta.setHora(rs.getString("hora"));
				ofertaLista.add(oferta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ofertaLista;
	}
}
