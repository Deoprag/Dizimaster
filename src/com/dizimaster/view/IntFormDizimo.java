package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.dizimaster.controller.DatabaseUtils;
import com.dizimaster.model.Dizimista;
import com.dizimaster.model.Dizimo;
import com.dizimaster.model.Funcionario;
import com.dizimaster.swing.TxtNome;
import com.dizimaster.swing.TxtObservacao;
import com.dizimaster.swing.TxtSalarioFormat;
import com.dizimaster.util.Util;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntFormDizimo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtValor;
	private Funcionario funcionario;
	private Dizimista dizimista;
	private Util util = new Util();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormDizimo frame = new IntFormDizimo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void voltar() {
		this.dispose();
	}

	public IntFormDizimo() {
		setBorder(null);
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);

		JPanel panelCadastro = new JPanel();
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(335, 34, 350, 570);
		getContentPane().add(panelCadastro);
		panelCadastro.setLayout(null);

		JLabel lblReal = new JLabel("R$");
		lblReal.setForeground(Color.WHITE);
		lblReal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblReal.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		lblReal.setBackground(Color.WHITE);
		lblReal.setAlignmentX(0.5f);
		lblReal.setBounds(100, 340, 25, 30);
		panelCadastro.add(lblReal);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 384, 150, 100);
		scrollPane.setBorder(null);
		panelCadastro.add(scrollPane);

		TxtObservacao txtObs = new TxtObservacao(199);
		txtObs.setEnabled(false);
		scrollPane.setViewportView(txtObs);
		txtObs.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtObs.setForeground(Color.WHITE);
				txtObs.setText("");
			}
		});
		txtObs.setLineWrap(true);
		txtObs.setWrapStyleWord(true);
		txtObs.setMargin(new Insets(0, 0, 0, 0));
		txtObs.setForeground(new Color(192, 192, 192));
		txtObs.setText("Insira aqui uma observação");
		txtObs.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtObs.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)),
				new EmptyBorder(2, 5, 2, 5)));
		txtObs.setBackground(new Color(30, 140, 175));

		JLabel lblObs = new JLabel("Obs");
		lblObs.setBounds(53, 381, 81, 24);
		lblObs.setForeground(Color.WHITE);
		lblObs.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblObs.setBorder(null);
		lblObs.setBackground(Color.WHITE);
		lblObs.setAlignmentX(0.5f);
		panelCadastro.add(lblObs);

		JButton btnSearch = new JButton("");
		btnSearch.setBounds(190, 265, 25, 25);
		btnSearch.setBorder(null);
		btnSearch.setBorderPainted(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setRequestFocusEnabled(false);
		btnSearch.setFocusable(false);
		btnSearch.setBackground(new Color(25, 120, 150));
		panelCadastro.add(btnSearch);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/find-icon.png")));

		TxtSalarioFormat txtValor = new TxtSalarioFormat(8);
		txtValor.setBounds(120, 340, 60, 30);
		txtValor.setEnabled(false);
		txtValor.setForeground(new Color(255, 255, 255));
		txtValor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtValor.setColumns(10);
		txtValor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtValor.setBackground(new Color(25, 120, 150));
		panelCadastro.add(txtValor);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(53, 340, 63, 24);
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblValor.setBorder(null);
		lblValor.setBackground(Color.WHITE);
		lblValor.setAlignmentX(0.5f);
		panelCadastro.add(lblValor);

		txtNome = new TxtNome(100);
		txtNome.setBounds(100, 300, 150, 30);
		txtNome.setEnabled(false);
		txtNome.setForeground(new Color(255, 255, 255));
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtNome.setBackground(new Color(25, 120, 150));
		panelCadastro.add(txtNome);

		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('*');
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(100, 260, 90, 30);
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnSearch.doClick();
				}
			}
		});
		txtCpf.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtCpf.setText("");
				txtCpf.setForeground(Color.WHITE);
			}
		});
		txtCpf.setForeground(new Color(192, 192, 192));
		txtCpf.setText("00000000000");
		txtCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCpf.setBackground(new Color(25, 120, 150));
		panelCadastro.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(53, 300, 63, 24);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNome.setBorder(null);
		lblNome.setBackground(Color.WHITE);
		lblNome.setAlignmentX(0.5f);
		panelCadastro.add(lblNome);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(53, 260, 46, 24);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCpf.setBorder(null);
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setAlignmentX(0.5f);
		panelCadastro.add(lblCpf);

		JButton btnSair = new JButton("VOLTAR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar?", "Voltar?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					voltar();
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
		btnSair.setBounds(56, 495, 90, 40);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		panelCadastro.add(btnSair);

		JLabel lblTitulo = new JLabel("Dízimo");
		lblTitulo.setBounds(55, 200, 240, 35);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblTitulo.setBackground(Color.GRAY);
		panelCadastro.add(lblTitulo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Util.openWebpage("https://www.instagram.com/deopraglabs");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(
						new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/logo-hold-small.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setBounds(100, 20, 150, 150);
		lblLogo.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/logo-small.png")));
		panelCadastro.add(lblLogo);

		JButton btnEnviar = new JButton("REGISTRAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if ((txtCpf.getText().trim().length() < 14)) {
						JOptionPane.showMessageDialog(null, "Preencha o CPF!");
					} else {
						if (!txtNome.getText().isBlank() && !txtValor.getText().isBlank()) {
							Dizimo dizimo = new Dizimo();
							dizimo.setDizimista(dizimista.getId());
							dizimo.setValor(Float.parseFloat(txtValor.getText()));
							dizimo.setFuncionario(funcionario.getId());
							if (!txtObs.getText().isBlank() && txtObs.getForeground() == Color.WHITE) {
								dizimo.setObservacao(txtObs.getText());
							}
							dizimo.setData(util.dataAtual());
							dizimo.setHora(util.horaAtual());
							if (DatabaseUtils.registraDizimo(dizimo) == true) {
								txtCpf.setText("");
								txtNome.setText("");
								txtValor.setText("");
								txtObs.setText("Insira aqui uma observação");
								txtObs.setForeground(new Color(192,192,192));
								txtObs.setEnabled(false);
							}
						} else {
							JOptionPane.showMessageDialog(null, "Pesquise o CPF antes de registrar!");
						}
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "O valor inserido é inválido!");
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviar.setBackground(new Color(0, 105, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEnviar.setBackground(new Color(0, 122, 152));
			}
		});
		btnEnviar.setBounds(202, 495, 90, 40);
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		btnEnviar.setFocusable(false);
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(0, 122, 152));
		panelCadastro.add(btnEnviar);

		JLabel lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setBounds(0, 0, 350, 570);
		lblBackgroundPanel.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panelCadastro.add(lblBackgroundPanel);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/church-bg.png")));
		lblBackground.setBackground(new Color(66, 174, 193));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);

		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if ((txtCpf.getText().trim().length() < 14)) {
					JOptionPane.showMessageDialog(null, "Preencha o CPF!");
				} else {
					txtNome.setText("");
					txtValor.setText("");
					try {
						dizimista = DatabaseUtils.pesquisaDizimista(txtCpf.getText().replace("-", "").replace(".", ""));
						if(dizimista.isAtivo()) {
							txtNome.setForeground(Color.WHITE);
							txtValor.setForeground(Color.WHITE);

							txtNome.setText(dizimista.getNome());
							DecimalFormat df = new DecimalFormat("0.00");
							txtValor.setText(df.format(dizimista.getSalario() / 10));
							txtObs.setEnabled(true);
						} else {
							JOptionPane.showMessageDialog(null, "Cadastro desativado!");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setIcon(
						new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/find-icon-hold.png")));
			}

			public void mouseExited(MouseEvent e) {
				btnSearch.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/find-icon.png")));
			}
		});
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public void setTxtValor(JTextField txtValor) {
		this.txtValor = txtValor;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
