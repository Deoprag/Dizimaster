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
import java.awt.Desktop;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.JLabel;
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
		
		JPanel panelMid = new JPanel();
		panelMid.setBackground(new Color(0, 129, 214));
		panelMid.setBounds(203, 0, 1061, 720);
		getFrmDizimasterSistema().getContentPane().add(panelMid);
		panelMid.setLayout(null);
		
		JPanel panelSide = new JPanel();
		panelSide.setBounds(-2, -2, 205, 705);
		frmDizimasterSistema.getContentPane().add(panelSide);
		panelSide.setForeground(Color.BLACK);
		panelSide.setBackground(new Color(153, 204, 204));
		panelSide.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		panelSide.setLayout(null);
		
		JButton btnNovoFuncionario = new JButton("Novo Funcionário");
		btnNovoFuncionario.setBounds(27, 210, 150, 35);
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
				btnNovoFuncionario.setBackground(new Color(98, 191, 252));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNovoFuncionario.setBackground(new Color(122, 202, 255));
			}
		});
		btnNovoFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoFuncionario.setForeground(new Color(0, 0, 128));
		btnNovoFuncionario.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 0, 205), new Color(0, 0, 128)));
		btnNovoFuncionario.setBackground(new Color(122, 202, 255));
		btnNovoFuncionario.setFont(new Font("Lucida Console", Font.BOLD, 12));
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(27, 25, 150, 150);
		panelSide.add(lblLogo);
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
		lblLogo.setIcon(new ImageIcon("C:\\Users\\pdroe\\OneDrive\\Área de Trabalho\\P Stuff\\Projects\\Dizimaster\\assets\\logo-3.png"));
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
