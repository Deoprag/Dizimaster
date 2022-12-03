package com.dizimaster.model;

import java.time.LocalDate;

public class Historico {
	private String tipo;
	private float valor;
	private String observacao;
	private int funcionario;
	private LocalDate data;
	private String hora;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public int getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(int funcionario) {
		this.funcionario = funcionario;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
}
