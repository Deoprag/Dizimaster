package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JComboBox;

import com.dizimaster.model.Mes;

public class UtilDAO {

	public static void mostraMes(int ano, JComboBox<Object> boxMes) throws SQLException {
		Connection con = DBConnection.conecta();
		String sql = "select DATE_FORMAT(data, '%M') as MonthText, DATE_FORMAT(data, '%m') as MonthNumber from oferta where DATE_FORMAT(data, '%Y') = ? group by MonthNumber";
		PreparedStatement stmt = con.prepareStatement(sql);

		stmt.setInt(1, ano);

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			String textoMes = rs.getString("MonthText");
			int mes = rs.getInt("MonthNumber");
			boxMes.addItem(new Mes(mes, textoMes));
		}
		rs.close();
		stmt.close();
		con.close();
	}

	public static void mostraAno(JComboBox<Object> boxAno) throws SQLException {
		Connection con = DBConnection.conecta();
		String sql = "select DATE_FORMAT(data, '%Y') as YearNumber from oferta GROUP BY YearNumber";
		PreparedStatement stmt = con.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			int ano = rs.getInt("YearNumber");
			boxAno.addItem(ano + "");
		}
		rs.close();
		stmt.close();
		con.close();
	}

}
