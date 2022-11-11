package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.text.MaskFormatter;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.dizimaster.model.Dizimista;
import com.dizimaster.util.DatabaseUtils;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.text.ParseException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.DefaultComboBoxModel;
import java.awt.Cursor;

import org.jdesktop.swingx.JXComboBox;
import org.jdesktop.swingx.JXCollapsiblePane;
import org.jdesktop.swingx.painter.TextPainter;
import org.jdesktop.swingx.painter.RectanglePainter;
import org.jdesktop.swingx.painter.ShapePainter;
import org.jdesktop.swingx.JXTextField;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class IntFormDizimo extends JInternalFrame {
	private JTextField txtCpf;
	private JTextField txtNome;
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
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);
		
		JPanel panelCadastro = new JPanel();
		panelCadastro.setLayout(null);
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(335, 34, 350, 570);
		getContentPane().add(panelCadastro);
		
		JTextField txtValor = new JTextField();
		txtValor.setForeground(new Color(255, 255, 255));
		txtValor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtValor.setColumns(10);
		txtValor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtValor.setBackground(new Color(25, 120, 150));
		txtValor.setBounds(100, 340, 150, 30);
		panelCadastro.add(txtValor);
		
		JLabel lblNome_2_1 = new JLabel("Valor");
		lblNome_2_1.setForeground(Color.WHITE);
		lblNome_2_1.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNome_2_1.setBorder(null);
		lblNome_2_1.setBackground(Color.WHITE);
		lblNome_2_1.setAlignmentX(0.5f);
		lblNome_2_1.setBounds(53, 340, 63, 24);
		panelCadastro.add(lblNome_2_1);
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(255, 255, 255));
		txtNome.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtNome.setBackground(new Color(25, 120, 150));
		txtNome.setBounds(100, 299, 150, 30);
		panelCadastro.add(txtNome);
		
		JPanel panelSearch = new JPanel();
		panelSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panelSearch.setBackground(new Color(25, 120, 150));
		panelSearch.setBounds(225, 263, 25, 25);
		panelCadastro.add(panelSearch);
		panelSearch.setLayout(null);
		
		JLabel lblSearch = new JLabel("");
		lblSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Dizimista dizimista;
					dizimista = DatabaseUtils.procurarDizimista(txtCpf.getText().replace("-", "").replace(".", ""));
					txtNome.setText(dizimista.getNome());
					float valor = dizimista.getSalario() / 10;
					txtValor.setText("R$ " + String.valueOf(valor));
				} catch(Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		lblSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblSearch.setBounds(0, 0, 25, 25);
		panelSearch.add(lblSearch);
		lblSearch.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/find-icon.png")));
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setForeground(new Color(255, 255, 255));
		txtCpf.setText("00000000000");
		txtCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtCpf.setBackground(new Color(25, 120, 150));
		txtCpf.setBounds(100, 258, 125, 30);
		panelCadastro.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNome_2 = new JLabel("Nome");
		lblNome_2.setForeground(Color.WHITE);
		lblNome_2.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNome_2.setBorder(null);
		lblNome_2.setBackground(Color.WHITE);
		lblNome_2.setAlignmentX(0.5f);
		lblNome_2.setBounds(53, 299, 63, 24);
		panelCadastro.add(lblNome_2);
		
		JLabel lblNome = new JLabel("CPF");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblNome.setBorder(null);
		lblNome.setBackground(Color.WHITE);
		lblNome.setAlignmentX(0.5f);
		lblNome.setBounds(56, 260, 60, 24);
		panelCadastro.add(lblNome);
		
		JButton btnSair = new JButton("VOLTAR");
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(56, 495, 90, 40);
		panelCadastro.add(btnSair);
		
		JLabel lblTitulo = new JLabel("Dízimo");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblTitulo.setBackground(Color.GRAY);
		lblTitulo.setBounds(55, 200, 240, 35);
		panelCadastro.add(lblTitulo);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/logo-small.png")));
		lblLogo.setBounds(100, 20, 150, 150);
		panelCadastro.add(lblLogo);
		
		JButton btnEnviar = new JButton("ENVIAR");
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.setForeground(Color.WHITE);
		btnEnviar.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		btnEnviar.setFocusable(false);
		btnEnviar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		btnEnviar.setBackground(new Color(0, 122, 152));
		btnEnviar.setBounds(202, 495, 90, 40);
		panelCadastro.add(btnEnviar);
		
		JLabel lblBackgroundPanel = new JLabel("");
		lblBackgroundPanel.setIcon(new ImageIcon(IntFormDizimo.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		lblBackgroundPanel.setBounds(0, 0, 350, 570);
		panelCadastro.add(lblBackgroundPanel);
		
		JLabel lblBackground = new JLabel("");
		lblBackground.setBackground(new Color(66, 174, 193));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
	}
}
