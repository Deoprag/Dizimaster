package com.dizimaster.model;

public class Mes {
	private int mes;
	private String textoMes;
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public String getTextoMes() {
		return textoMes;
	}
	public void setTextoMes(String textoMes) {
		this.textoMes = textoMes;
	}
	
	public Mes(int mes, String textoMes) {
		this.mes = mes;
		this.textoMes = textoMes;
	}
	
	@Override
	public String toString() {
		return textoMes;
	}
	
}
