package com.dizimaster.app;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import com.dizimaster.conexao.ConexaoDB;

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.ComponentOrientation;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class JIntCadastro extends JInternalFrame {
	private JTextField txtEmail;
	private JTextField txtConfEmail;
	private JTextField txtNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIntCadastro frame = new JIntCadastro();
					frame.setVisible(true);
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
	
	public JIntCadastro() {
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
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraNumero = new MaskFormatter("(##)#####-####");
			mascaraCpf.setPlaceholderCharacter('*');
			mascaraNumero.setPlaceholderCharacter('*');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		JFormattedTextField fTxtCpf = new JFormattedTextField(mascaraCpf);
		fTxtCpf.setBounds(16, 290, 150, 30);
		panelCadastro.add(fTxtCpf);
		
		JFormattedTextField fTxtNum = new JFormattedTextField(mascaraNumero);
		fTxtNum.setBounds(182, 352, 150, 30);
		panelCadastro.add(fTxtNum);

		JComboBox boxSexo = new JComboBox();
		boxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		boxSexo.setMaximumRowCount(2);
		boxSexo.setFont(new Font("Rubik", Font.PLAIN, 12));
		boxSexo.setBounds(16, 350, 150, 30);
		panelCadastro.add(boxSexo);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblSexo.setBorder(null);
		lblSexo.setBackground(Color.WHITE);
		lblSexo.setAlignmentX(0.5f);
		lblSexo.setBounds(16, 330, 150, 24);
		panelCadastro.add(lblSexo);
		
		JLabel lblTitulo = new JLabel("Cadastro de Funcionários");
		lblTitulo.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblTitulo.setBackground(new Color(128, 128, 128));
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Rubik", Font.BOLD, 16));
		lblTitulo.setBounds(56, 220, 240, 35);
		panelCadastro.add(lblTitulo);
		
		JLabel lblEmail = new JLabel("Endereço de Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblEmail.setAlignmentX(0.5f);
		lblEmail.setBounds(16, 390, 150, 24);
		panelCadastro.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Endereço de Email");
		txtEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtEmail.setBackground(new Color(254, 213, 150));
		txtEmail.setBounds(16, 410, 150, 30);
		panelCadastro.add(txtEmail);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openWebpage("https://www.instagram.com/deopraglabs");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/logo-hold-small.png")));

			}
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/logo-small.png")));
		lblLogo.setBounds(100, 20, 150, 150);
		panelCadastro.add(lblLogo);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = ConexaoDB.conecta();
					String sql = "insert into funcionario(cpf, nome, sexo, celular, email, senha) values (?,?,?,?,?,?)";
					
					PreparedStatement stmt = con.prepareCall(sql);
					
					stmt.setString(1, fTxtCpf.getText().replace(".", "").replace("-", ""));
					stmt.setString(2, txtNome.getText());
					if (boxSexo.getSelectedIndex() == 0) {
						stmt.setString(3, "m");
					} else if (boxSexo.getSelectedIndex() == 1) {
						stmt.setString(3, "f");
					}
					stmt.setString(4, fTxtNum.getText().replace("(", "").replace(")", "").replace("-", ""));
					if (txtEmail.getText().equals(txtConfEmail.getText())) {
						stmt.setString(5, txtEmail.getText());
					} else {
						
					}
					stmt.setString(6, "dizi@2022");
					
					stmt.execute();
					stmt.close();
					con.close();
					
					JOptionPane.showMessageDialog(null, "Funcionário cadastrado com sucesso!");
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Não foi possível cadastrar funcionário!");
				}

			}
		});
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Rubik", Font.BOLD, 15));
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(0, 122, 152));
		btnEnviar.setBounds(100, 485, 150, 55);
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
		lblConfEmail.setBounds(182, 390, 150, 24);
		panelCadastro.add(lblConfEmail);
		
		txtConfEmail = new JTextField();
		txtConfEmail.setToolTipText("Confirmação de Email");
		txtConfEmail.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtConfEmail.setColumns(10);
		txtConfEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtConfEmail.setBackground(new Color(254, 213, 150));
		txtConfEmail.setBounds(182, 410, 150, 30);
		panelCadastro.add(txtConfEmail);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCpf.setBorder(null);
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setAlignmentX(0.5f);
		lblCpf.setBounds(16, 270, 150, 24);
		panelCadastro.add(lblCpf);
		
		JLabel lblNomeFunc = new JLabel("Nome");
		lblNomeFunc.setForeground(Color.WHITE);
		lblNomeFunc.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNomeFunc.setBorder(null);
		lblNomeFunc.setBackground(Color.WHITE);
		lblNomeFunc.setAlignmentX(0.5f);
		lblNomeFunc.setBounds(182, 270, 150, 24);
		panelCadastro.add(lblNomeFunc);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Nome");
		txtNome.setFont(new Font("Rubik", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtNome.setBackground(new Color(254, 213, 150));
		txtNome.setBounds(182, 290, 150, 30);
		panelCadastro.add(txtNome);
		
		JLabel lblCelular = new JLabel("Número de Celular");
		lblCelular.setForeground(Color.WHITE);
		lblCelular.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCelular.setBorder(null);
		lblCelular.setBackground(Color.WHITE);
		lblCelular.setAlignmentX(0.5f);
		lblCelular.setBounds(182, 330, 150, 24);
		panelCadastro.add(lblCelular);
		
		JLabel lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblBackgroundPanel.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBounds(0, 0, 350, 570);
		panelCadastro.add(lblBackgroundPanel);
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Rubik", Font.BOLD, 10));
		lblDeopragLabs.setBounds(0, 0, 90, 25);
		getContentPane().add(lblDeopragLabs);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);

	}
}
