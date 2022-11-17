package com.dizimaster.model;

import java.sql.Date;

public class Dizimo {
	private int dizimista;
	private int funcionario;
	private float valor;
	private String observacao;
	private Date data;

	public Dizimo(int dizimista, int funcionario, float valor, String obs, Date data) {
		this.setDizimista(dizimista);
		this.setFuncionario(funcionario);
		this.setValor(valor);
		this.setObservacao(obs);
		this.setData(data);
	}

	public Dizimo() {
		
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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}
}
