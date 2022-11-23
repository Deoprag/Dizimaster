package com.dizimaster.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.jdesktop.swingx.JXButton;

import com.dizimaster.controller.DatabaseUtils;
import com.dizimaster.model.Funcionario;
import com.dizimaster.util.Util;

public class FormSistema {

	private JFrame frmDizimasterSistema;
	private IntFormMural intMural;
	private JLabel lblHora;
	private JLabel lblData;
	private Funcionario funcionario;
	private int yMouse, xMouse;
	private Util util = new Util();

	public JLabel getLblData() {
		return lblData;
	}

	public void setLblData(JLabel lblData) {
		this.lblData = lblData;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormSistema window = new FormSistema();
					window.getFrmDizimasterSistema().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormSistema() {
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
		getFrmDizimasterSistema().setLocation(x - xMouse, y - yMouse);
	}

	public void deslogar() {
		this.frmDizimasterSistema.dispose();
		FormLogin window = new FormLogin();
		window.getFrmLogin().setVisible(true);
		getFrmDizimasterSistema().dispose();
	}

	private void initialize() {
		setFrmDizimasterSistema(new JFrame());
		getFrmDizimasterSistema().setBounds(100, 100, 1055, 775);
		getFrmDizimasterSistema().getContentPane().setLayout(null);
		getFrmDizimasterSistema().setLocationRelativeTo(null);

		JPanel panelTop = new JPanel();
		panelTop.setBorder(null);
		panelTop.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelTop.setBackground(new Color(62, 62, 62));
		panelTop.setBounds(0, 0, 1055, 39);
		frmDizimasterSistema.getContentPane().add(panelTop);
		panelTop.setLayout(null);

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
				getFrmDizimasterSistema().setState(Frame.ICONIFIED);
			}
		});
		btnMinimize.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMinimize.setFocusPainted(false);
		btnMinimize.setFocusable(false);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setBounds(965, 4, 35, 30);
		panelTop.add(btnMinimize);
		btnMinimize.setText("_");
		btnMinimize.setForeground(new Color(255, 255, 255));
		btnMinimize.setFont(new Font("Noto Sans", Font.BOLD, 15));
		btnMinimize.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnMinimize.setBackground(new Color(128, 128, 128));

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
		btnFechar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setFocusPainted(false);
		btnFechar.setFocusable(false);
		btnFechar.setBorderPainted(false);
		btnFechar.setBounds(1000, 4, 50, 30);
		panelTop.add(btnFechar);
		btnFechar.setText("X");
		btnFechar.setFont(new Font("Noto Sans", Font.BOLD, 16));
		btnFechar.setForeground(new Color(255, 255, 255));
		btnFechar.setBackground(new Color(215, 0, 0));
		btnFechar.setBorder(new LineBorder(new Color(255, 255, 255)));

		JLabel lblIcon = new JLabel("");
		lblIcon.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/icon.png")));
		lblIcon.setBounds(413, 7, 24, 24);
		panelTop.add(lblIcon);

		JLabel lblTitle = new JLabel("Dizimaster - Principal");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblTitle.setBounds(447, 4, 160, 30);
		panelTop.add(lblTitle);

		lblData = new JLabel();
		lblData.setBounds(5, 2, 65, 25);
		panelTop.add(lblData);
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setForeground(Color.WHITE);
		lblData.setFont(new Font("Segoe UI", Font.BOLD, 10));

		lblHora = new JLabel();
		lblHora.setBounds(5, 15, 65, 25);
		panelTop.add(lblHora);
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setForeground(Color.WHITE);
		lblHora.setFont(new Font("Segoe UI", Font.BOLD, 10));

		JPanel panelMid = new JPanel();
		panelMid.setBorder(new MatteBorder(0, 1, 1, 1, (Color) new Color(255, 255, 255)));
		panelMid.setBackground(new Color(0, 128, 192));
		panelMid.setBounds(7, 80, 1040, 683);
		getFrmDizimasterSistema().getContentPane().add(panelMid);
		panelMid.setLayout(null);

		JDesktopPane largeDesktopPane = new JDesktopPane();
		largeDesktopPane.setFocusable(false);
		largeDesktopPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		largeDesktopPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		largeDesktopPane.setBackground(SystemColor.textHighlight);
		largeDesktopPane.setBounds(10, 10, 1020, 665);
		panelMid.add(largeDesktopPane);
		intMural = new IntFormMural();
		largeDesktopPane.setLayer(intMural, 0);
		intMural.setBounds(1, 1, 1018, 663);
		intMural.setVisible(true);
		largeDesktopPane.setLayout(null);
		largeDesktopPane.add(intMural);
		intMural.show();

		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(255, 255, 255)));
		panelMenu.setBackground(new Color(0, 128, 192));
		panelMenu.setBounds(7, 40, 1040, 40);
		frmDizimasterSistema.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);

		JButton btnDeslogar = new JButton("Deslogar");
		btnDeslogar.setBounds(10, 10, 78, 20);
		panelMenu.add(btnDeslogar);
		btnDeslogar.setFocusable(false);
		btnDeslogar.setFocusPainted(false);
		btnDeslogar.setBorder(new LineBorder(new Color(128, 0, 0)));
		btnDeslogar.setBackground(new Color(184, 44, 54));
		btnDeslogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deslogar?", "Deslogar?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					deslogar();
				}
			}
		});
		btnDeslogar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnDeslogar.setBackground(new Color(143, 20, 29));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnDeslogar.setBackground(new Color(184, 44, 54));
			}
		});
		btnDeslogar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDeslogar.setForeground(new Color(255, 255, 255));
		btnDeslogar.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDeslogar.setRequestFocusEnabled(false);
		btnDeslogar.setFont(new Font("Segoe UI", Font.BOLD, 12));

		JMenuBar menuTop = new JMenuBar();
		menuTop.setBounds(98, 1, 842, 40);
		panelMenu.add(menuTop);
		menuTop.setBorder(null);
		menuTop.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuTop.setPreferredSize(new Dimension(0, 30));
		menuTop.setBorderPainted(false);
		menuTop.setBackground(new Color(0, 106, 157));

		if (DatabaseUtils.getFuncionario().isAdmin() == true) {
			JMenu mnFuncionario = new JMenu("Funcionário");
			mnFuncionario.setForeground(new Color(255, 255, 255));
			mnFuncionario.setMargin(new Insets(2, 4, 2, 2));
			mnFuncionario.setBorder(null);
			mnFuncionario.setFont(new Font("Segoe UI", Font.BOLD, 14));
			mnFuncionario.setHorizontalTextPosition(SwingConstants.CENTER);
			mnFuncionario.setHorizontalAlignment(SwingConstants.CENTER);
			mnFuncionario.setPreferredSize(new Dimension(90, 30));
			mnFuncionario.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			menuTop.add(mnFuncionario);

			JMenuItem mntmNovoFuncionario = new JMenuItem("Novo Funcionário");
			mntmNovoFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			mntmNovoFuncionario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
			mntmNovoFuncionario.setPreferredSize(new Dimension(150, 30));
			mnFuncionario.add(mntmNovoFuncionario);
			mntmNovoFuncionario
					.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/signup-icon.png")));

			JMenuItem mntmGerenciarFuncionario = new JMenuItem("Gerenciar Funcionários");
			mntmGerenciarFuncionario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			mntmGerenciarFuncionario
					.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/mange-icon.png")));
			mntmGerenciarFuncionario.setPreferredSize(new Dimension(170, 30));
			mntmGerenciarFuncionario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
			mnFuncionario.add(mntmGerenciarFuncionario);
			mntmNovoFuncionario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					largeDesktopPane.removeAll();
					IntFormCadastroFuncionario intCad = new IntFormCadastroFuncionario();
					largeDesktopPane.add(intMural);
					intMural.show();
					largeDesktopPane.add(intCad);
					intCad.show();
				}
			});
			mntmGerenciarFuncionario.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					largeDesktopPane.removeAll();
					IntFormAdmFuncionario intAdmFunc = new IntFormAdmFuncionario();
					intAdmFunc.setFuncionario(funcionario);
					largeDesktopPane.add(intMural);
					intMural.show();
					largeDesktopPane.add(intAdmFunc);
					intAdmFunc.show();
				}
			});
		}

		JMenu mnDizimista = new JMenu("Dizimista");
		mnDizimista.setForeground(new Color(255, 255, 255));
		mnDizimista.setMargin(new Insets(2, 4, 2, 2));
		mnDizimista.setBorder(null);
		mnDizimista.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnDizimista.setHorizontalTextPosition(SwingConstants.CENTER);
		mnDizimista.setHorizontalAlignment(SwingConstants.CENTER);
		mnDizimista.setPreferredSize(new Dimension(90, 30));
		mnDizimista.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		mnDizimista.setIcon(null);
		mnDizimista.setBorderPainted(true);
		mnDizimista.setBackground(Color.WHITE);
		mnDizimista.setIconTextGap(6);
		menuTop.add(mnDizimista);

		JMenuItem mntmNovoDizimista = new JMenuItem("Novo Dizimista");
		mntmNovoDizimista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeDesktopPane.removeAll();
				IntFormCadastroDizimista intCad = new IntFormCadastroDizimista();
				largeDesktopPane.add(intMural);
				intMural.show();
				largeDesktopPane.add(intCad);
				intCad.show();
			}
		});
		mntmNovoDizimista.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNovoDizimista.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmNovoDizimista.setPreferredSize(new Dimension(150, 30));
		mntmNovoDizimista.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/signup-icon.png")));
		mnDizimista.add(mntmNovoDizimista);

		JMenuItem mntmGerenciarDizimista = new JMenuItem("Gerenciar Dizimistas");
		mntmGerenciarDizimista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeDesktopPane.removeAll();
				IntFormAdmDizimista intAdmDiz = new IntFormAdmDizimista();
				intAdmDiz.setFuncionario(funcionario);
				largeDesktopPane.add(intMural);
				intMural.show();
				largeDesktopPane.add(intAdmDiz);
				intAdmDiz.show();
			}
		});
		mntmGerenciarDizimista.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmGerenciarDizimista.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmGerenciarDizimista.setPreferredSize(new Dimension(150, 30));
		mntmGerenciarDizimista
				.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/mange-icon.png")));
		mnDizimista.add(mntmGerenciarDizimista);

		JMenu mnFinanceiro = new JMenu("Financeiro");
		mnFinanceiro.setForeground(new Color(255, 255, 255));
		mnFinanceiro.setMargin(new Insets(2, 4, 2, 2));
		mnFinanceiro.setBorder(null);
		mnFinanceiro.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mnFinanceiro.setHorizontalTextPosition(SwingConstants.CENTER);
		mnFinanceiro.setHorizontalAlignment(SwingConstants.CENTER);
		mnFinanceiro.setPreferredSize(new Dimension(90, 30));
		menuTop.add(mnFinanceiro);

		JMenu mntmRegistrarPagamento = new JMenu("Registrar Pagamento");
		mntmRegistrarPagamento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmRegistrarPagamento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmRegistrarPagamento.setPreferredSize(new Dimension(150, 30));
		mntmRegistrarPagamento
				.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/receipt-icon.png")));
		mnFinanceiro.add(mntmRegistrarPagamento);

		JMenuItem mntmDizimo = new JMenuItem("Dizimo");
		mntmDizimo.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/tithe-icon.png")));
		mntmDizimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeDesktopPane.removeAll();
				IntFormDizimo intDizimo = new IntFormDizimo();
				intDizimo.setFuncionario(funcionario);
				largeDesktopPane.add(intMural);
				intMural.show();
				largeDesktopPane.add(intDizimo);
				intDizimo.show();
			}
		});
		mntmRegistrarPagamento.add(mntmDizimo);
		mntmDizimo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmDizimo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmDizimo.setPreferredSize(new Dimension(100, 30));

		JMenuItem mntmOferta = new JMenuItem("Oferta");
		mntmOferta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeDesktopPane.removeAll();
				IntFormOferta intOferta = new IntFormOferta();
				intOferta.setFuncionario(funcionario);
				largeDesktopPane.add(intMural);
				intMural.show();
				largeDesktopPane.add(intOferta);
				intOferta.show();
			}
		});
		mntmOferta.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/offering-icon.png")));
		mntmOferta.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmOferta.setPreferredSize(new Dimension(100, 30));
		mntmRegistrarPagamento.add(mntmOferta);

		JMenuItem mntmDespesa = new JMenuItem("Registrar Despesa");
		mntmDespesa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeDesktopPane.removeAll();
				IntFormDespesa intDespesa = new IntFormDespesa();
				intDespesa.setFuncionario(funcionario);
				largeDesktopPane.add(intMural);
				intMural.show();
				largeDesktopPane.add(intDespesa);
				intDespesa.show();
			}
		});
		mntmDespesa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmDespesa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmDespesa.setPreferredSize(new Dimension(150, 30));
		mntmDespesa.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/spent-icon.png")));
		mnFinanceiro.add(mntmDespesa);

		JMenuItem mntmComprovantes = new JMenuItem("Gerar Comprovantes");
		mntmComprovantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeDesktopPane.removeAll();
				IntFormDespesa intDespesa = new IntFormDespesa();
				intDespesa.setFuncionario(funcionario);
				largeDesktopPane.add(intMural);
				intMural.show();
				largeDesktopPane.add(intDespesa);
				intDespesa.show();
			}
		});
		mntmComprovantes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmComprovantes.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/report-icon.png")));
		mntmComprovantes.setPreferredSize(new Dimension(180, 30));
		mntmComprovantes.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mnFinanceiro.add(mntmComprovantes);

		JMenuItem mntmFluxoCaixa = new JMenuItem("Fluxo de Caixa");
		mntmFluxoCaixa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				largeDesktopPane.removeAll();
				IntFormFluxo intFluxo = new IntFormFluxo();
				intFluxo.setFuncionario(funcionario);
				largeDesktopPane.add(intMural);
				intMural.show();
				largeDesktopPane.add(intFluxo);
				intFluxo.show();
			}
		});
		mntmFluxoCaixa.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmFluxoCaixa.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		mntmFluxoCaixa.setPreferredSize(new Dimension(150, 30));
		mntmFluxoCaixa.setIcon(new ImageIcon(FormSistema.class.getResource("/com/dizimaster/img/graphic-icon.png")));
		mnFinanceiro.add(mntmFluxoCaixa);

		panelTop.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				yMouse = e.getY();
				xMouse = e.getX();
			}
		});
		panelTop.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				mexe(x, y);
			}
		});
	}

	public JFrame getFrmDizimasterSistema() {
		return frmDizimasterSistema;
	}

	public void setFrmDizimasterSistema(JFrame frmDizimasterSistema) {
		this.frmDizimasterSistema = frmDizimasterSistema;
		frmDizimasterSistema.setIconImage(
				Toolkit.getDefaultToolkit().getImage(FormSistema.class.getResource("/com/dizimaster/img/icon2.png")));
		frmDizimasterSistema.getContentPane().setBackground(new Color(62, 62, 62));
		frmDizimasterSistema.setUndecorated(true);
	}

	public IntFormMural getIntMural() {
		return intMural;
	}

	public void setIntMural(IntFormMural intMural) {
		this.intMural = intMural;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public JLabel getLblHora() {
		return lblHora;
	}

	public void setLblHora(JLabel lblHora) {
		this.lblHora = lblHora;
	}
}
