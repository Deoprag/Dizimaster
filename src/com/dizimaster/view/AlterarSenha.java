package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.border.MatteBorder;

import com.dizimaster.util.DatabaseUtils;
import com.dizimaster.util.GenericUtils;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AlterarSenha extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JPasswordField txtConfSenha;
	private int yMouse, xMouse;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AlterarSenha frame = new AlterarSenha();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void mexe(int x, int y) {
		this.setLocation(x - xMouse, y - yMouse);
	}
	
	private void sair() {
		this.dispose();
	}
	
	public AlterarSenha() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelDown = new JPanel();
		panelDown.setBorder(new LineBorder(new Color(0, 0, 64)));
		panelDown.setBackground(new Color(8, 82, 180));
		panelDown.setBounds(0, 30, 450, 370);
		contentPane.add(panelDown);
		panelDown.setLayout(null);
		
		JLabel lblTitle = new JLabel("Altere sua senha!");
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 30, 430, 22);
		panelDown.add(lblTitle);
		
		txtSenha = new JPasswordField();
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtSenha.setText("");
				txtSenha.setForeground(Color.WHITE);
			}
		});
		txtSenha.setText("123456789");
		txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtSenha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 128, 255)));
		txtSenha.setBackground(new Color(8, 82, 180));
		txtSenha.setForeground(new Color(192, 192, 192));
		txtSenha.setBounds(125, 99, 200, 30);
		panelDown.add(txtSenha);
		
		JLabel lblSenha = new JLabel("Nova senha");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSenha.setBounds(175, 74, 100, 30);
		panelDown.add(lblSenha);
		
		JLabel lblConfSenha = new JLabel("Confirmar senha");
		lblConfSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfSenha.setForeground(Color.WHITE);
		lblConfSenha.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblConfSenha.setBounds(165, 140, 120, 30);
		panelDown.add(lblConfSenha);
		
		txtConfSenha = new JPasswordField();
		txtConfSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtConfSenha.setText("");
				txtConfSenha.setForeground(Color.WHITE);
			}
		});
		txtConfSenha.setText("123456789");
		txtConfSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtConfSenha.setForeground(new Color(192, 192, 192));
		txtConfSenha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 128, 255)));
		txtConfSenha.setBackground(new Color(8, 82, 180));
		txtConfSenha.setBounds(125, 165, 200, 30);
		panelDown.add(txtConfSenha);
		
		JLabel lblRequisitos = new JLabel("Requisitos de senha:\r\n");
		lblRequisitos.setForeground(new Color(255, 255, 255));
		lblRequisitos.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblRequisitos.setVerticalTextPosition(SwingConstants.TOP);
		lblRequisitos.setVerticalAlignment(SwingConstants.TOP);
		lblRequisitos.setBounds(50, 219, 350, 22);
		panelDown.add(lblRequisitos);
		
		JLabel lblRequisitos1 = new JLabel("* +8 Caracteres");
		lblRequisitos1.setForeground(new Color(255, 255, 255));
		lblRequisitos1.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblRequisitos1.setBounds(50, 230, 350, 22);
		panelDown.add(lblRequisitos1);
		
		JLabel lblRequisitos2 = new JLabel("* No mínimo 1 letra, 1 número e 1 caractere especial (!@#$%&*)");
		lblRequisitos2.setForeground(new Color(255, 255, 255));
		lblRequisitos2.setFont(new Font("Segoe UI", Font.PLAIN, 10));
		lblRequisitos2.setBounds(50, 245, 350, 22);
		panelDown.add(lblRequisitos2);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (GenericUtils.reqSenha(txtSenha.getText()) == true) {
					
				} else {
					JOptionPane.showMessageDialog(null, "Sua senha não cumpre os requisitos mínimos do sistema!");
				}
//				@SuppressWarnings("deprecation")
//				String password = txtSenha.getText();
//				@SuppressWarnings("deprecation")
//				String confPassword = txtConfSenha.getText();
//				if (password.length() >= 8) {
//					
//				} else {
//					JOptionPane.showMessageDialog(null, "Sua senha precisa de no mínimo 8 caracteres!");
//				}
//				
//				if (password.equals(confPassword)) {			
//					if (DatabaseUtils.alterarSenha(user, password)== true) {
//						JOptionPane.showMessageDialog(null, "Senha Alterada com sucesso!");
//					}
//				} else {
//					JOptionPane.showMessageDialog(null, "As senhas inseridas são diferentes!");
//				}
			}
		});
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviar.setBackground(new Color(0, 0, 64));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnEnviar.setBackground(new Color(0, 0, 128));
			}
		});
		btnEnviar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setBackground(new Color(0, 0, 128));
		btnEnviar.setBorder(null);
		btnEnviar.setBounds(165, 290, 120, 40);
		panelDown.add(btnEnviar);
		
		JPanel panelUpBar = new JPanel();
		panelUpBar.setBounds(0, 0, 450, 30);
		contentPane.add(panelUpBar);
		panelUpBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				mexe(x, y);
			}
		});
		panelUpBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				yMouse = e.getY();
				xMouse = e.getX();
			}
		});
		panelUpBar.setBorder(null);
		panelUpBar.setBackground(new Color(0, 0, 64));
		panelUpBar.setLayout(null);
		
		JPanel btnSair = new JPanel();
		btnSair.setBackground(new Color(234, 0, 0));
		btnSair.setBounds(420, 0, 30, 30);
		panelUpBar.add(btnSair);
		btnSair.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("X");
		lblNewLabel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sair();
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSair.setBackground(new Color(200, 0, 0));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSair.setBackground(new Color(234, 0, 0));
			}
			
		});
		lblNewLabel_2.setBorder(new MatteBorder(1, 0, 0, 1, (Color) new Color(0, 0, 64)));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 30, 30);
		btnSair.add(lblNewLabel_2);
	}
}
