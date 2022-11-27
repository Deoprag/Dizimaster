package com.dizimaster.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class IntFormRelatorioOferta extends JInternalFrame {
	private JTable table;
	private JTable tableDizimo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormRelatorioOferta frame = new IntFormRelatorioOferta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public IntFormRelatorioOferta() {
		getContentPane().setBackground(new Color(230, 243, 255));
		setBorder(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 1020, 700);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelTop.setBackground(new Color(235, 235, 235));
		panelTop.setBounds(10, 11, 1000, 138);
		getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		JLabel lblTitle = new JLabel("Relatório de Oferta");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblTitle.setBounds(10, 10, 320, 35);
		panelTop.add(lblTitle);
		
		JButton btnSair = new JButton("VOLTAR");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(900, 10, 90, 30);
		panelTop.add(btnSair);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 50, 1000, 2);
		panelTop.add(separator_1);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelBottom.setEnabled(false);
		panelBottom.setBackground(new Color(235, 235, 235));
		panelBottom.setBounds(10, 160, 1000, 490);
		getContentPane().add(panelBottom);
		panelBottom.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(235, 235, 235));
		scrollPane.setBounds(5, 11, 990, 473);
		panelBottom.add(scrollPane);
		
		tableDizimo = new JTable();
		tableDizimo.setBackground(new Color(235, 235, 235));
		tableDizimo.setFillsViewportHeight(true);
		tableDizimo.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "ID Dizimista", "Valor", "Observa\u00E7\u00E3o", "ID Funcion\u00E1rio", "Data", "Hora"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableDizimo.getColumnModel().getColumn(0).setPreferredWidth(29);
		tableDizimo.getColumnModel().getColumn(1).setPreferredWidth(27);
		tableDizimo.getColumnModel().getColumn(2).setPreferredWidth(32);
		tableDizimo.getColumnModel().getColumn(3).setPreferredWidth(220);
		tableDizimo.getColumnModel().getColumn(4).setPreferredWidth(35);
		tableDizimo.getColumnModel().getColumn(5).setPreferredWidth(38);
		tableDizimo.getColumnModel().getColumn(6).setPreferredWidth(38);
		scrollPane.setViewportView(tableDizimo);
	}
}
