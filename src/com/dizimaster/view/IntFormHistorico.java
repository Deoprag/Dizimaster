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
import javax.swing.text.MaskFormatter;

import com.dizimaster.dao.FuncionarioDAO;
import com.dizimaster.dao.OfertaDAO;
import com.dizimaster.dao.UtilDAO;
import com.dizimaster.model.Mes;
import com.dizimaster.model.Oferta;

import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.dizimaster.swing.*;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class IntFormHistorico extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable tableOferta;
	private TxtId txtId;
	private List<Oferta> ofertaLista;
	private DefaultTableModel model;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormHistorico frame = new IntFormHistorico();
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
		ofertaLista = OfertaDAO.listaOferta(mes, ano);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for(int i = 0; i < ofertaLista.size() && ofertaLista.get(i) != null; i++) {
			model.addRow(new Object[]{
					ofertaLista.get(i).getId(),
					ofertaLista.get(i).isDizimista() ? "Sim": "Não",
					ofertaLista.get(i).getDizimista() == 0 ? "-" : ofertaLista.get(i).getDizimista(),
					ofertaLista.get(i).getNome(),
					valor.format(ofertaLista.get(i).getValor()),
					ofertaLista.get(i).getObservacao() == null ? "-" : ofertaLista.get(i).getObservacao(),
					ofertaLista.get(i).getFuncionario(),
					ofertaLista.get(i).getData().format(formatter),
					ofertaLista.get(i).getHora()
			});
		}

	}

	public IntFormHistorico() {
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
		
		JLabel lblTitle = new JLabel("Histórico de Dizimista");
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
		
		MaskFormatter mascaraCpf = null;
		try {
			mascaraCpf = new MaskFormatter("###.###.###-##");
			mascaraCpf.setPlaceholderCharacter('_');
		} catch(Exception e) {
			e.printStackTrace();
		}

		JFormattedTextField txtCpf = new JFormattedTextField(mascaraCpf);
		txtCpf.setBackground(new Color(235, 235, 235));
		txtCpf.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtCpf.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtCpf.setBounds(61, 60, 125, 30);
		panelMid.add(txtCpf);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setForeground(new Color(0, 0, 0));
		lblCpf.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCpf.setBounds(20, 60, 87, 30);
		panelMid.add(lblCpf);
		
		JLabel lblId = new JLabel("ID");
		lblId.setForeground(Color.BLACK);
		lblId.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblId.setBounds(250, 60, 40, 30);
		panelMid.add(lblId);
		
		txtId = new TxtId(5);
		txtId.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		txtId.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtId.setBackground(new Color(235, 235, 235));
		txtId.setBounds(275, 60, 70, 30);
		panelMid.add(txtId);
		
		
		
		JButton btnSearch = new JButton("");
		btnSearch.setRolloverEnabled(false);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setFocusTraversalKeysEnabled(false);
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearch.setIcon(new ImageIcon(IntFormAdmFuncionario.class.getResource("/com/dizimaster/img/find-icon-2-hold.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSearch.setIcon(new ImageIcon(IntFormAdmFuncionario.class.getResource("/com/dizimaster/img/find-icon-2.png")));
			}
		});
		btnSearch.setIcon(new ImageIcon(IntFormAdmFuncionario.class.getResource("/com/dizimaster/img/find-icon-2.png")));
		btnSearch.setRequestFocusEnabled(false);
		btnSearch.setFocusable(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setBorder(null);
		btnSearch.setBackground(new Color(235, 235, 235));
		btnSearch.setBounds(196, 65, 25, 25);
		panelMid.add(btnSearch);
		
		JButton btnSearchId = new JButton("");
		btnSearchId.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearchId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSearchId.setIcon(new ImageIcon(
						IntFormAdmDizimista.class.getResource("/com/dizimaster/img/find-icon-2-hold.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnSearchId.setIcon(
						new ImageIcon(IntFormAdmDizimista.class.getResource("/com/dizimaster/img/find-icon-2.png")));
			}
		});
		btnSearchId.setIcon(new ImageIcon(IntFormAdmDizimista.class.getResource("/com/dizimaster/img/find-icon-2.png")));
		btnSearchId.setRolloverEnabled(false);
		btnSearchId.setRequestFocusEnabled(false);
		btnSearchId.setFocusable(false);
		btnSearchId.setFocusTraversalKeysEnabled(false);
		btnSearchId.setFocusPainted(false);
		btnSearchId.setBorderPainted(false);
		btnSearchId.setBorder(null);
		btnSearchId.setBackground(new Color(235, 235, 235));
		btnSearchId.setBounds(355, 65, 25, 25);
		panelMid.add(btnSearchId);
		
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
		model.addColumn("Dizimista?");
		model.addColumn("ID Dizimista");
		model.addColumn("Nome");
		model.addColumn("Valor");
		model.addColumn("Observacao");
		model.addColumn("ID Funcionario");
		model.addColumn("Data");
		model.addColumn("Hora");
		
		tableOferta = new JTable(model);
		tableOferta.setEnabled(false);
		tableOferta.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableOferta.setBackground(new Color(235, 235, 235));
		tableOferta.setRowHeight(30);
		scrollPane.setViewportView(tableOferta);
		TableCustom.apply(scrollPane, TableCustom.TableType.MULTI_LINE);
		tableOferta.setAutoCreateRowSorter(true);
		
		JLabel lblBg = new JLabel("");
		lblBg.setIcon(new ImageIcon(IntFormHistorico.class.getResource("/com/dizimaster/img/heaven-bg.jpg")));
		lblBg.setBounds(0, 0, 1020, 673);
		getContentPane().add(lblBg);
		
	}

	public List<Oferta> getOfertaLista() {
		return ofertaLista;
	}



	public void setOfertaLista(List<Oferta> ofertaLista) {
		this.ofertaLista = ofertaLista;
	}
}
