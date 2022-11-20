package com.dizimaster.util;

import java.awt.Desktop;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.swing.JOptionPane;

public class GenericUtils {

	public static void openWebpage(String urlString) {
		try {
			Desktop.getDesktop().browse(new URL(urlString).toURI());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static boolean isEmail(String email) {
		   boolean result = true;
		   try {
		      InternetAddress emailAddr = new InternetAddress(email);
		      emailAddr.validate();
		   } catch (AddressException ex) {
		      result = false;
		   }
		   return result;
		}

	public static boolean isCPF(String cpf) {

		if (cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222")
				|| cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555")
				|| cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888")
				|| cpf.equals("99999999999") || cpf.length() != 11)
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		try {
			// PRIMEIRO DV
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48);
			// SEGUNDO DV
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (cpf.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}
			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
				return (true);
			else
				return (false);
		} catch (Exception e) {
			return (false);
		}
	}

	public static boolean reqSenha(String senha, String confSenha, String senhaAnterior) {
		char[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] numeros = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		char[] especiais = { '[', ']', '{', '}', '(', ')', '*', '-', '+', '=', '.', ':', ';', '/', '|', '\\', '?', '!',
				'@', '#', '$', '%', '&', '*' };

		if (senha.equals("dizimaster@2022") || senha.equals(senhaAnterior)) {
			JOptionPane.showMessageDialog(null, "Você não pode utilizar essa senha!");
			return false;
		}
		if (senha.length() < 8) {
			JOptionPane.showMessageDialog(null, "Verifique os requisitos de senha e tente novamente!");
			return false;
		}
		if (!senha.equals(confSenha)) {
			JOptionPane.showMessageDialog(null, "As senha não coincidem!");
			return false;
		}
		for (int i = 0; i < senha.length(); i++) {
			for (int j = 0; j < letras.length; j++) {
				if (letras[j] == senha.charAt(i)) {
					// LETRAS
					for (int i2 = 0; i2 < senha.length(); i2++) {
						for (int j2 = 0; j2 < numeros.length; j2++) {
							if (numeros[j2] == senha.charAt(i2)) {
								// NUMEROS
								for (int i3 = 0; i3 < senha.length(); i3++) {
									for (int j3 = 0; j3 < especiais.length; j3++) {
										if (especiais[j3] == senha.charAt(i3)) {
											// ESPECIAIS
											return true;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		JOptionPane.showMessageDialog(null, "Verifique os requisitos de senha e tente novamente!");
		return false;
	}

	public static LocalDate dataAtual() {
		String dataAtual = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
		LocalDate dataAtualFormatada = LocalDate.parse(dataAtual, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return dataAtualFormatada;
	}

	public static String horaAtual() {
		SimpleDateFormat s = new SimpleDateFormat("k:mm:ss");
		java.util.Date d = new java.util.Date();
		return s.format(d);
	}
}
