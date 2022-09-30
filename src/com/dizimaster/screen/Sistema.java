package com.dizimaster.screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.border.EtchedBorder;

import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;

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
	
	private static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
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
		getFrmDizimasterSistema().setTitle("DIZIMASTER - Sistema");
		getFrmDizimasterSistema().setBounds(100, 100, 1280, 720);
		getFrmDizimasterSistema().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmDizimasterSistema().getContentPane().setLayout(null);
		
		JPanel panelSide = new JPanel();
		panelSide.setBounds(-2, -2, 230, 705);
		frmDizimasterSistema.getContentPane().add(panelSide);
		panelSide.setForeground(Color.BLACK);
		panelSide.setBackground(new Color(153, 204, 204));
		panelSide.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		panelSide.setLayout(null);
		
		JButton btnNovoFuncionario = new JButton("Novo Funcionário");
		btnNovoFuncionario.setBounds(40, 210, 150, 35);
		panelSide.add(btnNovoFuncionario);
		btnNovoFuncionario.setToolTipText("Novo Funcionário");
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
				btnNovoFuncionario.setBackground(new Color(240, 173, 72));
				btnNovoFuncionario.setForeground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNovoFuncionario.setBackground(new Color(254, 213, 150));
				btnNovoFuncionario.setForeground(Color.DARK_GRAY);
			}
		});
		btnNovoFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoFuncionario.setForeground(Color.DARK_GRAY);
		btnNovoFuncionario.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		btnNovoFuncionario.setBackground(new Color(254, 213, 150));
		btnNovoFuncionario.setFont(new Font("Lucida Console", Font.BOLD, 12));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(40, 25, 150, 150);
		panelSide.add(lblLogo);
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-small.png"));
 		
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
		btnSair.setBounds(70, 629, 90, 40);
		panelSide.add(btnSair);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 230, 703);
		panelSide.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\Sistema\\Long_Sidebar.png"));
		
		JPanel panelMid = new JPanel();
		panelMid.setBackground(new Color(0, 129, 214));
		panelMid.setBounds(228, 0, 1053, 683);
		getFrmDizimasterSistema().getContentPane().add(panelMid);
		panelMid.setLayout(null);
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
		frmDizimasterSistema.setResizable(false);
	}
}
