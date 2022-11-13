package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.dizimaster.model.Dizimista;
import com.dizimaster.util.DatabaseUtils;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JLabel;
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
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class IntFormDizimo extends JInternalFrame {
	
	private JTextField txtCpf;
	private JTextField txtNome;
	private JTextField txtValor;
	private int funcionario;
	
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

	/**
	 * Create the frame.
	 */
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
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 384, 150, 100);
		scrollPane.setBorder(null);
		panelCadastro.add(scrollPane);
		
		JTextArea txtObs = new JTextArea();
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
		txtObs.setMargin(new Insets(0,0,0,0));
		txtObs.setForeground(new Color(192, 192, 192));
		txtObs.setText("Insira aqui sua observação");
		txtObs.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtObs.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)), new EmptyBorder(2, 5, 2, 5)));
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
		btnSearch.setBounds(225, 263, 25, 25);
		btnSearch.setBorder(null);
		btnSearch.setBorderPainted(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setRequestFocusEnabled(false);
		btnSearch.setFocusable(false);
		btnSearch.setBackground(new Color(25, 120, 150));
		panelCadastro.add(btnSearch);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/find-icon.png")));
		
		JTextField txtValor = new JTextField();
		txtValor.setBounds(100, 340, 150, 30);
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
		
		txtNome = new JTextField();
		txtNome.setBounds(100, 299, 150, 30);
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
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBounds(100, 258, 125, 30);
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
		lblNome.setBounds(53, 299, 63, 24);
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNome.setBorder(null);
		lblNome.setBackground(Color.WHITE);
		lblNome.setAlignmentX(0.5f);
		panelCadastro.add(lblNome);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(53, 263, 60, 24);
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCpf.setBorder(null);
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setAlignmentX(0.5f);
		panelCadastro.add(lblCpf);
		
		JButton btnSair = new JButton("VOLTAR");
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
		lblLogo.setBounds(100, 20, 150, 150);
		lblLogo.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/logo-small.png")));
		panelCadastro.add(lblLogo);
		
		JButton btnEnviar = new JButton("REGISTRAR");
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
				try {
					Dizimista dizimista;
					dizimista = DatabaseUtils.procurarDizimista(txtCpf.getText().replace("-", "").replace(".", ""));

					txtNome.setForeground(Color.WHITE);
					txtValor.setForeground(Color.WHITE);
					
					txtNome.setText(dizimista.getNome());
					DecimalFormat df = new DecimalFormat("0.00");
					txtValor.setText("R$ " + df.format(dizimista.getSalario() / 10).replace(".", ","));
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/find-icon-hold.png")));
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

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
}
