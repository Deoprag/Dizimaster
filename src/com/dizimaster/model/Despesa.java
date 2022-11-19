package com.dizimaster.model;

import java.time.LocalDate;

public class Despesa {
	private float valor;
	private LocalDate data;
	private String hora;
	private String descricao;
	private int funcionario;

	public Despesa(String nomeDespesa, float valor, LocalDate data, String descricao, int funcionario, String hora) {
		this.setValor(valor);
		this.setData(data);
		this.setHora(hora);
		this.setDescricao(descricao);
		this.setFuncionario(funcionario);
	}
	
	public Despesa() {
		
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate localDate) {
		this.data = localDate;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

}
