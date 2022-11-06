package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

import com.dizimaster.util.DatabaseUtils;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
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

@SuppressWarnings("serial")
public class IntFormDizimo extends JInternalFrame {
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
		
		JXComboBox comboNome = new JXComboBox();
		comboNome.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		comboNome.setBackground(new Color(252, 201, 131));
		comboNome.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		comboNome.setModel(new DefaultComboBoxModel(new String[] {""}));
		comboNome.setEditable(true);
		comboNome.setBounds(176, 287, 150, 30);
		panelCadastro.add(comboNome);
		DatabaseUtils.dadosComboNome(comboNome);
		AutoCompleteDecorator.decorate(comboNome);
		
		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setForeground(Color.WHITE);
		lblCpf.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblCpf.setBorder(null);
		lblCpf.setBackground(Color.WHITE);
		lblCpf.setAlignmentX(0.5f);
		lblCpf.setBounds(16, 266, 150, 24);
		panelCadastro.add(lblCpf);
		
		JFormattedTextField fTxtCpf = new JFormattedTextField((AbstractFormatter) null);
		fTxtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		fTxtCpf.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(102, 51, 0), new Color(204, 153, 51)));
		fTxtCpf.setBackground(new Color(254, 213, 150));
		fTxtCpf.setBounds(16, 286, 150, 30);
		panelCadastro.add(fTxtCpf);
		
		JButton btnSair = new JButton("VOLTAR");
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
