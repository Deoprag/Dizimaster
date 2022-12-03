package com.dizimaster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dizimaster.model.Dizimista;
import com.dizimaster.model.Historico;

public class HistoricoDAO {
	public static List<Historico> listarHistorico(Dizimista dizimista){
		List<Historico> listaHistorico = new ArrayList<>();
		try {
			Connection con = DBConnection.conecta();
			String sql = "SELECT * from oferta where dizimista = ?";
			PreparedStatement stmt = con.prepareStatement(sql);

			stmt.setInt(1, dizimista.getId());
			ResultSet rs = stmt.executeQuery();
			
			listaHistorico.clear();
			while (rs.next()) {
				Historico historico = new Historico();
				historico.setTipo("Oferta");
				historico.setValor(rs.getFloat("valor"));
				historico.setObservacao(rs.getString("observacao"));
				historico.setFuncionario(rs.getInt("funcionario"));
				historico.setData(rs.getDate("data").toLocalDate());
				historico.setHora(rs.getString("hora"));
				listaHistorico.add(historico);
			}
			
			sql = "SELECT * from dizimo where dizimista = ?";
			stmt = con.prepareStatement(sql);
			
			stmt.setInt(1, dizimista.getId());
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				Historico historico = new Historico();
				historico.setTipo("Dizimo");
				historico.setValor(rs.getFloat("valor"));
				historico.setObservacao(rs.getString("observacao"));
				historico.setFuncionario(rs.getInt("funcionario"));
				historico.setData(rs.getDate("data").toLocalDate());
				historico.setHora(rs.getString("hora"));
				listaHistorico.add(historico);
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaHistorico;
	}
}
