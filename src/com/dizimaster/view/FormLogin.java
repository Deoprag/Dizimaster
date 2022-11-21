package com.dizimaster.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import org.jdesktop.swingx.JXButton;

import com.dizimaster.controller.DatabaseUtils;
import com.dizimaster.swing.TxtUsuarioFormat;
import com.dizimaster.util.Util;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import java.awt.event.MouseMotionAdapter;

public class FormLogin {

	private JFrame frmLogin;
	private JTextField txtUsuario;
	private JTextField txtSenha;
	private JLabel lblData;
	private JLabel lblHora;
	private int yMouse, xMouse;
	private Util util = new Util();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin window = new FormLogin();
					window.getFrmLogin().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormLogin() {
		initialize();
		data();
		hora();
	}
	
	private void data() {
		SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		getLblData().setText(s.format(d));
	}

	private void hora() {
		new Timer(0, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				getLblHora().setText(util.horaAtual());
			}
		}).start();
	}

	private void mexe(int x, int y) {
		getFrmLogin().setLocation(x - xMouse, y - yMouse);
	}

	private void initialize() {
		setFrmLogin(new JFrame());
		getFrmLogin().setResizable(false);
		getFrmLogin().getContentPane().setMaximumSize(new Dimension(0, 0));
		getFrmLogin().getContentPane().setBackground(new Color(8, 82, 180));
		getFrmLogin().getContentPane().setLayout(null);
		getFrmLogin().setLocationRelativeTo(null);
		
		JPanel panelTop = new JPanel();
		panelTop.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				mexe(x, y);
			}
		});
		panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				yMouse = e.getY();
				xMouse = e.getX();
			}
		});
		panelTop.setLayout(null);
		panelTop.setBorder(null);
		panelTop.setBackground(new Color(62, 62, 62));
		panelTop.setBounds(0, 0, 770, 39);
		frmLogin.getContentPane().add(panelTop);
		
		JXButton btnMinimize = new JXButton();
		btnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMinimize.setBackground(new Color(110, 110, 110));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnMinimize.setBackground(new Color(128, 128, 128));
			}
		});
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrmLogin().setState(Frame.ICONIFIED);
			}
		});
		btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinimize.setText("_");
		btnMinimize.setForeground(Color.WHITE);
		btnMinimize.setFont(new Font("Noto Sans", Font.BOLD, 15));
		btnMinimize.setFocusable(false);
		btnMinimize.setFocusPainted(false);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnMinimize.setBackground(Color.GRAY);
		btnMinimize.setBounds(680, 4, 35, 30);
		panelTop.add(btnMinimize);
		
		JXButton btnFechar = new JXButton();
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFechar.setBackground(new Color(175, 0, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnFechar.setBackground(new Color(215, 0, 0));
			}
		});
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFechar.setText("X");
		btnFechar.setForeground(Color.WHITE);
		btnFechar.setFont(new Font("Noto Sans", Font.BOLD, 16));
		btnFechar.setFocusable(false);
		btnFechar.setFocusPainted(false);
		btnFechar.setBorderPainted(false);
		btnFechar.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnFechar.setBackground(new Color(215, 0, 0));
		btnFechar.setBounds(715, 4, 50, 30);
		panelTop.add(btnFechar);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/icon.png")));
		lblIcon.setBounds(291, 7, 24, 24);
		panelTop.add(lblIcon);
		
		JLabel lblTitle = new JLabel("Dizimaster - Login");
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitle.setBounds(320, 4, 130, 30);
		panelTop.add(lblTitle);
		
		lblData = new JLabel();
		lblData.setText("");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblData.setBounds(5, 2, 65, 25);
		panelTop.add(lblData);
		
		lblHora = new JLabel();
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblHora.setBounds(5, 15, 65, 25);
		panelTop.add(lblHora);

		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelLogin.setBackground(new Color(8, 82, 180));
		panelLogin.setBounds(0, 46, 230, 424);
		getFrmLogin().getContentPane().add(panelLogin);
		panelLogin.setLayout(null);
		
		txtUsuario = new TxtUsuarioFormat(11);
		txtUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtUsuario.setText("");
				txtUsuario.setForeground(Color.WHITE);
			}
		});
		txtUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtUsuario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 128, 192)));
		txtUsuario.setForeground(new Color(192, 192, 192));
		txtUsuario.setText("Insira seu usuário");
		txtUsuario.setBackground(new Color(8, 82, 180));
		txtUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtUsuario.setToolTipText("Usuário");
		txtUsuario.setBounds(20, 220, 150, 30);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);

		txtSenha = new JPasswordField();
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtSenha.setText("");
				txtSenha.setForeground(Color.WHITE);
			}
		});
		txtSenha.setText("123456781234");
		txtSenha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 128, 192)));
		txtSenha.setForeground(new Color(192, 192, 192));
		txtSenha.setBackground(new Color(8,82,180));
		txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtSenha.setToolTipText("Senha");
		txtSenha.setBounds(20, 290, 150, 30);
		panelLogin.add(txtSenha);

		JButton btnAjuda = new JButton("");
		btnAjuda.setFocusTraversalKeysEnabled(false);
		btnAjuda.setFocusable(false);
		btnAjuda.setToolTipText("Utilize seu CPF sem pontuação no nome de usuário");
		btnAjuda.setSelectedIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/info-hold-icon.png")));
		btnAjuda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAjuda.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/info-hold-icon.png")));
				btnAjuda.setBackground(new Color(255, 255, 255, 0));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnAjuda.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/info-icon.png")));
				btnAjuda.setBackground(new Color(255, 255, 255, 0));
			}
		});
		btnAjuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAjuda.setBorder(null);
		btnAjuda.setBackground(new Color(255, 255, 255, 0));
		btnAjuda.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/info-icon.png")));
		btnAjuda.setBounds(188, 220, 24, 24);
		panelLogin.add(btnAjuda);
		btnAjuda.setFont(new Font("Rubik", Font.PLAIN, 12));

		JLabel lblUsuario = new JLabel("USUÁRIO");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblUsuario.setBorder(null);
		lblUsuario.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblUsuario.setBounds(20, 200, 150, 24);
		panelLogin.add(lblUsuario);

		JLabel lblSenha = new JLabel("SENHA");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblSenha.setFont(new Font("Segoe UI", Font.BOLD, 13));
		lblSenha.setBounds(20, 270, 150, 24);
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
		btnEntrar.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		btnEntrar.setBounds(70, 345, 90, 40);
		panelLogin.add(btnEntrar);

		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(40, 28, 150, 150);
		panelLogin.add(lblLogo);
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Util.openWebpage("https://www.instagram.com/deopraglabs");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/logo-hold-small.png")));
			}

			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/logo-small.png")));
		
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBorder(null);
				lblNewLabel.setBounds(0, 0, 230, 424);
				panelLogin.add(lblNewLabel);
				lblNewLabel.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/Login Sidebar.png")));
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setBounds(684, 424, 86, 25);
		getFrmLogin().getContentPane().add(lblDeopragLabs);
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Segoe UI", Font.BOLD, 10));

		JLabel lblFundo = new JLabel("");
		lblFundo.setBounds(2, 35, 770, 426);
		getFrmLogin().getContentPane().add(lblFundo);
		lblFundo.setIcon(new ImageIcon(FormLogin.class.getResource("/com/dizimaster/img/Login background.png")));
		getFrmLogin().setBackground(Color.WHITE);
		getFrmLogin().setIconImage(
				Toolkit.getDefaultToolkit().getImage(FormLogin.class.getResource("/com/dizimaster/img/icon2.png")));
		getFrmLogin().setBounds(100, 100, 770, 460);
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
		frmLogin.setUndecorated(true);
	}

	public JLabel getLblData() {
		return lblData;
	}

	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}

	public JLabel getLblHora() {
		return lblHora;
	}

	public void setLblHora(JLabel lblHora) {
		this.lblHora = lblHora;
	}
}
