package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class IntFormDizimo extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormDizimo frame = new IntFormDizimo();
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
	public IntFormDizimo() {
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(335, 34, 350, 570);
		getContentPane().add(panelCadastro);
		
		JButton btnSair = new JButton("VOLTAR");
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(56, 495, 90, 40);
		panelCadastro.add(btnSair);
		
		JLabel lblTitulo = new JLabel("Dízimo");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblTitulo.setBackground(Color.GRAY);
		lblTitulo.setBounds(55, 200, 240, 35);
		panelCadastro.add(lblTitulo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/logo-small.png")));
		lblLogo.setBounds(100, 20, 150, 150);
		panelCadastro.add(lblLogo);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnEnviar.setFocusable(false);
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(0, 122, 152));
		btnEnviar.setBounds(202, 495, 90, 40);
		panelCadastro.add(btnEnviar);
		
		JLabel lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblBackgroundPanel.setBounds(0, 0, 350, 570);
		panelCadastro.add(lblBackgroundPanel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/pray-bg.jpg")));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
	}
}
