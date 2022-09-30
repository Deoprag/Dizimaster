package com.dizimaster.screen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class TelaCadastro {

	private JFrame frmCadastro;
	private JTextField txtEmail;
	private JTextField txtConfEmail;
	private JTextField txtCpf1;
	private JTextField txtNomeFunc;
	private JTextField txtCelular;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro window = new TelaCadastro();
					window.getFrmCadastro().setVisible(true);
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
	/*
	private Image getImage(String filename) {
	    try {
	        return ImageIO.read(getClass().getResourceAsStream(
	                "/" + "background-login.jpg"));
	    } catch (IOException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
	*/

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrmCadastro(new JFrame());
		getFrmCadastro().setTitle("CADASTRO DE FUNCIONARIO - Dizimaster");
		getFrmCadastro().setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo.png"));
		getFrmCadastro().setResizable(false);
		getFrmCadastro().setBounds(100, 100, 650, 650);
		getFrmCadastro().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmCadastro().getContentPane().setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(143, 21, 350, 570);
		getFrmCadastro().getContentPane().add(panelCadastro);
		
		JLabel lblEmail = new JLabel("Endereço de Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Lucida Console", Font.BOLD, 11));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(16, 340, 150, 24);
		panelCadastro.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Email");
		txtEmail.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtEmail.setBackground(new Color(254, 213, 150));
		txtEmail.setBounds(16, 360, 150, 30);
		panelCadastro.add(txtEmail);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(100, 20, 150, 150);
		panelCadastro.add(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-small.png"));
		
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Lucida Console", Font.BOLD, 11));
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(60, 122, 194));
		btnEnviar.setBounds(202, 500, 90, 40);
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
					frmCadastro.dispose();
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
		btnVoltar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnVoltar.setBackground(new Color(184, 44, 54));
		btnVoltar.setBounds(56, 500, 90, 40);
		panelCadastro.add(btnVoltar);
		
		JLabel lblConfEmail = new JLabel("Confirmação de Email");
		lblConfEmail.setForeground(Color.WHITE);
		lblConfEmail.setFont(new Font("Lucida Console", Font.BOLD, 11));
		lblConfEmail.setAlignmentX(0.5f);
		lblConfEmail.setBounds(182, 340, 150, 24);
		panelCadastro.add(lblConfEmail);
		
		txtConfEmail = new JTextField();
		txtConfEmail.setToolTipText("Email");
		txtConfEmail.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtConfEmail.setColumns(10);
		txtConfEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtConfEmail.setBackground(new Color(254, 213, 150));
		txtConfEmail.setBounds(182, 360, 150, 30);
		panelCadastro.add(txtConfEmail);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Lucida Console", Font.BOLD, 11));
		lblCpf.setBorder(null);
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setAlignmentX(0.5f);
		lblCpf.setBounds(16, 190, 150, 24);
		panelCadastro.add(lblCpf);
		
		txtCpf1 = new JTextField();
		txtCpf1.setToolTipText("Usuário");
		txtCpf1.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtCpf1.setColumns(10);
		txtCpf1.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtCpf1.setBackground(new Color(254, 213, 150));
		txtCpf1.setBounds(16, 210, 150, 30);
		panelCadastro.add(txtCpf1);
		
		JLabel lblNomeFunc = new JLabel("Nome");
		lblNomeFunc.setForeground(Color.WHITE);
		lblNomeFunc.setFont(new Font("Lucida Console", Font.BOLD, 11));
		lblNomeFunc.setBorder(null);
		lblNomeFunc.setBackground(Color.WHITE);
		lblNomeFunc.setAlignmentX(0.5f);
		lblNomeFunc.setBounds(182, 190, 150, 24);
		panelCadastro.add(lblNomeFunc);
		
		txtNomeFunc = new JTextField();
		txtNomeFunc.setToolTipText("Usuário");
		txtNomeFunc.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtNomeFunc.setColumns(10);
		txtNomeFunc.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtNomeFunc.setBackground(new Color(254, 213, 150));
		txtNomeFunc.setBounds(182, 210, 150, 30);
		panelCadastro.add(txtNomeFunc);
		
		JLabel lblCelular = new JLabel("Número de Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Lucida Console", Font.BOLD, 11));
		lblCelular.setBorder(null);
		lblCelular.setBackground(Color.WHITE);
		lblCelular.setAlignmentX(0.5f);
		lblCelular.setBounds(16, 240, 150, 24);
		panelCadastro.add(lblCelular);
		
		txtCelular = new JTextField();
		txtCelular.setToolTipText("Usuário");
		txtCelular.setFont(new Font("Lucida Console", Font.PLAIN, 12));
		txtCelular.setColumns(10);
		txtCelular.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtCelular.setBackground(new Color(254, 213, 150));
		txtCelular.setBounds(16, 260, 150, 30);
		panelCadastro.add(txtCelular);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\Cadastro\\Cad_Panel.jpg"));
		lblNewLabel.setBounds(0, 0, 350, 570);
		panelCadastro.add(lblNewLabel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(-36, 0, 636, 610);
		panelCadastro.add(lblBackground);
		lblBackground.setBackground(new Color(102, 204, 204));
		lblBackground.setIcon(null);
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.instagram.com/deopraglabs");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-hold-small.png"));

			}
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-small.png"));
			}
		});
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Arial", Font.BOLD, 8));
		lblDeopragLabs.setBounds(10, 585, 66, 25);
		getFrmCadastro().getContentPane().add(lblDeopragLabs);
	}

	/**
	 * @return the frmCadastro
	 */
	public JFrame getFrmCadastro() {
		return frmCadastro;
	}

	/**
	 * @param frmCadastro the frmCadastro to set
	 */
	public void setFrmCadastro(JFrame frmCadastro) {
		this.frmCadastro = frmCadastro;
	}
}
