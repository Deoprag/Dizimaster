package com.dizimaster.util;

import java.awt.Desktop;
import java.net.URL;

public class Utilidades {

	public static void openWebpage(String urlString) {
	    try {
	        Desktop.getDesktop().browse(new URL(urlString).toURI());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	
}
