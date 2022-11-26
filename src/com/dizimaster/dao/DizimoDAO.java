package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

import javax.swing.JOptionPane;

import com.dizimaster.model.Dizimo;

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
}
