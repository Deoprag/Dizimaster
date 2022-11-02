package com.dizimaster.model;

import java.sql.Date;

public class Dizimo {
	private int dizimista;
	private int funcionario;
	private float salario;
	private String observacao;
	private Date data;

	public Dizimo(int dizimista, int funcionario, float salario, Date data) {
		this.setDizimista(dizimista);
		this.setFuncionario(funcionario);
		this.setSalario(salario);
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

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
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
}
