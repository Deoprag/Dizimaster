package com.dizimaster.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

import com.dizimaster.util.DatabaseUtils;
import com.dizimaster.util.GenericUtils;
import com.dizimaster.util.TxtUsuarioFormat;

public class LoginForm {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JTextField txtSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
					window.getFrmLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LoginForm() {
		initialize();
	}

	private void initialize() {
		setFrmLogin(new JFrame());
		getFrmLogin().setResizable(false);
		getFrmLogin().getContentPane().setMaximumSize(new Dimension(0, 0));
		getFrmLogin().getContentPane().setBackground(new Color(48, 133, 199));
		getFrmLogin().getContentPane().setLayout(null);

		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelLogin.setBackground(new Color(30, 144, 255));
		panelLogin.setBounds(0, -9, 230, 424);
		getFrmLogin().getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		txtUsuario = new TxtUsuarioFormat(11);
		txtUsuario.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtUsuario.setBackground(new Color(254, 213, 150));
		txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtUsuario.setToolTipText("Usuário");
		txtUsuario.setBounds(20, 220, 150, 30);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtSenha.setBackground(new Color(254, 213, 150));
		txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtSenha.setToolTipText("Senha");
		txtSenha.setColumns(10);
		txtSenha.setBounds(20, 270, 150, 30);
		panelLogin.add(txtSenha);

		JButton btnAjuda = new JButton("");
		btnAjuda.setFocusTraversalKeysEnabled(false);
		btnAjuda.setFocusable(false);
		btnAjuda.setToolTipText("Utilize seu CPF sem pontuação no nome de usuário");
		btnAjuda.setSelectedIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/info-hold-icon.png")));
		btnAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAjuda.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/info-hold-icon.png")));
				btnAjuda.setBackground(new Color(255, 255, 255, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAjuda.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/info-icon.png")));
				btnAjuda.setBackground(new Color(255, 255, 255, 0));
			}
		});
		btnAjuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAjuda.setBorder(null);
		btnAjuda.setBackground(new Color(255, 255, 255, 0));
		btnAjuda.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/info-icon.png")));
		btnAjuda.setBounds(188, 226, 24, 24);
		panelLogin.add(btnAjuda);
		btnAjuda.setFont(new Font("Rubik", Font.PLAIN, 12));

		JLabel lblUsuario = new JLabel("Usuário:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuario.setBorder(null);
		lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblUsuario.setBounds(20, 200, 150, 24);
		panelLogin.add(lblUsuario);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblSenha.setBounds(20, 250, 150, 24);
		panelLogin.add(lblSenha);

		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DatabaseUtils.login(txtUsuario.getText(), txtSenha.getText()) == true) {
					getFrmLogin().dispose();
				}
				;
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
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnEntrar.setBounds(122, 345, 90, 40);
		panelLogin.add(btnEntrar);

		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
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
		btnSair.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(16, 345, 90, 40);
		panelLogin.add(btnSair);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(40, 25, 150, 150);
		panelLogin.add(lblLogo);
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenericUtils.openWebpage("https://www.instagram.com/deopraglabs");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/logo-hold-small.png")));
			}

			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/logo-small.png")));

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/Login Sidebar.png")));
		lblNewLabel.setBounds(0, 0, 230, 424);
		panelLogin.add(lblNewLabel);
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setBounds(678, 381, 86, 25);
		getFrmLogin().getContentPane().add(lblDeopragLabs);
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Segoe UI", Font.BOLD, 10));

		JLabel lblFundo = new JLabel("");
		lblFundo.setBounds(0, -11, 766, 426);
		getFrmLogin().getContentPane().add(lblFundo);
		lblFundo.setIcon(new ImageIcon(LoginForm.class.getResource("/com/dizimaster/img/Login background.png")));
		getFrmLogin().setBackground(Color.WHITE);
		getFrmLogin().setIconImage(
				Toolkit.getDefaultToolkit().getImage(LoginForm.class.getResource("/com/dizimaster/img/icon.png")));
		getFrmLogin().setTitle("LOGIN - Dizimaster");
		getFrmLogin().setBounds(100, 100, 780, 445);
		getFrmLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		txtSenha.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEntrar.doClick();
				}
			}
		});
	}

	public JFrame getFrmLogin() {
		return frmLogin;
	}

	public void setFrmLogin(JFrame frmLogin) {
		this.frmLogin = frmLogin;
	}
}
