package com.dizimaster.app;

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
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Insets;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JInternalFrame;
import java.awt.Dimension;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;

public class Sistema {

	private JFrame frmDizimasterSistema;

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
		getFrmDizimasterSistema().setIconImage(Toolkit.getDefaultToolkit().getImage(Sistema.class.getResource("/com/dizimaster/img/icon.png")));
		getFrmDizimasterSistema().setTitle("DIZIMASTER - Sistema");
		getFrmDizimasterSistema().setBounds(100, 100, 1050, 740);
		getFrmDizimasterSistema().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmDizimasterSistema().getContentPane().setLayout(null);
		
		JPanel panelMid = new JPanel();
		panelMid.setBackground(Color.WHITE);
		panelMid.setBounds(0, 0, 1038, 683);
		getFrmDizimasterSistema().getContentPane().add(panelMid);
		panelMid.setLayout(null);
		
		JDesktopPane largeDesktopPane = new JDesktopPane();
		largeDesktopPane.setAlignmentY(0.0f);
		largeDesktopPane.setAlignmentX(0.0f);
		largeDesktopPane.setBackground(SystemColor.textHighlight);
		largeDesktopPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		largeDesktopPane.setBounds(10, 10, 1020, 665);
		panelMid.add(largeDesktopPane);
		largeDesktopPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 1020, 665);
		largeDesktopPane.add(lblNewLabel);
		
		JMenuBar menuTop = new JMenuBar();
		menuTop.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuTop.setBackground(Color.WHITE);
		frmDizimasterSistema.setJMenuBar(menuTop);
		
		JMenu mnDizimista = new JMenu("Dizimista");
		mnDizimista.setIcon(null);
		mnDizimista.setBorderPainted(true);
		mnDizimista.setBackground(Color.WHITE);
		mnDizimista.setIconTextGap(6);
		menuTop.add(mnDizimista);
		
		JMenuItem mntmNovoDizimista = new JMenuItem("Novo Dizimista");
		mntmNovoDizimista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JIntCadastro intCad = new JIntCadastro();
				largeDesktopPane.add(intCad);
				intCad.show();
			}
		});
		mnDizimista.add(mntmNovoDizimista);
		
		JMenuItem mntmGerenciarDizimistas = new JMenuItem("Gerenciar Dizimistas");
		mnDizimista.add(mntmGerenciarDizimistas);
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
