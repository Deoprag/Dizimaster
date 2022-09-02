package com.dizimaster.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;

import com.dizimaster.conexao.ConexaoDB;
import com.dizimaster.sistema.Sistema;

import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class TelaLogin {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin window = new TelaLogin();
					window.frmLogin.setVisible(true);
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
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.getContentPane().setMaximumSize(new Dimension(0, 0));
		frmLogin.getContentPane().setBackground(new Color(48, 133, 199));
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelLogin.setBackground(new Color(135, 206, 235));
		panelLogin.setBounds(454, 11, 170, 469);
		frmLogin.getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(0, 191, 255)));
		txtUsuario.setBackground(new Color(224, 255, 255));
		txtUsuario.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtUsuario.setToolTipText("Usuário");
		txtUsuario.setBounds(10, 197, 150, 30);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setForeground(new Color(0, 0, 128));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuario.setBorder(null);
		lblUsuario.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblUsuario.setBounds(10, 179, 150, 24);
		panelLogin.add(lblUsuario);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(new Color(0, 0, 128));
		lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSenha.setFont(new Font("Lucida Console", Font.BOLD, 12));
		lblSenha.setBounds(10, 238, 150, 24);
		panelLogin.add(lblSenha);
		
		txtSenha = new JPasswordField();
		txtSenha.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(0, 191, 255)));
		txtSenha.setBackground(new Color(224, 255, 255));
		txtSenha.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtSenha.setToolTipText("Senha");
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 258, 150, 30);
		panelLogin.add(txtSenha);
		
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					Connection con = ConexaoDB.conecta();
					String sql = "select *from cadastros where usuario = ? and senha = ?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, txtUsuario.getText());
					stmt.setString(2, txtSenha.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					if(rs.next()) {
						Sistema window = new Sistema();
						window.getFrmDizimasterSistema().setVisible(true);
						frmLogin.dispose();
					} else {
						txtUsuario.setText(null);
						txtSenha.setText(null);
						JOptionPane.showMessageDialog(null, "Usuário e/ou senha incorretos!");
					}
					
					stmt.close();
					con.close();
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
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
		btnEntrar.setForeground(SystemColor.text);
		btnEntrar.setBackground(new Color(60, 122, 194));
		btnEntrar.setFont(new Font("Lucida Console", Font.BOLD, 11));
		btnEntrar.setBounds(40, 345, 90, 40);
		panelLogin.add(btnEntrar);
		
		JLabel lblEsqueciSenha = new JLabel("Esqueci minha senha.");
		lblEsqueciSenha.setForeground(new Color(69, 69, 69));
		lblEsqueciSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblEsqueciSenha.setForeground(new Color(0, 120, 215));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblEsqueciSenha.setForeground(new Color(69, 69, 69));
			}
		});
		lblEsqueciSenha.setFont(new Font("Lucida Console", Font.PLAIN, 10));
		lblEsqueciSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblEsqueciSenha.setBounds(10, 299, 150, 14);
		panelLogin.add(lblEsqueciSenha);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.instagram.com/deopraglabs");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P STUFF\\Projects\\Dizimaster\\assets\\logo-3-pressed.png"));

			}
				public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-3.png"));
			}
		});
		lblLogo.setBounds(10, 11, 150, 150);
		panelLogin.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-3.png"));
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
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
		btnSair.setFont(new Font("Lucida Console", Font.BOLD, 11));
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(40, 405, 90, 40);
		panelLogin.add(btnSair);
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setBounds(10, 466, 66, 25);
		frmLogin.getContentPane().add(lblDeopragLabs);
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Arial", Font.BOLD, 8));
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setBounds(0, 0, 634, 491);
		frmLogin.getContentPane().add(lblFundo);
		lblFundo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\background-login.jpg"));
		frmLogin.setBackground(Color.WHITE);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-2.png"));
		frmLogin.setTitle("LOGIN - Dizimaster");
		frmLogin.setBounds(100, 100, 650, 530);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txtSenha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
	               if (e.getKeyCode() == KeyEvent.VK_ENTER){
		                btnEntrar.doClick();
	               }
			}
		});
	}
}
