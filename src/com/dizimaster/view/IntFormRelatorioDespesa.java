package com.dizimaster.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.swing.border.MatteBorder;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dizimaster.dao.DespesaDAO;
import com.dizimaster.dao.UtilDAO;
import com.dizimaster.model.Despesa;
import com.dizimaster.model.Mes;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.dizimaster.swing.*;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class IntFormRelatorioDespesa extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tableDespesa;
	private List<Despesa> despesaLista;
	private DefaultTableModel model;
	private JComboBox<Object> boxMes;
	private JComboBox<Object> boxAno;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormRelatorioDespesa frame = new IntFormRelatorioDespesa();
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
	
	public void mostraLista(int mes, int ano){
		try {
			model.getDataVector().removeAllElements();
		} catch (Exception e) {
			e.printStackTrace();
		}
		NumberFormat valor = NumberFormat.getCurrencyInstance(new Locale("pt","BR"));
		despesaLista = DespesaDAO.listaDespesa(mes, ano);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(int i = 0; i < despesaLista.size() && despesaLista.get(i) != null; i++) {
			model.addRow(new Object[]{
					despesaLista.get(i).getId() < 10 ? "0" + despesaLista.get(i).getId() : despesaLista.get(i).getId(),
					valor.format(despesaLista.get(i).getValor() < 10 ? "0" + despesaLista.get(i).getValor() : despesaLista.get(i).getValor()),
					despesaLista.get(i).getDescricao(),
					despesaLista.get(i).getFuncionario() < 10 ? "0" + despesaLista.get(i).getFuncionario() : despesaLista.get(i).getFuncionario(),
					despesaLista.get(i).getData().format(formatter),
					despesaLista.get(i).getHora()
			});
		}
	}

	public IntFormRelatorioDespesa() {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameOpened(InternalFrameEvent e) {
				try {
					UtilDAO.mostraAnoDespesa(boxAno);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		getContentPane().setBackground(new Color(230, 243, 255));
		setBorder(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 1020, 700);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
		
		JPanel panelMid = new JPanel();
		panelMid.setBorder(new MatteBorder(4, 0, 0, 0, (Color) new Color(0, 128, 192)));
		panelMid.setBackground(new Color(235, 235, 235));
		panelMid.setBounds(10, 11, 1000, 651);
		getContentPane().add(panelMid);
		panelMid.setLayout(null);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(10, 63, 40, 30);
		panelMid.add(lblAno);
		lblAno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		JLabel lblTitle = new JLabel("Relatório de Despesas");
		lblTitle.setBounds(10, 11, 320, 35);
		panelMid.add(lblTitle);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 22));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 50, 1000, 2);
		panelMid.add(separator_1);
		separator_1.setForeground(Color.LIGHT_GRAY);
		
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
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Segoe UI Black", Font.PLAIN, 12));
		btnSair.setFocusable(false);
		btnSair.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(245, 54, 54), new Color(255, 84, 84)));
		btnSair.setBackground(new Color(184, 44, 54));
		btnSair.setBounds(900, 10, 90, 30);
		panelMid.add(btnSair);
		
		boxMes = new JComboBox<Object>();
		boxMes.setBounds(180, 63, 100, 30);
		panelMid.add(boxMes);
		boxMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boxMes.getSelectedIndex() >= 0) {
					int ano = Integer.valueOf(boxAno.getSelectedItem().toString());
					Mes mes = (Mes) boxMes.getSelectedItem();
					mostraLista(mes.getMes(), ano);
				}
			}
		});
		boxMes.setRequestFocusEnabled(false);
		boxMes.setMaximumRowCount(12);
		boxMes.setForeground(Color.BLACK);
		boxMes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		boxMes.setFocusable(false);
		boxMes.setFocusTraversalKeysEnabled(false);
		boxMes.setBackground(new Color(200, 240, 255));
		
		JLabel lblMes = new JLabel("Mês");
		lblMes.setBounds(140, 63, 40, 30);
		panelMid.add(lblMes);
		lblMes.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		
		boxAno = new JComboBox<Object>();
		boxAno.setBounds(60, 63, 60, 30);
		panelMid.add(boxAno);
		boxAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (boxAno.getSelectedIndex() >= 0) {
					int ano = Integer.valueOf(boxAno.getSelectedItem().toString());
					try {
						boxMes.removeAllItems();
						UtilDAO.mostraMesDespesa(ano, boxMes);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		boxAno.setRequestFocusEnabled(false);
		boxAno.setForeground(Color.BLACK);
		boxAno.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		boxAno.setFocusable(false);
		boxAno.setFocusTraversalKeysEnabled(false);
		boxAno.setBackground(new Color(200, 240, 255));
		
		TableScrollButton scrBtn = new TableScrollButton();
		scrBtn.setBounds(10, 105, 980, 535);
		panelMid.add(scrBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(235, 235, 235));
		scrollPane.setBounds(5, 11, 990, 486);
		scrBtn.add(scrollPane,java.awt.BorderLayout.CENTER);
		
		model = new DefaultTableModel(); 
		model.addColumn("ID");
		model.addColumn("Valor");
		model.addColumn("Descricao");
		model.addColumn("ID Funcionario");
		model.addColumn("Data");
		model.addColumn("Hora");
		
		tableDespesa = new JTable(model);
		tableDespesa.setEnabled(false);
		tableDespesa.setAutoCreateColumnsFromModel(false);
		tableDespesa.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableDespesa.setBackground(new Color(235, 235, 235));
		tableDespesa.setRowHeight(30);
		scrollPane.setViewportView(tableDespesa);
		TableCustom.apply(scrollPane, TableCustom.TableType.MULTI_LINE);
		tableDespesa.setAutoCreateRowSorter(true);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(IntFormRelatorioDespesa.class.getResource("/com/dizimaster/img/heaven-bg.jpg")));
		lblBg.setBounds(0, 0, 1020, 673);
		getContentPane().add(lblBg);
		
	}

	public List<Despesa> getOfertaLista() {
		return despesaLista;
	}



	public void setOfertaLista(List<Despesa> ofertaLista) {
		this.despesaLista = ofertaLista;
	}
}
