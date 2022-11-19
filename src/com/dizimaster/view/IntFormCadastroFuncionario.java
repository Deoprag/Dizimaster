package com.dizimaster.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.dizimaster.util.DatabaseUtils;
import com.dizimaster.util.GenericUtils;
import com.dizimaster.util.TxtNome;

import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

@SuppressWarnings("serial")
public class IntFormCadastroFuncionario extends JInternalFrame {
	private JTextField txtEmail;
	private JTextField txtConfEmail;
	private JTextField txtNome;
	private JCheckBox chckbxAdmin;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormCadastroFuncionario frame = new IntFormCadastroFuncionario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void voltar() {
		this.dispose();
	}

	@SuppressWarnings("rawtypes")
	public class MyCellRenderer implements ListCellRenderer {
		protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected,
					cellHasFocus);
			if (isSelected) {
				renderer.setBackground(new Color(30,170,200));
			}
			return renderer;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IntFormCadastroFuncionario() {
		setBorder(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);

		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(335, 34, 350, 570);
		getContentPane().add(panelCadastro);
		MaskFormatter mascaraCpf = null;
		MaskFormatter mascaraNumero = null;
		MaskFormatter mascaraNascimento = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraNumero = new MaskFormatter("(##) #####-####");
			mascaraNascimento = new MaskFormatter("##/##/####");
			mascaraCpf.setPlaceholderCharacter('*');
			mascaraNumero.setPlaceholderCharacter('*');
			mascaraNascimento.setPlaceholderCharacter('*');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}

		JButton btnSair = new JButton("VOLTAR");
		btnSair.setFocusable(false);
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
		
		chckbxAdmin = new JCheckBox("Administrador");
		chckbxAdmin.setRequestFocusEnabled(false);
		chckbxAdmin.setFocusPainted(false);
		chckbxAdmin.setFocusable(false);
		chckbxAdmin.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		chckbxAdmin.setForeground(new Color(255, 255, 255));
		chckbxAdmin.setBackground(new Color(25, 120, 150));
		chckbxAdmin.setFont(new Font("Segoe UI", Font.BOLD, 12));
		chckbxAdmin.setBounds(208, 440, 105, 27);
		panelCadastro.add(chckbxAdmin);
		btnSair.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(56, 510, 90, 40);
		panelCadastro.add(btnSair);

		JLabel lblNascimento = new JLabel("Data de Nascimento");
		lblNascimento.setForeground(Color.WHITE);
		lblNascimento.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNascimento.setBorder(null);
		lblNascimento.setBackground(Color.WHITE);
		lblNascimento.setAlignmentX(0.5f);
		lblNascimento.setBounds(16, 320, 150, 24);
		panelCadastro.add(lblNascimento);

		JFormattedTextField fTxtNascimento = new JFormattedTextField(mascaraNascimento);
		fTxtNascimento.setForeground(new Color(255, 255, 255));
		fTxtNascimento.setBounds(16, 340, 150, 30);
		fTxtNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtNascimento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		fTxtNascimento.setBackground(new Color(25, 120, 150));
		panelCadastro.add(fTxtNascimento);

		JFormattedTextField fTxtCpf = new JFormattedTextField(mascaraCpf);
		fTxtCpf.setForeground(new Color(255, 255, 255));
		fTxtCpf.setBounds(16, 290, 150, 30);
		fTxtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		fTxtCpf.setBackground(new Color(25, 120, 150));
		panelCadastro.add(fTxtCpf);

		JFormattedTextField fTxtCelular = new JFormattedTextField(mascaraNumero);
		fTxtCelular.setForeground(new Color(255, 255, 255));
		fTxtCelular.setBounds(16, 390, 150, 30);
		fTxtCelular.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtCelular.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		fTxtCelular.setBackground(new Color(25, 120, 150));
		panelCadastro.add(fTxtCelular);

		JComboBox boxSexo = new JComboBox();
		boxSexo.setForeground(new Color(0, 0, 0));
		boxSexo.setRequestFocusEnabled(false);
		boxSexo.setModel(new DefaultComboBoxModel(new String[] { "Masculino", "Feminino" }));
		boxSexo.setMaximumRowCount(2);
		boxSexo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		boxSexo.setRenderer(new MyCellRenderer());
		boxSexo.setBorder(null);
		boxSexo.setBackground(new Color(240, 240, 240));
		boxSexo.setBounds(182, 340, 150, 30);
		panelCadastro.add(boxSexo);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblSexo.setBorder(null);
		lblSexo.setBackground(Color.WHITE);
		lblSexo.setAlignmentX(0.5f);
		lblSexo.setBounds(182, 320, 150, 24);
		panelCadastro.add(lblSexo);

		JLabel lblTitulo = new JLabel("Cadastro de Funcionários");
		lblTitulo.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblTitulo.setBackground(new Color(128, 128, 128));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setBounds(56, 220, 240, 35);
		panelCadastro.add(lblTitulo);

