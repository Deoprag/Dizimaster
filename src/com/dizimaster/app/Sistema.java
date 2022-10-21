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
		getFrmDizimasterSistema().setIconImage(Toolkit.getDefaultToolkit().getImage(Sistema.class.getResource("/com/dizimaster/img/icon.png")));
		getFrmDizimasterSistema().setTitle("DIZIMASTER - Sistema");
		getFrmDizimasterSistema().setBounds(100, 100, 1280, 740);
		getFrmDizimasterSistema().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmDizimasterSistema().getContentPane().setLayout(null);
		
		JPanel panelSide = new JPanel();
		panelSide.setBounds(-2, -2, 230, 705);
		frmDizimasterSistema.getContentPane().add(panelSide);
		panelSide.setForeground(Color.BLACK);
		panelSide.setBackground(new Color(153, 204, 204));
		panelSide.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		panelSide.setLayout(null);
		
		JButton btnSair = new JButton("SAIR");
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
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Sair?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});
		
		JPanel internalPanelSide = new JPanel();
		internalPanelSide.setBounds(16, 200, 204, 419);
		internalPanelSide.setBackground(new Color(65, 105, 225));
		panelSide.add(internalPanelSide);
		internalPanelSide.setLayout(null);
		
		JButton btnNovoFuncionario = new JButton("Novo Funcionário");
		btnNovoFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNovoFuncionario.setBounds(10, 10, 180, 35);
		internalPanelSide.add(btnNovoFuncionario);
		btnNovoFuncionario.setFocusPainted(false);
		btnNovoFuncionario.setRequestFocusEnabled(false);
		btnNovoFuncionario.setForeground(Color.WHITE);
		btnNovoFuncionario.setToolTipText("Novo Funcionário");
		btnNovoFuncionario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNovoFuncionario.setBackground(new Color(27, 70, 196));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNovoFuncionario.setBackground(new Color(42, 89, 229));
			}
		});
		btnNovoFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoFuncionario.setBorder(null);
		btnNovoFuncionario.setBackground(new Color(42, 89, 229));
		btnNovoFuncionario.setFont(new Font("Rubik", Font.PLAIN, 14));
		
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Rubik", Font.BOLD, 11));
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(122, 629, 90, 40);
		panelSide.add(btnSair);
		
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
				lblLogo.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/logo-hold-small.png")));

			}
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/logo-small.png")));
 		
		JButton btnDeslogar = new JButton("DESLOGAR");
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deslogar?", "Deslogar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					try {
						TelaLogin window = new TelaLogin();
						window.getFrmLogin().setVisible(true);
						getFrmDizimasterSistema().dispose();
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
		btnDeslogar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeslogar.setForeground(Color.WHITE);
		btnDeslogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeslogar.setBackground(new Color(212, 82, 2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnDeslogar.setBackground(new Color(237, 90, 0));
			}
		});
		btnDeslogar.setFont(new Font("Rubik", Font.BOLD, 11));
		btnDeslogar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnDeslogar.setBackground(new Color(237, 90, 0));
		btnDeslogar.setBounds(16, 629, 90, 40);
		panelSide.add(btnDeslogar);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBounds(0, 0, 230, 703);
		panelSide.add(lblBackground);
		lblBackground.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/Long_Sidebar.png")));
		
		JPanel panelMid = new JPanel();
		panelMid.setBackground(Color.WHITE);
		panelMid.setBounds(228, 0, 1038, 683);
		getFrmDizimasterSistema().getContentPane().add(panelMid);
		panelMid.setLayout(null);
		
		JDesktopPane largeDesktopPane = new JDesktopPane();
		largeDesktopPane.setBackground(Color.BLUE);
		largeDesktopPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		largeDesktopPane.setDragMode(2);
		largeDesktopPane.setBounds(10, 10, 1018, 663);
		panelMid.add(largeDesktopPane);
		largeDesktopPane.setLayout(null);
		JIntCadastro intCad = new JIntCadastro();
		intCad.setFrameIcon(null);
		intCad.setClosable(false);
		intCad.setBounds(1, 1, 1016, 661);
		intCad.setBorder(null);
		largeDesktopPane.add(intCad);
		intCad.show();
		
		JMenuBar menuTop = new JMenuBar();
		menuTop.setAlignmentX(Component.LEFT_ALIGNMENT);
		menuTop.setBackground(Color.WHITE);
		frmDizimasterSistema.setJMenuBar(menuTop);
		
		JMenu mnDizimista = new JMenu("Dizimista");
		mnDizimista.setIcon(null);
		mnDizimista.setBorder(new LineBorder(Color.BLUE, 2));
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
