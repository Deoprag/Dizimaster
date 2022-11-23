package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class IntFormComprovantes extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormComprovantes frame = new IntFormComprovantes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IntFormComprovantes() {
		setBounds(100, 100, 1020, 700);
		getContentPane().setLayout(null);

		JPanel panelTop = new JPanel();
		panelTop.setLayout(null);
		panelTop.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelTop.setBackground(Color.WHITE);
		panelTop.setBounds(222, 11, 560, 120);
		getContentPane().add(panelTop);

		JLabel lblConsulta = new JLabel("Consultar Dizimista");
		lblConsulta.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblConsulta.setBounds(10, 11, 320, 35);
		panelTop.add(lblConsulta);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.LIGHT_GRAY);
		separator.setBounds(0, 50, 1000, 2);
		panelTop.add(separator);

		MaskFormatter cpf = null;
		try {
			cpf = new MaskFormatter("###.###.###-##");
			cpf.setPlaceholder("*");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txtCpf = new JFormattedTextField(cpf);
		txtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtCpf.setBackground(Color.WHITE);
		txtCpf.setBounds(50, 72, 125, 30);
		panelTop.add(txtCpf);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpf.setBounds(10, 70, 87, 30);
		panelTop.add(lblCpf);

		JButton btnSearch = new JButton("");
		btnSearch.setRolloverEnabled(false);
		btnSearch.setRequestFocusEnabled(false);
		btnSearch.setFocusable(false);
		btnSearch.setFocusTraversalKeysEnabled(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBorder(null);
		btnSearch.setBackground(Color.WHITE);
		btnSearch.setBounds(185, 77, 25, 25);
		panelTop.add(btnSearch);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLimpar.setFocusable(false);
		btnLimpar.setBorder(new LineBorder(new Color(60, 60, 60), 1, true));
		btnLimpar.setBackground(SystemColor.scrollbar);
		btnLimpar.setBounds(415, 72, 135, 30);
		panelTop.add(btnLimpar);

		JButton btnSair = new JButton("VOLTAR");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(460, 12, 90, 30);
		panelTop.add(btnSair);

	}
}
