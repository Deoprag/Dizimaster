package com.dizimaster.model;

import java.sql.Date;

public class Oferta {
	private int dizimista; // OPCIONAL
	private boolean isDizimista;
	private String nome;
	private float valor;
	private String observacao;
	private int funcionario;
	private Date data;

	public Oferta(int dizimista, boolean isDizimista, String nome, float valor, String obs, int funcionario, Date data) {
		this.setDizimista(dizimista);
		this.setIsDizimista(isDizimista);
		this.setNome(nome);
		this.setFuncionario(funcionario);
		this.setValor(valor);
		this.setObservacao(obs);
		this.setData(data);
	}
	
	public Oferta() {
		
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public boolean isDizimista() {
		return isDizimista;
	}

	public void setIsDizimista(boolean isDizimista) {
		this.isDizimista = isDizimista;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
