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

import com.dizimaster.dao.DBConnection;
import com.dizimaster.dao.FuncionarioDAO;
import com.dizimaster.model.Funcionario;
import com.dizimaster.util.Util;

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

public class FormAlterarSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField txtSenha;
	private JPasswordField txtConfSenha;
	private Funcionario funcionario;
	private int yMouse, xMouse;
	private Util util = new Util();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormAlterarSenha frame = new FormAlterarSenha();
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

	public FormAlterarSenha() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelDown = new JPanel();
		panelDown.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelDown.setBackground(new Color(8, 82, 180));
		panelDown.setBounds(0, 30, 450, 409);
		contentPane.add(panelDown);
		panelDown.setLayout(null);

		JLabel lblTitle = new JLabel("Altere sua senha!");
		lblTitle.setBorder(null);
		lblTitle.setForeground(new Color(255, 255, 255));
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(107, 11, 235, 22);
		panelDown.add(lblTitle);

		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtSenha.setText("");
				txtSenha.setForeground(Color.WHITE);
			}
		});
		txtSenha.setText("123456789");
		txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtSenha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 64)));
		txtSenha.setBackground(new Color(8, 82, 180));
		txtSenha.setForeground(new Color(128, 128, 128));
		txtSenha.setBounds(125, 69, 200, 30);
		panelDown.add(txtSenha);

		JLabel lblSenha = new JLabel("Nova senha");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblSenha.setBounds(175, 44, 100, 30);
		panelDown.add(lblSenha);

		JLabel lblConfSenha = new JLabel("Confirmar senha");
		lblConfSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfSenha.setForeground(Color.WHITE);
		lblConfSenha.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblConfSenha.setBounds(165, 110, 120, 30);
		panelDown.add(lblConfSenha);

		txtConfSenha = new JPasswordField();
		txtConfSenha.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		txtConfSenha.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtConfSenha.setText("");
				txtConfSenha.setForeground(Color.WHITE);
			}
		});
		txtConfSenha.setText("123456789");
		txtConfSenha.setHorizontalAlignment(SwingConstants.LEFT);
		txtConfSenha.setForeground(new Color(128, 128, 128));
		txtConfSenha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 64)));
		txtConfSenha.setBackground(new Color(8, 82, 180));
		txtConfSenha.setBounds(125, 135, 200, 30);
		panelDown.add(txtConfSenha);

		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if (util.reqSenha(txtSenha.getText(), txtConfSenha.getText(), funcionario.getSenha()) == true) {
					if (FuncionarioDAO.alterarSenha(funcionario.getCpf(), funcionario.getSenha(), txtSenha.getText()) == true) {
						JOptionPane.showMessageDialog(null,
								"Senha alterada com sucesso! Realize seu login com a nova senha.");
						sair();
					}
				}
			}
		});
		btnEnviar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEnviar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnEnviar.setBackground(new Color(0, 0, 128));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnEnviar.setBackground(new Color(0, 0, 64));
			}
		});
		btnEnviar.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnEnviar.setForeground(new Color(255, 255, 255));
		btnEnviar.setBackground(new Color(0, 0, 64));
		btnEnviar.setBorder(new LineBorder(new Color(255, 255, 255)));
		btnEnviar.setBounds(165, 358, 120, 40);
		panelDown.add(btnEnviar);

		JPanel panelRequisitos = new JPanel();
		panelRequisitos.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelRequisitos.setBorder(new LineBorder(new Color(255, 255, 255)));
		panelRequisitos.setBackground(new Color(0, 0, 64));
		panelRequisitos.setBounds(75, 176, 300, 171);
		panelDown.add(panelRequisitos);
		panelRequisitos.setLayout(null);

		JLabel lblRequisitos2 = new JLabel("* No mínimo 1 letra, 1 número e 1 caractere especial");
		lblRequisitos2.setBounds(14, 32, 272, 22);
		panelRequisitos.add(lblRequisitos2);
		lblRequisitos2.setForeground(new Color(255, 255, 255));
		lblRequisitos2.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		JLabel lblRequisitos1 = new JLabel("* 8-32 Caracteres");
		lblRequisitos1.setBounds(14, 5, 272, 22);
		panelRequisitos.add(lblRequisitos1);
		lblRequisitos1.setForeground(new Color(255, 255, 255));
		lblRequisitos1.setFont(new Font("Segoe UI", Font.PLAIN, 11));

		JLabel lblExDizimaster = new JLabel("* Exemplo: dizimaster@2022");
		lblExDizimaster.setForeground(Color.WHITE);
		lblExDizimaster.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblExDizimaster.setBounds(14, 98, 272, 22);
		panelRequisitos.add(lblExDizimaster);

		JLabel lblDiferenteDa = new JLabel("* Diferente da senha atual");
		lblDiferenteDa.setForeground(Color.WHITE);
		lblDiferenteDa.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		lblDiferenteDa.setBounds(14, 65, 272, 22);
		panelRequisitos.add(lblDiferenteDa);
		
		JLabel lblCaracteresEspeciaisPermitidos = new JLabel("* Caracteres especiais permitidos: ");
		lblCaracteresEspeciaisPermitidos.setBounds(14, 125, 174, 22);
		panelRequisitos.add(lblCaracteresEspeciaisPermitidos);
		lblCaracteresEspeciaisPermitidos.setForeground(Color.WHITE);
		lblCaracteresEspeciaisPermitidos.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		
		JLabel lblCaracteresEspeciaisPermitidos_1 = new JLabel("[]{}()*-+=.:;/|\\\\?!@#$%&*");
		lblCaracteresEspeciaisPermitidos_1.setForeground(Color.WHITE);
		lblCaracteresEspeciaisPermitidos_1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		lblCaracteresEspeciaisPermitidos_1.setBounds(191, 125, 109, 22);
		panelRequisitos.add(lblCaracteresEspeciaisPermitidos_1);

		JPanel panelUpBar = new JPanel();
		panelUpBar.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelUpBar.setBounds(0, 0, 450, 30);
		contentPane.add(panelUpBar);
		panelUpBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				yMouse = e.getY();
				xMouse = e.getX();
			}
		});
		panelUpBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				mexe(x, y);
			}
		});
		panelUpBar.setBorder(null);
		panelUpBar.setBackground(new Color(62, 62, 62));
		panelUpBar.setLayout(null);

		JPanel btnSair = new JPanel();
		btnSair.setBackground(new Color(234, 0, 0));
		btnSair.setBounds(420, 0, 30, 30);
		panelUpBar.add(btnSair);
		btnSair.setLayout(null);

		JLabel lblX = new JLabel("X");
		lblX.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblX.addMouseListener(new MouseAdapter() {
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
		lblX.setBorder(null);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		lblX.setHorizontalAlignment(SwingConstants.CENTER);
		lblX.setHorizontalTextPosition(SwingConstants.CENTER);
		lblX.setBounds(0, 0, 30, 30);
		btnSair.add(lblX);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