		JLabel lblEmail = new JLabel("Endereço de Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(182, 370, 150, 24);
		panelCadastro.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setForeground(new Color(255, 255, 255));
		txtEmail.setToolTipText("Endereço de Email");
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtEmail.setBackground(new Color(25, 120, 150));
		txtEmail.setBounds(182, 390, 150, 30);
		panelCadastro.add(txtEmail);

		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenericUtils.openWebpage("https://www.instagram.com/deopraglabs");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(
						new ImageIcon(IntFormCadastroFuncionario.class.getResource("/com/dizimaster/img/logo-hold-small.png")));

			}

			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(IntFormCadastroFuncionario.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.setIcon(new ImageIcon(IntFormCadastroFuncionario.class.getResource("/com/dizimaster/img/logo-small.png")));
		lblLogo.setBounds(100, 20, 150, 150);
		panelCadastro.add(lblLogo);

		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setFocusable(false);
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fTxtCpf.getText().replaceAll(" ", "").length() == 14 && 
						!txtNome.getText().isBlank() && 
						fTxtNascimento.getText().replaceAll(" ", "").length() == 10 &&
						fTxtCelular.getText().replaceAll(" ", "").length() == 14 	) {
						if (GenericUtils.isCPF(fTxtCpf.getText().replace(".", "").replace("-", "")) == true) {
							if (txtEmail.getText().equals(txtConfEmail.getText())) {
								if(GenericUtils.isEmail(txtEmail.getText()) == true) {
									String sexo = (boxSexo.getSelectedIndex() == 0 ? "m" : "f");
									boolean admin;
									if	(chckbxAdmin.isSelected()) {
										admin = true;
									} else {
										admin = false;
									}
									if (DatabaseUtils.cadastroFuncionario(fTxtCpf.getText(), txtNome.getText(), fTxtNascimento.getText(), sexo, fTxtCelular.getText(), txtEmail.getText(), admin) == true) {
										fTxtCpf.setText("");
										txtNome.setText("");
										fTxtNascimento.setText("");
										fTxtCelular.setText("");
										txtEmail.setText("");
										txtConfEmail.setText("");
									}
								} else {
									JOptionPane.showMessageDialog(null, "Email Inválido!");
								}
							} else {
								JOptionPane.showMessageDialog(null, "Verifique os emails digitados e tente novamente!");
							}
						} else {
							JOptionPane.showMessageDialog(null, "CPF Inválido!");
						}
				} else {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
			}
		});
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(0, 122, 152));
		btnEnviar.setBounds(202, 510, 90, 40);
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
		panelCadastro.add(btnEnviar);

		JLabel lblConfEmail = new JLabel("Confirmação de Email");
		lblConfEmail.setForeground(Color.WHITE);
		lblConfEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblConfEmail.setAlignmentX(0.5f);
		lblConfEmail.setBounds(16, 420, 150, 24);
		panelCadastro.add(lblConfEmail);

		txtConfEmail = new JTextField();
		txtConfEmail.setForeground(new Color(255, 255, 255));
		txtConfEmail.setToolTipText("Confirmação de Email");
		txtConfEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtConfEmail.setColumns(10);
		txtConfEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtConfEmail.setBackground(new Color(25, 120, 150));
		txtConfEmail.setBounds(16, 440, 150, 30);
		panelCadastro.add(txtConfEmail);
		txtConfEmail.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnEnviar.doClick();
				}
			}
		});

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCpf.setBorder(null);
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setAlignmentX(0.5f);
		lblCpf.setBounds(16, 270, 150, 24);
		panelCadastro.add(lblCpf);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNome.setBorder(null);
		lblNome.setBackground(Color.WHITE);
		lblNome.setAlignmentX(0.5f);
		lblNome.setBounds(182, 270, 150, 24);
		panelCadastro.add(lblNome);

		txtNome = new TxtNome(100);
		txtNome.setForeground(new Color(255, 255, 255));
		txtNome.setToolTipText("Nome");
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtNome.setBackground(new Color(25, 120, 150));
		txtNome.setBounds(182, 290, 150, 30);
		panelCadastro.add(txtNome);

		JLabel lblCelular = new JLabel("Número de Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCelular.setBorder(null);
		lblCelular.setBackground(Color.WHITE);
		lblCelular.setAlignmentX(0.5f);
		lblCelular.setBounds(16, 370, 150, 24);
		panelCadastro.add(lblCelular);

		JLabel lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblBackgroundPanel
				.setIcon(new ImageIcon(IntFormCadastroFuncionario.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBounds(0, 0, 350, 570);
		panelCadastro.add(lblBackgroundPanel);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(IntFormCadastroFuncionario.class.getResource("/com/dizimaster/img/church-bg.png")));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);

	}
}
