package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Time;

import javax.swing.JOptionPane;

import com.dizimaster.model.Despesa;

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
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
