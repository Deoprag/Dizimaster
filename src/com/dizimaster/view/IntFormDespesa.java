package com.dizimaster.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import com.dizimaster.model.Despesa;
import com.dizimaster.model.Funcionario;
import com.dizimaster.util.DatabaseUtils;
import com.dizimaster.util.GenericUtils;
import com.dizimaster.util.TxtObservacao;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;

import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Insets;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IntFormDespesa extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormOferta frame = new IntFormOferta();
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

	public IntFormDespesa() {
		setBorder(null);
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);

		JPanel panelCadastro = new JPanel();
		panelCadastro.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 120, 215), new Color(0, 191, 255)));
		panelCadastro.setBackground(new Color(135, 206, 235));
		panelCadastro.setBounds(335, 34, 350, 570);
		getContentPane().add(panelCadastro);
		panelCadastro.setLayout(null);

		JLabel lblReal = new JLabel("R$");
		lblReal.setForeground(Color.WHITE);
		lblReal.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblReal.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		lblReal.setBackground(Color.WHITE);
		lblReal.setAlignmentX(0.5f);
		lblReal.setBounds(122, 284, 25, 30);
		panelCadastro.add(lblReal);

		JTextField txtValor = new JTextField(8);
		txtValor.setForeground(Color.WHITE);
		txtValor.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		txtValor.setColumns(10);
		txtValor.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)));
		txtValor.setBackground(new Color(25, 120, 150));
		txtValor.setBounds(145, 284, 60, 30);
		panelCadastro.add(txtValor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(100, 350, 150, 100);
		scrollPane.setBorder(null);
		panelCadastro.add(scrollPane);

		TxtObservacao txtDescricao = new TxtObservacao(199);
		scrollPane.setViewportView(txtDescricao);
		txtDescricao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDescricao.getForeground().equals(new Color(192,192,192))) {
					txtDescricao.setText("");
				}
				txtDescricao.setForeground(Color.WHITE);
			}
		});
		txtDescricao.setLineWrap(true);
		txtDescricao.setWrapStyleWord(true);
		txtDescricao.setMargin(new Insets(0, 0, 0, 0));
		txtDescricao.setForeground(new Color(192, 192, 192));
		txtDescricao.setText("Insira aqui uma descrição");
		txtDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 11));
		txtDescricao.setBorder(new CompoundBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(10, 60, 70)),
				new EmptyBorder(2, 5, 2, 5)));
		txtDescricao.setBackground(new Color(30, 140, 175));

		JLabel lblObs = new JLabel("Descrição");
		lblObs.setBounds(134, 325, 81, 24);
		lblObs.setForeground(Color.WHITE);
		lblObs.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblObs.setBorder(null);
		lblObs.setBackground(Color.WHITE);
		lblObs.setAlignmentX(0.5f);
		panelCadastro.add(lblObs);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(150, 261, 50, 24);
		lblValor.setForeground(Color.WHITE);
		lblValor.setFont(new Font("Rubik", Font.PLAIN, 12));
		lblValor.setBorder(null);
		lblValor.setBackground(Color.WHITE);
		lblValor.setAlignmentX(0.5f);
		panelCadastro.add(lblValor);

		JButton btnSair = new JButton("VOLTAR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "Tem certeza que deseja voltar?", "Voltar?",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					voltar();
				}
			}
		});
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
		btnSair.setBounds(56, 495, 90, 40);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		panelCadastro.add(btnSair);

		JLabel lblTitulo = new JLabel("Despesa");
		lblTitulo.setBounds(55, 200, 240, 35);
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 16));
		lblTitulo.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		lblTitulo.setBackground(Color.GRAY);
		panelCadastro.add(lblTitulo);

		JLabel lblLogo = new JLabel("");
		lblLogo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblLogo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				GenericUtils.openWebpage("https://www.instagram.com/deopraglabs");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblLogo.setIcon(
						new ImageIcon(IntFormOferta.class.getResource("/com/dizimaster/img/logo-hold-small.png")));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblLogo.setIcon(new ImageIcon(IntFormOferta.class.getResource("/com/dizimaster/img/logo-small.png")));
			}
		});
		lblLogo.setBounds(100, 20, 150, 150);
		lblLogo.setIcon(new ImageIcon(IntFormOferta.class.getResource("/com/dizimaster/img/logo-small.png")));
		panelCadastro.add(lblLogo);

		JButton btnEnviar = new JButton("REGISTRAR");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtDescricao.getText().length() < 20) {
					JOptionPane.showMessageDialog(null, "A descrição do pagamento deve ter no mínimo 20 caracteres");
				} else {
					try {
						Despesa despesa = new Despesa();
						despesa.setValor(Float.parseFloat(txtValor.getText().replace(",",".")));
						despesa.setDescricao(txtDescricao.getText());
						despesa.setFuncionario(funcionario.getId());
						despesa.setData(GenericUtils.dataAtual());
						despesa.setHora(GenericUtils.horaAtual());
						if(DatabaseUtils.registraDespesa(despesa)) {
							txtValor.setText("");
							txtDescricao.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Não foi possível registrar despesa!");
						}
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "O valor inserido é inválido!");
					} catch (Exception e2) {
						e2.printStackTrace();
					}
				}
			}
		});
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
		lblBackgroundPanel.setIcon(new ImageIcon(IntFormOferta.class.getResource("/com/dizimaster/img/Cad_Panel.jpg")));
		lblBackgroundPanel.setBorder(new LineBorder(new Color(255, 255, 255), 1, true));
		panelCadastro.add(lblBackgroundPanel);

		JLabel lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon(IntFormOferta.class.getResource("/com/dizimaster/img/church-bg.png")));
		lblBackground.setBackground(new Color(66, 174, 193));
		lblBackground.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblBackground);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
