package com.dizimaster.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import com.dizimaster.swing.*;
import com.dizimaster.dao.DespesaDAO;
import com.dizimaster.dao.DizimoDAO;
import com.dizimaster.dao.OfertaDAO;
import com.dizimaster.dao.UtilDAO;
import com.dizimaster.model.*;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.dizimaster.swing.LblGrafico.PeiChartType;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;

public class IntFormFluxo extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private LblGrafico pieChart;
	private LblGrafico pieChartTotal;
	private JComboBox<Object> boxMes;
	private JComboBox<Object> boxAno;
	private JLabel lblTotal;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormFluxo frame = new IntFormFluxo();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private Color getColor(int index) {
		Color[] color = new Color[] { new Color(242, 182, 0), new Color(0, 98, 177), new Color(255, 113, 12),
				new Color(30, 105, 39) };
		return color[index];
	}

	private void mostraGrafico(int mes, int ano) {
		pieChart.clearData();
		pieChartTotal.clearData();
		
		float oferta = OfertaDAO.somaOferta(mes, ano);
		float dizimo = DizimoDAO.somaDizimo(mes, ano);
		float despesa = DespesaDAO.somaDespesa(mes, ano);

		int index = 0;
		pieChart.addData(new Grafico("Oferta", oferta, getColor(index++)));
		pieChart.addData(new Grafico("Dizimo", dizimo, getColor(index++)));

		Float totalEntrada = dizimo + oferta;
		Float saldo = totalEntrada - despesa;

		pieChartTotal.addData(new Grafico("Despesas", despesa, getColor(index++)));
		pieChartTotal.addData(new Grafico("Saldo Restante", saldo, getColor(index++)));
		
		@SuppressWarnings("deprecation")
		NumberFormat valor = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		lblTotal.setText("Total: " + valor.format(totalEntrada));
	}

	private void voltar() {
		this.dispose();
	}

	public IntFormFluxo() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				try {
					UtilDAO.mostraAno(boxAno);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1020, 700);
		getContentPane().setLayout(null);
		setBorder(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);

		JPanel panelMid = new JPanel();
		panelMid.setLayout(null);
		panelMid.setBorder(new CompoundBorder(new LineBorder(new Color(0, 64, 128)), new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192))));
		panelMid.setBackground(new Color(235, 235, 235));
		panelMid.setBounds(47, 51, 925, 570);
		getContentPane().add(panelMid);

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
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(0, 128, 192));
		panel.setBounds(10, 60, 230, 40);
		panelMid.add(panel);
		panel.setLayout(null);
		
		lblTotal = new JLabel("");
		lblTotal.setBounds(0, 0, 230, 40);
		panel.add(lblTotal);
		lblTotal.setHorizontalTextPosition(SwingConstants.CENTER);
		lblTotal.setForeground(new Color(255, 255, 255));
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 22));
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(825, 11, 90, 30);
		panelMid.add(btnSair);

		JLabel lblTitle = new JLabel("Fluxo de Caixa");
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblTitle.setBounds(10, 11, 320, 35);
		panelMid.add(lblTitle);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.LIGHT_GRAY);
		separator_1.setBounds(3, 50, 920, 2);
		panelMid.add(separator_1);

		boxMes = new JComboBox<Object>();
		boxMes.setRequestFocusEnabled(false);
		boxMes.setFocusTraversalKeysEnabled(false);
		boxMes.setFocusable(false);
		boxMes.setBackground(new Color(200, 240, 255));
		boxMes.setForeground(new Color(0, 0, 0));
		boxMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boxMes.getSelectedIndex() >= 0) {
					int ano = Integer.valueOf(boxAno.getSelectedItem().toString());
					Mes mes = (Mes) boxMes.getSelectedItem();
					mostraGrafico(mes.getMes(), ano);
				}
			}
		});
		boxMes.setMaximumRowCount(12);
		boxMes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		boxMes.setBounds(815, 63, 100, 30);
		panelMid.add(boxMes);

		boxAno = new JComboBox<Object>();
		boxAno.setRequestFocusEnabled(false);
		boxAno.setFocusTraversalKeysEnabled(false);
		boxAno.setFocusable(false);
		boxAno.setBackground(new Color(200, 240, 255));
		boxAno.setForeground(new Color(0, 0, 0));
		boxAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boxAno.getSelectedIndex() >= 0) {
					int ano = Integer.valueOf(boxAno.getSelectedItem().toString());
					try {
						boxMes.removeAllItems();
						UtilDAO.mostraMes(ano, boxMes);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		boxAno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		boxAno.setBounds(705, 64, 60, 30);
		panelMid.add(boxAno);

		JLabel lblMes = new JLabel("Mês");
		lblMes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblMes.setBounds(775, 63, 40, 30);
		panelMid.add(lblMes);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		lblAno.setBounds(665, 63, 40, 30);
		panelMid.add(lblAno);

		pieChart = new LblGrafico();
		pieChart.setChartType(PeiChartType.DONUT_CHART);
		pieChart.setBounds(8, 117, 450, 451);
		panelMid.add(pieChart);
		pieChart.setFocusable(false);
		pieChart.setFocusTraversalKeysEnabled(false);

		pieChartTotal = new LblGrafico();
		pieChartTotal.setChartType(PeiChartType.DONUT_CHART);
		pieChartTotal.setBounds(466, 117, 450, 451);
		panelMid.add(pieChartTotal);
		pieChartTotal.setFocusable(false);
		pieChartTotal.setFocusTraversalKeysEnabled(false);

		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(IntFormFluxo.class.getResource("/com/dizimaster/img/heaven-bg.jpg")));
		lblBg.setBounds(0, 0, 1020, 673);
		getContentPane().add(lblBg);

	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
