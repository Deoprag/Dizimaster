package com.dizimaster.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.dizimaster.swing.*;
import com.dizimaster.controller.DatabaseUtils;
import com.dizimaster.model.*;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.dizimaster.swing.LblGrafico.PeiChartType;

public class IntFormFluxo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private LblGrafico pieChart;
	private LblGrafico pieChartTotal;
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
	
	private Color getColor(int index) {
		Color[] color = new Color[] {new Color(255, 230, 0), new Color(0, 0, 170), new Color(170, 0, 0), new Color(0, 170, 0)};
		return color[index];
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
		try {
			pieChart.clearData();
			pieChartTotal.clearData();
			Connection con = DatabaseUtils.conecta();
			float oferta = 0, dizimo = 0, despesa = 0;
			
			// OFERTA
			String sql = "SELECT SUM(valorOferta) from oferta where DATE_FORMAT(dataOferta, '%m') = ? and DATE_FORMAT(dataOferta, '%Y') = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(2, ano);
			stmt.setInt(1, mes);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				oferta = rs.getFloat("SUM(valorOferta)");
			}
			
			//DIZIMO
			sql = "SELECT SUM(valorDizimo) from dizimo where DATE_FORMAT(dataDizimo, '%m') = ? and DATE_FORMAT(dataDizimo, '%Y') = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(2, ano);
			stmt.setInt(1, mes);
			rs = stmt.executeQuery();
			while(rs.next()) {
				dizimo = rs.getFloat("SUM(valorDizimo)");
			}
			
			// DESPESA
			sql = "SELECT SUM(valorDespesa) from despesa where DATE_FORMAT(dataDespesa, '%m') = ? and DATE_FORMAT(dataDespesa, '%Y') = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(2, ano);
			stmt.setInt(1, mes);
			rs = stmt.executeQuery();
			while(rs.next()) {
				despesa = rs.getFloat("SUM(valorDespesa)");
			}
			
			int index = 0;
			pieChart.addData(new Grafico("Oferta", oferta, getColor(index++)));
			pieChart.addData(new Grafico("Dizimo", dizimo, getColor(index++)));
			
			Float totalEntrada = dizimo + oferta;
			Float saldo = totalEntrada - despesa;
			
			pieChartTotal.addData(new Grafico("Despesas", despesa, getColor(index++)));
			pieChartTotal.addData(new Grafico("Saldo", saldo, getColor(index++)));
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private void voltar(){
		this.dispose();
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

		JPanel panelMid = new JPanel();
		panelMid.setLayout(null);
		panelMid.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelMid.setBackground(new Color(255, 255, 255));
		panelMid.setBounds(47, 31, 925, 570);
		getContentPane().add(panelMid);
		
		JButton btnSair = new JButton("VOLTAR");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSair.setBackground(new Color(143, 20, 29));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSair.setBackground(new Color(184, 44, 54));
			}
		});
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar?", "Voltar?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					voltar();
				}
			}
		});
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(825, 11, 90, 30);
		panelMid.add(btnSair);

		JLabel lblTitle = new JLabel("Fluxo de Caixa");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblTitle.setBounds(10, 11, 320, 35);
		panelMid.add(lblTitle);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 50, 1000, 2);
		panelMid.add(separator_1);

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
		panelMid.add(boxMes);

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
		panelMid.add(boxAno);
		
		

		JLabel lblMes = new JLabel("Mês");
		lblMes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMes.setBounds(775, 63, 40, 30);
		panelMid.add(lblMes);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblAno.setBounds(665, 63, 40, 30);
		panelMid.add(lblAno);
		
		pieChart = new LblGrafico();
		pieChart.setBounds(8, 104, 450, 451);
		panelMid.add(pieChart);
		pieChart.setFocusable(false);
		pieChart.setFocusTraversalKeysEnabled(false);
		
		pieChartTotal = new LblGrafico();
		pieChartTotal.setBounds(466, 104, 450, 451);
		panelMid.add(pieChartTotal);
		pieChartTotal.setFocusable(false);
		pieChartTotal.setFocusTraversalKeysEnabled(false);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(IntFormFluxo.class.getResource("/com/dizimaster/img/heaven-bg.jpg")));
		lblBg.setBounds(0, 0, 1020, 638);
		getContentPane().add(lblBg);

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
