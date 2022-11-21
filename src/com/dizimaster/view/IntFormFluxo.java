package com.dizimaster.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import com.dizimaster.swing.*;
import com.dizimaster.controller.DatabaseUtils;
import com.dizimaster.model.*;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntFormFluxo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private LblGrafico pieChart;
	private JComboBox<Object> boxMes;
	private JComboBox<Object> boxAno;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormFluxo frame = new IntFormFluxo();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void mostraAno() throws SQLException {
		Connection con = DatabaseUtils.conecta();
		String sql = "select DATE_FORMAT(dataOferta, '%Y') as YearNumber from oferta GROUP BY YearNumber";
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

	private void mostraMes(int ano) throws SQLException {
		Connection con = DatabaseUtils.conecta();
		String sql = "select DATE_FORMAT(dataOferta, '%M') as MonthText, DATE_FORMAT(dataOferta, '%m') as MonthNumber from oferta where DATE_FORMAT(dataOferta, '%Y') = ? group by MonthNumber";
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
	
	private void mostraDados(int ano, int mes) {
		Connection con;
		try {
			con = DatabaseUtils.conecta();
			// OFERTA
			String sql = "SELECT SUM(valorOferta) from oferta where DATE_FORMAT(dataOferta, '%m') = ? and DATE_FORMAT(dataOferta, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, ano);
			stmt.setInt(2, mes);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				float oferta = rs.getFloat("valorOferta");
				
			}
			
			//DIZIMO
			sql = "SELECT SUM(valorDizimo) from dizimo where DATE_FORMAT(dataDizimo, '%m') = ? and DATE_FORMAT(dataOferta, '%Y') = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ano);
			stmt.setInt(2, mes);
			rs = stmt.executeQuery();
			if(rs.next()) {
				float dizimo = rs.getFloat("valorDizimo");
			}
			
			// DESPESA
			sql = "SELECT SUM(valorDespesa) from dizimo where DATE_FORMAT(dataDespesa, '%m') = ? and DATE_FORMAT(dataDespesa, '%Y') = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, ano);
			stmt.setInt(2, mes);
			rs = stmt.executeQuery();
			if(rs.next()) {
				float despesa = rs.getFloat("valorDespesa");
			}
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public IntFormFluxo() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				try {
					mostraAno();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);
		setBorder(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);

		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(null);
		panelBottom.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelBottom.setBackground(new Color(255, 255, 255));
		panelBottom.setBounds(62, 31, 925, 570);
		getContentPane().add(panelBottom);

		JLabel lblTitle = new JLabel("Fluxo de Caixa");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblTitle.setBounds(10, 11, 320, 35);
		panelBottom.add(lblTitle);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 50, 1000, 2);
		panelBottom.add(separator_1);

		pieChart = new LblGrafico();
		pieChart.setBounds(10, 108, 905, 451);
		panelBottom.add(pieChart);

		boxMes = new JComboBox();
		boxMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boxMes.getSelectedIndex() >= 0) {
					int ano = Integer.valueOf(boxAno.getSelectedItem().toString());
					Mes mes = (Mes)boxMes.getSelectedItem();
					mostraDados(ano, mes.getMes());
				}
			}
		});
		boxMes.setMaximumRowCount(12);
		boxMes.setFocusable(false);
		boxMes.setFocusTraversalKeysEnabled(false);
		boxMes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		boxMes.setBounds(815, 63, 100, 30);
		panelBottom.add(boxMes);

		boxAno = new JComboBox();
		boxAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(boxAno.getSelectedIndex() >= 0) {
					int ano = Integer.valueOf(boxAno.getSelectedItem().toString());
					try {
						boxMes.removeAllItems();
						mostraMes(ano);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		boxAno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		boxAno.setBounds(705, 64, 60, 30);
		panelBottom.add(boxAno);

		JLabel lblMes = new JLabel("Mês");
		lblMes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMes.setBounds(775, 63, 40, 30);
		panelBottom.add(lblMes);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblAno.setBounds(665, 63, 40, 30);
		panelBottom.add(lblAno);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(IntFormFluxo.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblBg.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBg);

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
