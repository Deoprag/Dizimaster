package com.dizimaster.app;

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

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Insets;

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
		getFrmDizimasterSistema().setTitle("DIZIMASTER");
		getFrmDizimasterSistema().setBounds(100, 100, 1055, 740);
		getFrmDizimasterSistema().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrmDizimasterSistema().getContentPane().setLayout(null);
		
		JPanel panelMid = new JPanel();
		panelMid.setBackground(Color.WHITE);
		panelMid.setBounds(0, 29, 1038, 683);
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
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Rubik", Font.BOLD, 10));
		lblDeopragLabs.setBounds(0, 0, 90, 25);
		largeDesktopPane.add(lblDeopragLabs);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 1020, 665);
		largeDesktopPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 1038, 30);
		frmDizimasterSistema.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuTop = new JMenuBar();
		menuTop.setBounds(10, 0, 1018, 30);
		panel.add(menuTop);
		menuTop.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuTop.setPreferredSize(new Dimension(0, 30));
		menuTop.setBorderPainted(false);
		menuTop.setBackground(new Color(245, 245, 245));
		
		JMenu mnFuncionario = new JMenu("Funcionário");
		mnFuncionario.setMargin(new Insets(2, 4, 2, 2));
		mnFuncionario.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(128, 128, 128)));
		mnFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnFuncionario.setHorizontalTextPosition(SwingConstants.CENTER);
		mnFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
		mnFuncionario.setPreferredSize(new Dimension(80, 30));
		mnFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		menuTop.add(mnFuncionario);
		
		JMenuItem mntmNovoFuncionario = new JMenuItem("Novo Funcionário");
		mntmNovoFuncionario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmNovoFuncionario.setPreferredSize(new Dimension(150, 30));
		mnFuncionario.add(mntmNovoFuncionario);
		mntmNovoFuncionario.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/signup-icon.png")));
		
		JMenuItem mntmGerenciarFuncionario = new JMenuItem("Gerenciar Dizimistas");
		mntmGerenciarFuncionario.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/mange-icon.png")));
		mntmGerenciarFuncionario.setPreferredSize(new Dimension(150, 30));
		mntmGerenciarFuncionario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mnFuncionario.add(mntmGerenciarFuncionario);
		mntmNovoFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JIntCadastro intCad = new JIntCadastro();
				largeDesktopPane.add(intCad);
				intCad.show();
			}
		});
		
		JMenu mnDizimista = new JMenu("Dizimista");
		mnDizimista.setMargin(new Insets(2, 4, 2, 2));
		mnDizimista.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(128, 128, 128)));
		mnDizimista.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnDizimista.setHorizontalTextPosition(SwingConstants.CENTER);
		mnDizimista.setHorizontalAlignment(SwingConstants.CENTER);
		mnDizimista.setPreferredSize(new Dimension(80, 30));
		mnDizimista.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnDizimista.setIcon(null);
		mnDizimista.setBorderPainted(true);
		mnDizimista.setBackground(Color.WHITE);
		mnDizimista.setIconTextGap(6);
		menuTop.add(mnDizimista);
		
		JMenuItem mntmNovoDizimista = new JMenuItem("Novo Dizimista");
		mntmNovoDizimista.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmNovoDizimista.setPreferredSize(new Dimension(150, 30));
		mntmNovoDizimista.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/signup-icon.png")));
		mnDizimista.add(mntmNovoDizimista);
		
		JMenuItem mntmGerenciarDizimista = new JMenuItem("Gerenciar Dizimistas");
		mntmGerenciarDizimista.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmGerenciarDizimista.setPreferredSize(new Dimension(150, 30));
		mntmGerenciarDizimista.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/mange-icon.png")));
		mnDizimista.add(mntmGerenciarDizimista);
		
		JMenu mnFinanceiro = new JMenu("Financeiro");
		mnFinanceiro.setMargin(new Insets(2, 4, 2, 2));
		mnFinanceiro.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(128, 128, 128)));
		mnFinanceiro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnFinanceiro.setHorizontalTextPosition(SwingConstants.CENTER);
		mnFinanceiro.setHorizontalAlignment(SwingConstants.CENTER);
		mnFinanceiro.setPreferredSize(new Dimension(80, 30));
		menuTop.add(mnFinanceiro);
		
		JMenuItem mntmPagamento = new JMenuItem("Registrar Pagamento");
		mntmPagamento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmPagamento.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/receipt-icon.png")));
		mntmPagamento.setPreferredSize(new Dimension(150, 30));
		mnFinanceiro.add(mntmPagamento);
		
		JMenuItem mntmDespesa = new JMenuItem("Registrar Despesa");
		mntmDespesa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmDespesa.setPreferredSize(new Dimension(150, 30));
		mntmDespesa.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/spent-icon.png")));
		mnFinanceiro.add(mntmDespesa);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Relatório de Recebimentos");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/report-icon.png")));
		mntmNewMenuItem_1.setPreferredSize(new Dimension(180, 30));
		mntmNewMenuItem_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mnFinanceiro.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Fluxo de Caixa");
		mntmNewMenuItem.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmNewMenuItem.setPreferredSize(new Dimension(150, 30));
		mntmNewMenuItem.setIcon(new ImageIcon(Sistema.class.getResource("/com/dizimaster/img/graphic-icon.png")));
		mnFinanceiro.add(mntmNewMenuItem);
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
