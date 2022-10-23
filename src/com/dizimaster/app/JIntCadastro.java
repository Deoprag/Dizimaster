package com.dizimaster.app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class JIntCadastro extends JInternalFrame {
	private JTextField txtUsuario;
	private JTextField txtEmail;
	private JTextField txtConfEmail;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIntCadastro frame = new JIntCadastro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	public JIntCadastro() {
		setBorder(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(335, 34, 350, 570);
		getContentPane().add(panelCadastro);
		
		JLabel lblTitulo = new JLabel("Cadastro de Funcionários");
		lblTitulo.setBorder(new LineBorder(new Color(0, 128, 255), 3));
		lblTitulo.setBackground(new Color(128, 128, 128));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Rubik", Font.BOLD, 16));
		lblTitulo.setBounds(56, 220, 240, 35);
		panelCadastro.add(lblTitulo);
		
		JLabel lblUsuario = new JLabel("Nome de Usuário");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblUsuario.setBorder(null);
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setAlignmentX(0.5f);
		lblUsuario.setBounds(16, 330, 150, 24);
		panelCadastro.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setToolTipText("Nome de Usuário");
		txtUsuario.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtUsuario.setColumns(10);
		txtUsuario.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtUsuario.setBackground(new Color(254, 213, 150));
		txtUsuario.setBounds(16, 350, 150, 30);
		panelCadastro.add(txtUsuario);
		
		JLabel lblEmail = new JLabel("Endereço de Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(16, 390, 150, 24);
		panelCadastro.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Endereço de Email");
		txtEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtEmail.setBackground(new Color(254, 213, 150));
		txtEmail.setBounds(16, 410, 150, 30);
		panelCadastro.add(txtEmail);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.instagram.com/deopraglabs");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/logo-hold-small.png")));

			}
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/logo-small.png")));
		lblLogo.setBounds(100, 20, 150, 150);
		panelCadastro.add(lblLogo);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Rubik", Font.BOLD, 15));
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(60, 122, 194));
		btnEnviar.setBounds(100, 485, 150, 55);
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
		
		JLabel lblConfEmail = new JLabel("Confirmação de Email");
		lblConfEmail.setForeground(Color.WHITE);
		lblConfEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblConfEmail.setAlignmentX(0.5f);
		lblConfEmail.setBounds(182, 390, 150, 24);
		panelCadastro.add(lblConfEmail);
		
		txtConfEmail = new JTextField();
		txtConfEmail.setToolTipText("Confirmação de Email");
		txtConfEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtConfEmail.setColumns(10);
		txtConfEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtConfEmail.setBackground(new Color(254, 213, 150));
		txtConfEmail.setBounds(182, 410, 150, 30);
		panelCadastro.add(txtConfEmail);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCpf.setBorder(null);
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setAlignmentX(0.5f);
		lblCpf.setBounds(16, 270, 150, 24);
		panelCadastro.add(lblCpf);
		
		txtCpf = new JTextField();
		txtCpf.setToolTipText("CPF");
		txtCpf.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtCpf.setColumns(10);
		txtCpf.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtCpf.setBackground(new Color(254, 213, 150));
		txtCpf.setBounds(16, 290, 150, 30);
		panelCadastro.add(txtCpf);
		
		JLabel lblNomeFunc = new JLabel("Nome");
		lblNomeFunc.setForeground(Color.WHITE);
		lblNomeFunc.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNomeFunc.setBorder(null);
		lblNomeFunc.setBackground(Color.WHITE);
		lblNomeFunc.setAlignmentX(0.5f);
		lblNomeFunc.setBounds(182, 270, 150, 24);
		panelCadastro.add(lblNomeFunc);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Nome");
		txtNome.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtNome.setBackground(new Color(254, 213, 150));
		txtNome.setBounds(182, 290, 150, 30);
		panelCadastro.add(txtNome);
		
		JLabel lblCelular = new JLabel("Número de Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCelular.setBorder(null);
		lblCelular.setBackground(Color.WHITE);
		lblCelular.setAlignmentX(0.5f);
		lblCelular.setBounds(182, 330, 150, 24);
		panelCadastro.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setToolTipText("Número de Celular");
		txtCelular.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtCelular.setColumns(10);
		txtCelular.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtCelular.setBackground(new Color(254, 213, 150));
		txtCelular.setBounds(182, 350, 150, 30);
		panelCadastro.add(txtCelular);
		
		JLabel lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setBorder(new LineBorder(new Color(0, 128, 255), 2));
		lblBackgroundPanel.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBounds(0, 0, 350, 570);
		panelCadastro.add(lblBackgroundPanel);
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Rubik", Font.BOLD, 10));
		lblDeopragLabs.setBounds(0, 0, 90, 25);
		getContentPane().add(lblDeopragLabs);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);

	}
}
