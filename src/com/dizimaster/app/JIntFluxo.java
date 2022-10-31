package com.dizimaster.app;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class JIntFluxo extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JIntFluxo frame = new JIntFluxo();
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
	public JIntFluxo() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
		setBorder(null);
		
		JLabel lblDeopragLabs = new JLabel("® Deoprag Labs");
		lblDeopragLabs.setForeground(Color.WHITE);
		lblDeopragLabs.setFont(new Font("Rubik", Font.BOLD, 10));
		lblDeopragLabs.setBounds(0, 0, 90, 25);
		getContentPane().add(lblDeopragLabs);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(JIntFluxo.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblNewLabel);
		
//											TESTE:
//		PieChart pieChart = new PieChart();
//		pieChart1.setChartType(PieChart.PeiChartType.DONUT_CHART);
//
//		pieChart1.addData(new ModelPieChart("Fanta", 150, new Color(23, 126, 238)));
//		pieChart1.addData(new ModelPieChart("Other", 100, new Color(221, 65, 65)));
//		pieChart1.addData(new ModelPieChart("Coca", 80, new Color(47, 157, 64)));
//		pieChart1.addData(new ModelPieChart("Vita", 60, new Color(196, 151, 58)));
	}
}
