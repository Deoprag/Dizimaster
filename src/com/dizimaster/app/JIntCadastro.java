package com.dizimaster.app;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
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

import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

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
	
	@SuppressWarnings("rawtypes")
	public class MyCellRenderer implements ListCellRenderer{
        
	    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
	        @Override
		public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus){
			JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
	            isSelected, cellHasFocus);
	            if(isSelected){
	                renderer.setBackground(new Color(237, 119, 64));
	            }
			return renderer;
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
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
		MaskFormatter mascaraNascimento = null;
		MaskFormatter mascaraSalario = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraNumero = new MaskFormatter("(##)#####-####");
			mascaraNascimento = new MaskFormatter("##/##/####");
			mascaraSalario = new MaskFormatter("R$####.##");
			mascaraCpf.setPlaceholderCharacter('*');
			mascaraNumero.setPlaceholderCharacter('*');
			mascaraNascimento.setPlaceholderCharacter('*');
			mascaraSalario.setPlaceholderCharacter('*');
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		
		JLabel lblSalario = new JLabel("Salário");
		lblSalario.setForeground(Color.WHITE);
		lblSalario.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblSalario.setBorder(null);
		lblSalario.setBackground(Color.WHITE);
		lblSalario.setAlignmentX(0.5f);
		lblSalario.setBounds(182, 370, 150, 24);
		panelCadastro.add(lblSalario);
		
		JLabel lblNascimento = new JLabel("Data de Nascimento");
		lblNascimento.setForeground(Color.WHITE);
		lblNascimento.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNascimento.setBorder(null);
		lblNascimento.setBackground(Color.WHITE);
		lblNascimento.setAlignmentX(0.5f);
		lblNascimento.setBounds(16, 320, 150, 24);
		panelCadastro.add(lblNascimento);
		
		JFormattedTextField fTxtSalario = new JFormattedTextField(mascaraSalario);
		fTxtSalario.setBounds(182, 390, 150, 30);
		fTxtSalario.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtSalario.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		fTxtSalario.setBackground(new Color(254, 213, 150));
		panelCadastro.add(fTxtSalario);
		
		JFormattedTextField fTxtNascimento = new JFormattedTextField(mascaraNascimento);
		fTxtNascimento.setBounds(16, 340, 150, 30);
		fTxtNascimento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtNascimento.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		fTxtNascimento.setBackground(new Color(254, 213, 150));
		panelCadastro.add(fTxtNascimento);
		
		JFormattedTextField fTxtCpf = new JFormattedTextField(mascaraCpf);
		fTxtCpf.setBounds(16, 290, 150, 30);
		fTxtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtCpf.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		fTxtCpf.setBackground(new Color(254, 213, 150));
		panelCadastro.add(fTxtCpf);
		
		JFormattedTextField fTxtCelular = new JFormattedTextField(mascaraNumero);
		fTxtCelular.setBounds(16, 390, 150, 30);
		fTxtCelular.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtCelular.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		fTxtCelular.setBackground(new Color(254, 213, 150));
		panelCadastro.add(fTxtCelular);

		JComboBox boxSexo = new JComboBox();
		boxSexo.setFocusTraversalKeysEnabled(false);
		boxSexo.setRequestFocusEnabled(false);
		boxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		boxSexo.setMaximumRowCount(2);
		boxSexo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		boxSexo.setRenderer(new MyCellRenderer());
		boxSexo.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		boxSexo.setBackground(new Color(254, 213, 150));
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
		lblEmail.setBounds(16, 420, 150, 24);
		panelCadastro.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setToolTipText("Endereço de Email");
		txtEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtEmail.setBackground(new Color(254, 213, 150));
		txtEmail.setBounds(16, 440, 150, 30);
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
				if (txtEmail.getText().equals(txtConfEmail.getText())) {
					String sexo = (boxSexo.getSelectedIndex() == 0 ? "m" : "f");
					if (DatabaseUtils.cadastro(fTxtCpf.getText(), txtNome.getText(), fTxtNascimento.getText(), sexo, fTxtCelular.getText(), fTxtSalario.getText(), txtEmail.getText()) == true) {
						// SETAR OS CAMPOS VAZIOS
					}
				} else {
					JOptionPane.showMessageDialog(null, "ERRO! Verifique o email digitado e tente novamente!");
				}
			}
		});
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
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
		lblConfEmail.setBounds(182, 420, 150, 24);
		panelCadastro.add(lblConfEmail);
		
		txtConfEmail = new JTextField();
		txtConfEmail.setToolTipText("Confirmação de Email");
		txtConfEmail.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtConfEmail.setColumns(10);
		txtConfEmail.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		txtConfEmail.setBackground(new Color(254, 213, 150));
		txtConfEmail.setBounds(182, 440, 150, 30);
		panelCadastro.add(txtConfEmail);
		
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
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Nome");
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
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
		lblCelular.setBounds(16, 370, 150, 24);
		panelCadastro.add(lblCelular);
		
		JLabel lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblBackgroundPanel.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBounds(0, 0, 350, 570);
		panelCadastro.add(lblBackgroundPanel);
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Segoe UI", Font.BOLD, 10));
		lblDeopragLabs.setBounds(0, 0, 90, 25);
		getContentPane().add(lblDeopragLabs);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(JIntCadastro.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);

	}
}
