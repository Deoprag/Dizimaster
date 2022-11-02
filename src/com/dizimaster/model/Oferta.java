package com.dizimaster.model;

import java.sql.Date;

public class Oferta {
	private int dizimista;
	private int funcionario;
	private float valor;
	private Date data;
	
	public Oferta(int dizimista,
			int funcionario,
			float valor,
			Date data) {
				this.setDizimista(dizimista);
				this.setFuncionario(funcionario);
				this.setValor(valor);
				this.setData(data);
			}

	public int getDizimista() {
		return dizimista;
	}

	public void setDizimista(int dizimista) {
		this.dizimista = dizimista;
	}

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}