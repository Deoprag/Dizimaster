package com.dizimaster.cadastro;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class TelaCadastro {

	private JFrame frmCadastroDizimaster;
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	private JPasswordField passwordField_1;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.frmCadastroDizimaster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaCadastro() {
		initialize();
	}
	
	private static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastroDizimaster = new JFrame();
		frmCadastroDizimaster.setTitle("CADASTRO - Dizimaster");
		frmCadastroDizimaster.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\logo-2.png"));
		frmCadastroDizimaster.setResizable(false);
		frmCadastroDizimaster.setBounds(100, 100, 650, 530);
		frmCadastroDizimaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDizimaster.getContentPane().setLayout(null);
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Arial", Font.BOLD, 8));
		lblDeopragLabs.setBounds(10, 466, 66, 25);
		frmCadastroDizimaster.getContentPane().add(lblDeopragLabs);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(414, 11, 210, 469);
		frmCadastroDizimaster.getContentPane().add(panelCadastro);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setForeground(new Color(0, 0, 128));
		lblUsuario.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblUsuario.setBorder(null);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setAlignmentX(0.5f);
		lblUsuario.setBounds(30, 172, 150, 24);
		panelCadastro.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Usuário");
		txtUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(0, 191, 255)));
		txtUsuario.setBackground(new Color(224, 255, 255));
		txtUsuario.setBounds(30, 190, 150, 30);
		panelCadastro.add(txtUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 0, 128));
		lblSenha.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblSenha.setAlignmentX(0.5f);
		lblSenha.setBounds(30, 231, 150, 24);
		panelCadastro.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setToolTipText("Senha");
		txtSenha.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtSenha.setColumns(10);
		txtSenha.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(0, 191, 255)));
		txtSenha.setBackground(new Color(224, 255, 255));
		txtSenha.setBounds(30, 251, 150, 30);
		panelCadastro.add(txtSenha);
		
		JLabel txtConfSenha = new JLabel("Confirme a Senha:");
		txtConfSenha.setForeground(new Color(0, 0, 128));
		txtConfSenha.setFont(new Font("Lucida Console", Font.BOLD, 12));
		txtConfSenha.setAlignmentX(0.5f);
		txtConfSenha.setBounds(30, 292, 150, 24);
		panelCadastro.add(txtConfSenha);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setToolTipText("Senha");
		passwordField_1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		passwordField_1.setColumns(10);
		passwordField_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(0, 191, 255)));
		passwordField_1.setBackground(new Color(224, 255, 255));
		passwordField_1.setBounds(30, 312, 150, 30);
		panelCadastro.add(passwordField_1);
		
		JLabel lblEmail = new JLabel("Endereço de Email:");
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(30, 353, 150, 24);
		panelCadastro.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Usuário");
		txtEmail.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(0, 191, 255)));
		txtEmail.setBackground(new Color(224, 255, 255));
		txtEmail.setBounds(30, 373, 150, 30);
		panelCadastro.add(txtEmail);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(35, 11, 150, 150);
		panelCadastro.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\logo-3.png"));
		
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Lucida Console", Font.BOLD, 11));
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(60, 122, 194));
		btnEnviar.setBounds(10, 418, 90, 40);
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviar.setBackground(new Color(33, 91, 158));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEnviar.setBackground(new Color(60, 122, 194));
			}
		});
		panelCadastro.add(btnEnviar);
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar?", "Voltar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnVoltar.setBackground(new Color(143, 20, 29));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnVoltar.setBackground(new Color(184, 44, 54));
			}
		});
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Lucida Console", Font.BOLD, 11));
		btnVoltar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(161, 39, 49), new Color(219, 53, 67)));
		btnVoltar.setBackground(new Color(184, 44, 54));
		btnVoltar.setBounds(110, 418, 90, 40);
		panelCadastro.add(btnVoltar);
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.instagram.com/deopraglabs");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\logo-3-pressed.png"));

			}
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\logo-3.png"));
			}
		});
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setBackground(Color.CYAN);
		lblFundo.setIcon(new ImageIcon("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\background-cadastro.jpg"));
		lblFundo.setBounds(0, 0, 634, 491);
		frmCadastroDizimaster.getContentPane().add(lblFundo);
	}
}
