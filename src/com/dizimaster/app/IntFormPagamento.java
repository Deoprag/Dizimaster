package com.dizimaster.app;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;

@SuppressWarnings("serial")
public class IntFormPagamento extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IntFormPagamento frame = new IntFormPagamento();
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
	public IntFormPagamento() {
		setBounds(100, 100, 450, 300);
		BasicInternalFrameUI bui = (BasicInternalFrameUI) this.getUI();
		bui.setNorthPane(null);
	}

}
