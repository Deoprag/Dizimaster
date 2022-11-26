package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

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
}
