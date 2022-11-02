package com.dizimaster.model;

import java.sql.Date;

public class Despesa {
	private String nomeDespesa;
	private float valor;
	private Date data;
	private String descricao;
	private int funcionario;

	public Despesa(String nomeDespesa, float valor, Date data, String descricao, int funcionario) {
		this.setNomeDespesa(nomeDespesa);
		this.setValor(valor);
		this.setData(data);
		this.setDescricao(descricao);
		this.setFuncionario(funcionario);
	}

	public String getNomeDespesa() {
		return nomeDespesa;
	}

	public void setNomeDespesa(String nomeDespesa) {
		this.nomeDespesa = nomeDespesa;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}

}
