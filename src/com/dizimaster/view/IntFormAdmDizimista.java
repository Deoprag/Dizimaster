package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.dizimaster.controller.DatabaseUtils;
import com.dizimaster.model.Dizimista;
import com.dizimaster.model.Funcionario;
import com.dizimaster.swing.TxtSalarioFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class IntFormAdmDizimista extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private Dizimista dizimistaPesquisa;
	private JFormattedTextField txtEditCpf;
	private JTextField txtNome;
	private JTextField fTxtNascimento;
	private JComboBox<?> boxSexo;
	private JFormattedTextField fTxtCelular;
	private TxtSalarioFormat txtSalario;
	private JCheckBox chckbxAtivo;
	private JButton btnSalvar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormAdmDizimista frame = new IntFormAdmDizimista();
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

	private void limpar() {
		txtEditCpf.setText("");
		txtEditCpf.setEnabled(false);
		txtNome.setText("");
		txtNome.setEnabled(false);
		fTxtNascimento.setText("");
		fTxtNascimento.setEnabled(false);
		boxSexo.setSelectedIndex(-1);
		boxSexo.setEnabled(false);
		fTxtCelular.setText("");
		fTxtCelular.setEnabled(false);
		txtSalario.setText("");
		txtSalario.setEnabled(false);
		chckbxAtivo.setSelected(false);
		chckbxAtivo.setEnabled(false);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public IntFormAdmDizimista() {
		getContentPane().setBackground(new Color(230, 243, 255));
		setBorder(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 1020, 700);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);

		MaskFormatter mascaraNascimento = null;
		MaskFormatter mascaraCelular = null;
		MaskFormatter mascaraCpf = null;
		try {
			mascaraNascimento = new MaskFormatter("##/##/####");
			mascaraNascimento.setPlaceholderCharacter('*');
			mascaraCelular = new MaskFormatter("(##) #####-####");
			mascaraCelular.setPlaceholderCharacter('*');
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('*');
		} catch (Exception e) {
			e.printStackTrace();
		}

		JPanel panelTop = new JPanel();
		panelTop.setBackground(new Color(255, 255, 255));
		panelTop.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelTop.setBounds(230, 40, 560, 120);
		getContentPane().add(panelTop);
		panelTop.setLayout(null);

		JLabel lblConsulta = new JLabel("Consultar Dizimista");
		lblConsulta.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblConsulta.setBounds(10, 11, 320, 35);
		panelTop.add(lblConsulta);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(0, 50, 1000, 2);
		panelTop.add(separator);

		JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBackground(new Color(255, 255, 255));
		txtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtCpf.setBounds(50, 72, 125, 30);
		panelTop.add(txtCpf);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(new Color(0, 0, 0));
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpf.setBounds(10, 70, 87, 30);
		panelTop.add(lblCpf);

		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
				if (txtCpf.getText().replace(".", "").replace("-", "").replace("*", "").length() == 11) {
					dizimistaPesquisa = DatabaseUtils
							.pesquisaDizimista(txtCpf.getText().replace(".", "").replace("-", ""));
					if (dizimistaPesquisa != null) {

						txtNome.setEnabled(true);
						fTxtNascimento.setEnabled(true);
						boxSexo.setEnabled(true);
						fTxtCelular.setEnabled(true);
						txtSalario.setEnabled(true);
						chckbxAtivo.setEnabled(true);

						txtEditCpf.setText(txtCpf.getText());
						txtNome.setText(dizimistaPesquisa.getNome());

						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
						fTxtNascimento.setText(formatter.format(dizimistaPesquisa.getNascimento()));
						if (dizimistaPesquisa.getSexo() == 'm') {
							boxSexo.setSelectedItem("Masculino");
						} else if (dizimistaPesquisa.getSexo() == 'f') {
							boxSexo.setSelectedItem("Feminino");
						}
						fTxtCelular.setText(dizimistaPesquisa.getCelular());
						txtSalario.setText(String.valueOf(dizimistaPesquisa.getSalario()));
						if (dizimistaPesquisa.isAtivo()) {
							chckbxAtivo.setSelected(true);
						} else {
							chckbxAtivo.setSelected(false);
						}

						btnSalvar.setEnabled(true);
					} else {
						JOptionPane.showMessageDialog(null, "CPF não encontrado!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Digite um CPF!");
				}
			}
		});
		btnSearch.setRolloverEnabled(false);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setFocusTraversalKeysEnabled(false);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setIcon(new ImageIcon(
						IntFormAdmDizimista.class.getResource("/com/dizimaster/img/find-icon-2-hold.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setIcon(
						new ImageIcon(IntFormAdmDizimista.class.getResource("/com/dizimaster/img/find-icon-2.png")));
			}
		});
		btnSearch.setIcon(new ImageIcon(IntFormAdmDizimista.class.getResource("/com/dizimaster/img/find-icon-2.png")));
		btnSearch.setRequestFocusEnabled(false);
		btnSearch.setFocusable(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBorder(null);
		btnSearch.setBackground(new Color(255, 255, 255));
		btnSearch.setBounds(185, 77, 25, 25);
		panelTop.add(btnSearch);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLimpar.setBackground(new Color(170, 170, 170));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLimpar.setBackground(new Color(192, 192, 192));
			}
		});
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCpf.setText("");
				btnSearch.doClick();
			}
		});
		btnLimpar.setForeground(new Color(0, 0, 0));
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		btnLimpar.setFocusable(false);
		btnLimpar.setBorder(new LineBorder(new Color(60, 60, 60), 1, true));
		btnLimpar.setBackground(new Color(200, 200, 200));
		btnLimpar.setBounds(415, 72, 135, 30);
		panelTop.add(btnLimpar);

		JButton btnSair = new JButton("VOLTAR");
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
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar?", "Voltar?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					voltar();
				}
			}
		});
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(460, 12, 90, 30);
		panelTop.add(btnSair);

		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(null);
		panelBottom.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelBottom.setBackground(Color.WHITE);
		panelBottom.setBounds(230, 170, 560, 460);
		getContentPane().add(panelBottom);

		fTxtNascimento = new JFormattedTextField(mascaraNascimento);
		fTxtNascimento.setEnabled(false);
		fTxtNascimento.setForeground(new Color(0, 0, 0));
		fTxtNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtNascimento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		fTxtNascimento.setBackground(new Color(255, 255, 255));
		fTxtNascimento.setBounds(107, 180, 100, 30);
		panelBottom.add(fTxtNascimento);

		JLabel lblNascimento1 = new JLabel("Data de");
		lblNascimento1.setForeground(new Color(0, 0, 0));
		lblNascimento1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNascimento1.setBorder(null);
		lblNascimento1.setBackground(Color.WHITE);
		lblNascimento1.setAlignmentX(0.5f);
		lblNascimento1.setBounds(10, 180, 87, 15);
		panelBottom.add(lblNascimento1);

		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtNome.setBackground(new Color(255, 255, 255));
		txtNome.setBounds(107, 130, 270, 30);
		panelBottom.add(txtNome);

		JLabel lblEditar = new JLabel("Editar Cadastro");
		lblEditar.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblEditar.setBounds(10, 11, 320, 35);
		panelBottom.add(lblEditar);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 50, 1000, 2);
		panelBottom.add(separator_1);

		txtEditCpf = new JFormattedTextField(mascaraCpf);
		txtEditCpf.setEnabled(false);
		txtEditCpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEditCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtEditCpf.setBackground(new Color(255, 255, 255));
		txtEditCpf.setBounds(107, 80, 125, 30);
		panelBottom.add(txtEditCpf);

		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setForeground(new Color(0, 0, 0));
		lblCpf_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpf_1.setBounds(10, 80, 87, 30);
		panelBottom.add(lblCpf_1);

		JButton btnSearch_1 = new JButton("");
		btnSearch_1.setRolloverEnabled(false);
		btnSearch_1.setRequestFocusEnabled(false);
		btnSearch_1.setFocusable(false);
		btnSearch_1.setFocusTraversalKeysEnabled(false);
		btnSearch_1.setFocusPainted(false);
		btnSearch_1.setBorderPainted(false);
		btnSearch_1.setBorder(null);
		btnSearch_1.setBackground(Color.WHITE);
		btnSearch_1.setBounds(340, 124, 25, 25);
		panelBottom.add(btnSearch_1);

		JLabel lblNome_1 = new JLabel("Nome");
		lblNome_1.setForeground(new Color(0, 0, 0));
		lblNome_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNome_1.setBounds(10, 130, 87, 30);
		panelBottom.add(lblNome_1);

		JLabel lblNascimento2 = new JLabel("Nascimento");
		lblNascimento2.setForeground(new Color(0, 0, 0));
		lblNascimento2.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNascimento2.setBorder(null);
		lblNascimento2.setBackground(Color.WHITE);
		lblNascimento2.setAlignmentX(0.5f);
		lblNascimento2.setBounds(10, 195, 87, 15);
		panelBottom.add(lblNascimento2);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(new Color(0, 0, 0));
		lblSexo.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSexo.setBounds(10, 230, 87, 30);
		panelBottom.add(lblSexo);

		boxSexo = new JComboBox();
		boxSexo.setEditable(true);
		boxSexo.setEnabled(false);
		boxSexo.setFocusTraversalKeysEnabled(false);
		boxSexo.setFocusable(false);
		boxSexo.setForeground(new Color(0, 0, 0));
		boxSexo.setRequestFocusEnabled(false);
		boxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
		boxSexo.setMaximumRowCount(2);
		boxSexo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		boxSexo.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		boxSexo.setBackground(new Color(255, 255, 255));
		boxSexo.setBounds(107, 230, 150, 30);
		panelBottom.add(boxSexo);

		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setForeground(new Color(0, 0, 0));
		lblCelular.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCelular.setBounds(10, 280, 87, 30);
		panelBottom.add(lblCelular);

		fTxtCelular = new JFormattedTextField(mascaraCelular);
		fTxtCelular.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fTxtCelular.setEnabled(false);
		fTxtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		fTxtCelular.setBackground(new Color(255, 255, 255));
		fTxtCelular.setBounds(107, 280, 150, 30);
		panelBottom.add(fTxtCelular);

		JLabel lblSalario = new JLabel("Salário");
		lblSalario.setForeground(new Color(0, 0, 0));
		lblSalario.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblSalario.setBounds(10, 330, 87, 30);
		panelBottom.add(lblSalario);

		txtSalario = new TxtSalarioFormat(8);
		txtSalario.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtSalario.setEnabled(false);
		txtSalario.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtSalario.setBackground(new Color(255, 255, 255));
		txtSalario.setBounds(107, 330, 100, 30);
		panelBottom.add(txtSalario);

		chckbxAtivo = new JCheckBox("Ativo");
		chckbxAtivo.setBackground(new Color(255, 255, 255));
		chckbxAtivo.setEnabled(false);
		chckbxAtivo.setFocusPainted(false);
		chckbxAtivo.setFocusable(false);
		chckbxAtivo.setRolloverEnabled(false);
		chckbxAtivo.setRequestFocusEnabled(false);
		chckbxAtivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxAtivo.setBounds(245, 80, 100, 30);
		panelBottom.add(chckbxAtivo);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtEditCpf.getText().length() == 14 && !txtNome.getText().isBlank()
						&& fTxtCelular.getText().length() == 15 && !txtSalario.getText().isBlank()
						&& fTxtNascimento.getText().length() == 10) {
					try {
						Dizimista dizimistaEdita = new Dizimista();
						dizimistaEdita.setCpf(txtEditCpf.getText().replace("-", "").replace(".", ""));
						dizimistaEdita.setNome(txtNome.getText());
						dizimistaEdita.setCelular(fTxtCelular.getText().replace("(", "").replace(")", "")
								.replace("-", "").replace(" ", ""));
						LocalDate data = LocalDate.parse(fTxtNascimento.getText(),
								DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						dizimistaEdita.setNascimento(data);
						dizimistaEdita.setSalario(Float.parseFloat(txtSalario.getText().replace(",", ".")));
						if (boxSexo.getSelectedIndex() == 0) {
							dizimistaEdita.setSexo('m');
						} else {
							dizimistaEdita.setSexo('f');
						}

						if (chckbxAtivo.isSelected()) {
							dizimistaEdita.setAtivo(true);
						} else {
							dizimistaEdita.setAtivo(false);
						}
						if (DatabaseUtils.alterarDizimista(dizimistaEdita) == true) {
							limpar();
						} else {

						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "O salário inserido é inválido!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(240, 409, 90, 40);
		panelBottom.add(btnSalvar);
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if (btnSalvar.isEnabled()) {
					btnSalvar.setBackground(new Color(33, 91, 158));
				}
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSalvar.setBackground(new Color(60, 122, 194));
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnSalvar.setFocusable(false);
		btnSalvar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnSalvar.setBackground(new Color(60, 122, 194));

		JLabel lblBackground = new JLabel("");
		lblBackground
				.setIcon(new ImageIcon(IntFormAdmDizimista.class.getResource("/com/dizimaster/img/heaven-bg.jpg")));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Dizimista getdizimistaPesquisa() {
		return dizimistaPesquisa;
	}

	public void setdizimistaPesquisa(Dizimista dizimistaPesquisa) {
		this.dizimistaPesquisa = dizimistaPesquisa;
	}

	public JTextField getfTxtNascimento() {
		return fTxtNascimento;
	}

	public void setfTxtNascimento(JTextField fTxtNascimento) {
		this.fTxtNascimento = fTxtNascimento;
	}

	public JCheckBox getChckbxAtivo() {
		return chckbxAtivo;
	}

	public void setChckbxAtivo(JCheckBox chckbxAtivo) {
		this.chckbxAtivo = chckbxAtivo;
	}
}
