package com.dizimaster.view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class IntFormFluxo extends JInternalFrame {

	private static final long serialVersionUID = 1L;

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

	public IntFormFluxo() {
		getContentPane().setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1020, 665);
		getContentPane().setLayout(null);
		setBorder(null);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(IntFormFluxo.class.getResource("/com/dizimaster/img/Background.jpg")));
		lblNewLabel.setBounds(0, 0, 1020, 665);
		getContentPane().add(lblNewLabel);
		
	}
}
