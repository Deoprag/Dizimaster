package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.dizimaster.model.Funcionario;
import com.dizimaster.util.DatabaseUtils;
import com.dizimaster.util.GenericUtils;

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
import java.awt.SystemColor;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JToggleButton;

public class IntFormAdmFuncionario extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private Funcionario funcionarioPesquisa;
	private JFormattedTextField txtEditCpf;
	private JTextField txtNome;
	private JTextField fTxtNascimento;
	private JComboBox<?> boxSexo;
	private JFormattedTextField fTxtCelular;
	private JTextField txtEmail;
	private JCheckBox chckbxAdmin;
	private JCheckBox chckbxAtivo;
	private JToggleButton btnRedefinir;
	private JButton btnSalvar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormAdmFuncionario frame = new IntFormAdmFuncionario();
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
		txtEmail.setText("");
		txtEmail.setEnabled(false);
		chckbxAdmin.setSelected(false);
		chckbxAdmin.setEnabled(false);
		chckbxAtivo.setSelected(false);
		chckbxAtivo.setEnabled(false);
		btnRedefinir.setSelected(false);
		btnRedefinir.setEnabled(false);
	}

	public IntFormAdmFuncionario() {
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
		panelTop.setBounds(230, 11, 560, 120);
		getContentPane().add(panelTop);
		panelTop.setLayout(null);
		
		JLabel lblConsulta = new JLabel("Consulta de Funcionário");
		lblConsulta.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblConsulta.setBounds(10, 11, 320, 35);
		panelTop.add(lblConsulta);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(192, 192, 192));
		separator.setBounds(0, 57, 1000, 2);
		panelTop.add(separator);
		
		JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBackground(new Color(240, 240, 240));
		txtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtCpf.setBounds(50, 72, 125, 30);
		panelTop.add(txtCpf);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCpf.setBounds(10, 70, 40, 30);
		panelTop.add(lblCpf);
		
		JButton btnSearch = new JButton("");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();				
				if (txtCpf.getText().replace(".", "").replace("-", "").replace("*", "").length() == 11) {
					funcionarioPesquisa = DatabaseUtils.pesquisaFuncionario(txtCpf.getText().replace(".", "").replace("-", ""));
					if (funcionarioPesquisa != null) {
						
						txtNome.setEnabled(true);
						fTxtNascimento.setEnabled(true);
						boxSexo.setEnabled(true);
						fTxtCelular.setEnabled(true);
						txtEmail.setEnabled(true);
						chckbxAdmin.setEnabled(true);
						chckbxAtivo.setEnabled(true);
						
						txtEditCpf.setText(txtCpf.getText());
						txtNome.setText(funcionarioPesquisa.getNome());
						
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
						fTxtNascimento.setText(formatter.format(funcionarioPesquisa.getNascimento()));
						if (funcionarioPesquisa.getSexo() == 'm') {
							boxSexo.setSelectedIndex(-1);
						} else {
							boxSexo.setSelectedIndex(0);
						}
						fTxtCelular.setText(funcionarioPesquisa.getCelular());						
						txtEmail.setText(funcionarioPesquisa.getEmail());
						if(funcionarioPesquisa.isAdmin()) {
							chckbxAdmin.setSelected(true);
						} else {
							chckbxAdmin.setSelected(false);
						}
						if(funcionarioPesquisa.isAtivo()) {
							chckbxAtivo.setSelected(true);
						} else {
							chckbxAtivo.setSelected(false);
						}
						
						btnRedefinir.setEnabled(true);
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
				btnSearch.setIcon(new ImageIcon(IntFormAdmFuncionario.class.getResource("/com/dizimaster/img/find-icon-2-hold.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setIcon(new ImageIcon(IntFormAdmFuncionario.class.getResource("/com/dizimaster/img/find-icon-2.png")));
			}
		});
		btnSearch.setIcon(new ImageIcon(IntFormAdmFuncionario.class.getResource("/com/dizimaster/img/find-icon-2.png")));
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
				btnLimpar.setBackground(new Color(170,170,170));
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
		btnLimpar.setForeground(Color.BLACK);
		btnLimpar.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		btnLimpar.setFocusable(false);
		btnLimpar.setBorder(new LineBorder(new Color(60, 60, 60), 1, true));
		btnLimpar.setBackground(new Color(220, 220, 220));
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
		btnSair.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(460, 11, 90, 40);
		panelTop.add(btnSair);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setLayout(null);
		panelBottom.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelBottom.setBackground(Color.WHITE);
		panelBottom.setBounds(230, 142, 560, 520);
		getContentPane().add(panelBottom);
		
		fTxtNascimento = new JFormattedTextField(mascaraNascimento);
		fTxtNascimento.setEnabled(false);
		fTxtNascimento.setForeground(new Color(0, 0, 0));
		fTxtNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtNascimento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		fTxtNascimento.setBackground(SystemColor.menu);
		fTxtNascimento.setBounds(95, 180, 100, 30);
		panelBottom.add(fTxtNascimento);
		
		JLabel lblNascimento1 = new JLabel("Data de");
		lblNascimento1.setForeground(new Color(0, 0, 0));
		lblNascimento1.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNascimento1.setBorder(null);
		lblNascimento1.setBackground(Color.WHITE);
		lblNascimento1.setAlignmentX(0.5f);
		lblNascimento1.setBounds(10, 180, 61, 15);
		panelBottom.add(lblNascimento1);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtNome.setBackground(SystemColor.menu);
		txtNome.setBounds(95, 130, 270, 30);
		panelBottom.add(txtNome);
		
		JLabel lblEditar = new JLabel("Editar Funcionário");
		lblEditar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblEditar.setBounds(10, 11, 320, 35);
		panelBottom.add(lblEditar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(0, 57, 1000, 2);
		panelBottom.add(separator_1);
		
		txtEditCpf = new JFormattedTextField(mascaraCpf);
		txtEditCpf.setEnabled(false);
		txtEditCpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEditCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEditCpf.setBackground(SystemColor.menu);
		txtEditCpf.setBounds(95, 80, 125, 30);
		panelBottom.add(txtEditCpf);
		
		JLabel lblCpf_1 = new JLabel("CPF");
		lblCpf_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCpf_1.setBounds(10, 80, 40, 30);
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
		lblNome_1.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblNome_1.setBounds(10, 130, 50, 30);
		panelBottom.add(lblNome_1);
		
		btnRedefinir = new JToggleButton("Redefinir Senha");
		btnRedefinir.setEnabled(false);
		btnRedefinir.setFocusPainted(false);
		btnRedefinir.setFocusTraversalKeysEnabled(false);
		btnRedefinir.setBounds(361, 381, 150, 40);
		panelBottom.add(btnRedefinir);
		btnRedefinir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnRedefinir.isEnabled()) {
					btnRedefinir.setBackground(new Color(180, 180, 180));
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnRedefinir.setBackground(new Color(220, 220, 220));
			}
		});
		btnRedefinir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnRedefinir.setForeground(new Color(0, 0, 0));
		btnRedefinir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnRedefinir.setFocusable(false);
		btnRedefinir.setBorder(new LineBorder(new Color(60, 60, 60), 1, true));
		btnRedefinir.setBackground(new Color(220, 220, 220));
		
		JLabel lblNascimento2 = new JLabel("Nascimento");
		lblNascimento2.setForeground(new Color(0, 0, 0));
		lblNascimento2.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNascimento2.setBorder(null);
		lblNascimento2.setBackground(Color.WHITE);
		lblNascimento2.setAlignmentX(0.5f);
		lblNascimento2.setBounds(10, 195, 73, 15);
		panelBottom.add(lblNascimento2);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblSexo.setBounds(10, 230, 50, 30);
		panelBottom.add(lblSexo);
		
		boxSexo = new JComboBox();
		boxSexo.setEditable(true);
		boxSexo.setEnabled(false);
		boxSexo.setFocusTraversalKeysEnabled(false);
		boxSexo.setFocusable(false);
		boxSexo.setForeground(new Color(0, 0, 0));
		boxSexo.setRequestFocusEnabled(false);
		boxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		boxSexo.setMaximumRowCount(2);
		boxSexo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		boxSexo.setBorder(null);
		boxSexo.setBackground(SystemColor.menu);
		boxSexo.setBounds(95, 230, 150, 30);
		panelBottom.add(boxSexo);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblCelular.setBounds(10, 280, 50, 30);
		panelBottom.add(lblCelular);
		
		fTxtCelular = new JFormattedTextField(mascaraCelular);
		fTxtCelular.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		fTxtCelular.setEnabled(false);
		fTxtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		fTxtCelular.setBackground(SystemColor.menu);
		fTxtCelular.setBounds(95, 280, 150, 30);
		panelBottom.add(fTxtCelular);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEmail.setBounds(10, 330, 50, 30);
		panelBottom.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtEmail.setEnabled(false);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtEmail.setBackground(SystemColor.menu);
		txtEmail.setBounds(95, 330, 270, 30);
		panelBottom.add(txtEmail);
		
		chckbxAdmin = new JCheckBox("Administrador");
		chckbxAdmin.setEnabled(false);
		chckbxAdmin.setFocusPainted(false);
		chckbxAdmin.setFocusable(false);
		chckbxAdmin.setRolloverEnabled(false);
		chckbxAdmin.setRequestFocusEnabled(false);
		chckbxAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxAdmin.setBounds(194, 380, 120, 40);
		panelBottom.add(chckbxAdmin);
		
		chckbxAtivo = new JCheckBox("Ativo");
		chckbxAtivo.setEnabled(false);
		chckbxAtivo.setFocusPainted(false);
		chckbxAtivo.setFocusable(false);
		chckbxAtivo.setRolloverEnabled(false);
		chckbxAtivo.setRequestFocusEnabled(false);
		chckbxAtivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		chckbxAtivo.setBounds(47, 380, 100, 40);
		panelBottom.add(chckbxAtivo);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtEditCpf.getText().length() == 14 && !txtNome.getText().isBlank() && fTxtCelular.getText().length() == 15 && !txtEmail.getText().isBlank() && fTxtNascimento.getText().length() == 10) {
					if(GenericUtils.isEmail(txtEmail.getText())) {
						Funcionario funcionarioEdita = new Funcionario();
						funcionarioEdita.setCpf(txtEditCpf.getText().replace("-", "").replace(".", ""));
						funcionarioEdita.setNome(txtNome.getText());
						funcionarioEdita.setCelular(fTxtCelular.getText().replace("(", "").replace(")", "").replace("-", "").replace(" ", ""));			
						funcionarioEdita.setEmail(txtEmail.getText());
						funcionarioEdita.setSenha(funcionarioPesquisa.getSenha());
						LocalDate data = LocalDate.parse(fTxtNascimento.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
						funcionarioEdita.setNascimento(data);
						
						if (boxSexo.getSelectedIndex() == -1) {
							funcionarioEdita.setSexo('m');
						} else {
							funcionarioEdita.setSexo('f');
						}
						
						if(chckbxAdmin.isSelected()) {
							funcionarioEdita.setAdmin(true);
						} else {
							funcionarioEdita.setAdmin(false);
						}
						
						if(chckbxAtivo.isSelected()) {
							funcionarioEdita.setAtivo(true);
						} else {
							funcionarioEdita.setAtivo(false);
						}
						if(DatabaseUtils.alterarFuncionario(funcionarioEdita, btnRedefinir.isSelected()) == true) {
							limpar();
						} else {
							
						}
					} else {
						JOptionPane.showMessageDialog(null, "Insira um email válido!");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(235, 460, 90, 30);
		panelBottom.add(btnSalvar);
		btnSalvar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSalvar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(btnSalvar.isEnabled()) {
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
		lblBackground.setIcon(new ImageIcon(IntFormAdmFuncionario.class.getResource("/com/dizimaster/img/heaven-bg.jpg")));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);
		
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Funcionario getFuncionarioPesquisa() {
		return funcionarioPesquisa;
	}

	public void setFuncionarioPesquisa(Funcionario funcionarioPesquisa) {
		this.funcionarioPesquisa = funcionarioPesquisa;
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
