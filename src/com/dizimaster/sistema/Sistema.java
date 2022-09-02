package com.dizimaster.sistema;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import com.dizimaster.cadastro.TelaCadastro;

import java.awt.Cursor;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Sistema {

	private JFrame frmDizimasterSistema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sistema window = new Sistema();
					window.getFrmDizimasterSistema().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Sistema() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmDizimasterSistema(new JFrame());
		getFrmDizimasterSistema().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-2.png"));
		getFrmDizimasterSistema().setResizable(false);
		getFrmDizimasterSistema().setTitle("DIZIMASTER - Sistema");
		getFrmDizimasterSistema().setBounds(100, 100, 1280, 720);
		getFrmDizimasterSistema().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmDizimasterSistema().getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 1280, 720);
		getFrmDizimasterSistema().getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNovoFuncionario = new JButton("Novo Funcionário");
		btnNovoFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					TelaCadastro window = new TelaCadastro();
					window.getFrmCadastro().setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNovoFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNovoFuncionario.setBackground(new Color(70, 92, 89));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNovoFuncionario.setBackground(new Color(88, 117, 113));
			}
		});
		btnNovoFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoFuncionario.setForeground(Color.WHITE);
		btnNovoFuncionario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.scrollbar, new Color(255, 255, 255)));
		btnNovoFuncionario.setBackground(new Color(88, 117, 113));
		btnNovoFuncionario.setFont(new Font("Lucida Console", Font.BOLD, 15));
		btnNovoFuncionario.setBounds(540, 379, 200, 75);
		panel.add(btnNovoFuncionario);
		
		JLabel lblNewLabel = new JLabel("Teste");
		lblNewLabel.setForeground(SystemColor.menu);
		lblNewLabel.setFont(new Font("Lucida Console", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(457, 22, 362, 103);
		panel.add(lblNewLabel);
	}

	/**
	 * @return the frmDizimasterSistema
	 */
	public JFrame getFrmDizimasterSistema() {
		return frmDizimasterSistema;
	}

	/**
	 * @param frmDizimasterSistema the frmDizimasterSistema to set
	 */
	public void setFrmDizimasterSistema(JFrame frmDizimasterSistema) {
		this.frmDizimasterSistema = frmDizimasterSistema;
	}
}
