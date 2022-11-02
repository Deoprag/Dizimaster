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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.Insets;
import javax.swing.JButton;

public class SistemaForm {

	private JFrame frmDizimasterSistema;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaForm window = new SistemaForm();
					window.getFrmDizimasterSistema().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public SistemaForm() {
		initialize();
	}
	
	public void deslogar() {
		this.frmDizimasterSistema.dispose();
		LoginForm window = new LoginForm();
		window.getFrmLogin().setVisible(true);
		getFrmDizimasterSistema().dispose();
	}

	private void initialize() {
		setFrmDizimasterSistema(new JFrame());
		getFrmDizimasterSistema().setIconImage(Toolkit.getDefaultToolkit().getImage(SistemaForm.class.getResource("/com/dizimaster/img/icon.png")));
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.BLACK));
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(70, 42, 880, 580);
		largeDesktopPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblMural = new JLabel("(MURAL)");
		lblMural.setForeground(Color.WHITE);
		lblMural.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		lblMural.setHorizontalAlignment(SwingConstants.CENTER);
		lblMural.setBounds(358, 252, 164, 76);
		panel_1.add(lblMural);
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblDeopragLabs.setBounds(0, 0, 90, 25);
		largeDesktopPane.add(lblDeopragLabs);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setHorizontalAlignment(SwingConstants.CENTER);
		lblBackground.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblBackground.setBounds(0, 0, 1020, 665);
		largeDesktopPane.add(lblBackground);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(0, 0, 1038, 30);
		frmDizimasterSistema.getContentPane().add(panel);
		panel.setLayout(null);
		
		JMenuBar menuTop = new JMenuBar();
		menuTop.setBounds(10, 0, 920, 30);
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
		mntmNovoFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNovoFuncionario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmNovoFuncionario.setPreferredSize(new Dimension(150, 30));
		mnFuncionario.add(mntmNovoFuncionario);
		mntmNovoFuncionario.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/signup-icon.png")));
		
		JMenuItem mntmGerenciarFuncionario = new JMenuItem("Gerenciar Funcionários");
		mntmGerenciarFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmGerenciarFuncionario.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/mange-icon.png")));
		mntmGerenciarFuncionario.setPreferredSize(new Dimension(170, 30));
		mntmGerenciarFuncionario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mnFuncionario.add(mntmGerenciarFuncionario);
		mntmNovoFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntFormCadastro intCad = new IntFormCadastro();
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
		mntmNovoDizimista.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNovoDizimista.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmNovoDizimista.setPreferredSize(new Dimension(150, 30));
		mntmNovoDizimista.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/signup-icon.png")));
		mnDizimista.add(mntmNovoDizimista);
		
		JMenuItem mntmGerenciarDizimista = new JMenuItem("Gerenciar Dizimistas");
		mntmGerenciarDizimista.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmGerenciarDizimista.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmGerenciarDizimista.setPreferredSize(new Dimension(150, 30));
		mntmGerenciarDizimista.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/mange-icon.png")));
		mnDizimista.add(mntmGerenciarDizimista);
		
		JMenu mnFinanceiro = new JMenu("Financeiro");
		mnFinanceiro.setMargin(new Insets(2, 4, 2, 2));
		mnFinanceiro.setBorder(new MatteBorder(0, 0, 0, 1, (Color) new Color(128, 128, 128)));
		mnFinanceiro.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		mnFinanceiro.setHorizontalTextPosition(SwingConstants.CENTER);
		mnFinanceiro.setHorizontalAlignment(SwingConstants.CENTER);
		mnFinanceiro.setPreferredSize(new Dimension(80, 30));
		menuTop.add(mnFinanceiro);
		
		JMenu mnRegistrarPagamento = new JMenu("Registrar Pagamento");
		mnRegistrarPagamento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mnRegistrarPagamento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mnRegistrarPagamento.setPreferredSize(new Dimension(150, 30));
		mnRegistrarPagamento.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/receipt-icon.png")));
		mnFinanceiro.add(mnRegistrarPagamento);
		
		JMenuItem mntmDizimo = new JMenuItem("Dizimo");
		mntmDizimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntFormDizimo intDizimo = new IntFormDizimo();
				largeDesktopPane.add(intDizimo);
				intDizimo.show();
			}
		});
		mnRegistrarPagamento.add(mntmDizimo);
		mntmDizimo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmDizimo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmDizimo.setPreferredSize(new Dimension(100, 30));
		
		JMenuItem mntmOferta = new JMenuItem("Oferta");
		mntmOferta.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/offering-icon.png")));
		mntmOferta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmOferta.setPreferredSize(new Dimension(100, 30));
		mnRegistrarPagamento.add(mntmOferta);
		
		JMenuItem mntmDespesa = new JMenuItem("Registrar Despesa");
		mntmDespesa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmDespesa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmDespesa.setPreferredSize(new Dimension(150, 30));
		mntmDespesa.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/spent-icon.png")));
		mnFinanceiro.add(mntmDespesa);
		
		JMenuItem mntmNewRelatorioRecebimentos = new JMenuItem("Relatório de Recebimentos");
		mntmNewRelatorioRecebimentos.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNewRelatorioRecebimentos.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/report-icon.png")));
		mntmNewRelatorioRecebimentos.setPreferredSize(new Dimension(180, 30));
		mntmNewRelatorioRecebimentos.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mnFinanceiro.add(mntmNewRelatorioRecebimentos);
		
		JMenuItem mntmFluxoCaixa = new JMenuItem("Fluxo de Caixa");
		mntmFluxoCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IntFormFluxo intFluxo = new IntFormFluxo();
				largeDesktopPane.add(intFluxo);
				intFluxo.show();
			}
		});
		mntmFluxoCaixa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmFluxoCaixa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmFluxoCaixa.setPreferredSize(new Dimension(150, 30));
		mntmFluxoCaixa.setIcon(new ImageIcon(SistemaForm.class.getResource("/com/dizimaster/img/graphic-icon.png")));
		mnFinanceiro.add(mntmFluxoCaixa);
		
		JButton btnSair = new JButton("Deslogar");
		btnSair.setFocusable(false);
		btnSair.setFocusPainted(false);
		btnSair.setBorder(null);
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deslogar?", "Deslogar?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					deslogar();
				}
			}
		});
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
		btnSair.setForeground(new Color(255, 255, 255));
		btnSair.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSair.setRequestFocusEnabled(false);
		btnSair.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnSair.setBounds(950, 10, 78, 20);
		panel.add(btnSair);
	}

	public JFrame getFrmDizimasterSistema() {
		return frmDizimasterSistema;
	}

	public void setFrmDizimasterSistema(JFrame frmDizimasterSistema) {
		this.frmDizimasterSistema = frmDizimasterSistema;
		frmDizimasterSistema.setResizable(false);
	}
}
