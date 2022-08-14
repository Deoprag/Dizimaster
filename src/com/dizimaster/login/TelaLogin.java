package com.dizimaster.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Dimension;

public class TelaLogin {

	private JFrame frmLoginDizimaster;
	private JTextField txtUsurio;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmLoginDizimaster.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaLogin() {
		initialize();
	}
	
	public static void openWebpage(String urlString) {
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
		frmLoginDizimaster = new JFrame();
		frmLoginDizimaster.setResizable(false);
		frmLoginDizimaster.getContentPane().setMaximumSize(new Dimension(0, 0));
		frmLoginDizimaster.getContentPane().setBackground(new Color(48, 133, 199));
		frmLoginDizimaster.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.textHighlight, new Color(0, 191, 255)));
		panel.setBackground(new Color(135, 206, 235));
		panel.setBounds(454, 11, 170, 469);
		frmLoginDizimaster.getContentPane().add(panel);
		panel.setLayout(null);
		
		txtUsurio = new JTextField();
		txtUsurio.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtUsurio.setToolTipText("Usuário");
		txtUsurio.setBounds(10, 203, 150, 30);
		panel.add(txtUsurio);
		txtUsurio.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblUsuario.setBounds(10, 178, 66, 24);
		panel.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		lblSenha.setBounds(10, 244, 66, 24);
		panel.add(lblSenha);
		
		txtSenha = new JTextField();
		txtSenha.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtSenha.setToolTipText("Senha");
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 269, 150, 30);
		panel.add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEntrar.setBackground(new Color(33, 91, 158));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEntrar.setBackground(new Color(60, 122, 194));
			}
		});
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setBorder(new LineBorder(new Color(0, 0, 0)));
		btnEntrar.setForeground(SystemColor.text);
		btnEntrar.setBackground((new Color(60, 122, 194)));
		btnEntrar.setFont(new Font("Lucida Console", Font.PLAIN, 14));
		btnEntrar.setBounds(40, 342, 90, 40);
		panel.add(btnEntrar);
		
		JLabel lblEsqueciSenha = new JLabel("Esqueci minha senha.");
		lblEsqueciSenha.setForeground(new Color(0, 0, 0));
		lblEsqueciSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEsqueciSenha.setForeground(new Color(3, 57, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEsqueciSenha.setForeground(new Color(0,0,0));
			}
		});
		lblEsqueciSenha.setFont(new Font("Lucida Console", Font.PLAIN, 10));
		lblEsqueciSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEsqueciSenha.setBounds(10, 303, 150, 14);
		panel.add(lblEsqueciSenha);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.instagram.com/deopraglabs");
			}
		});
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\logo-3.png"));
		lblLogo.setBounds(10, 11, 150, 150);
		panel.add(lblLogo);
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setBounds(10, 466, 66, 25);
		frmLoginDizimaster.getContentPane().add(lblDeopragLabs);
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Arial", Font.BOLD, 8));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 634, 491);
		frmLoginDizimaster.getContentPane().add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\background.jpg"));
		frmLoginDizimaster.setBackground(Color.WHITE);
		frmLoginDizimaster.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pdroe\\Área de Trabalho\\P STUFF\\JavaProjects\\Dizimaster\\assets\\logo-2.png"));
		frmLoginDizimaster.setTitle("Dizimaster - Login");
		frmLoginDizimaster.setBounds(100, 100, 650, 530);
		frmLoginDizimaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
