package com.dizimaster.model;

import java.time.LocalDate;

public class Dizimo {
	private int id;
	private int dizimista;
	private int funcionario;
	private float valor;
	private String observacao;
	private LocalDate data;
	private String hora;

	public Dizimo(int id, int dizimista, int funcionario, float valor, String obs, LocalDate data, String hora) {
		this.setId(id);
		this.setDizimista(dizimista);
		this.setFuncionario(funcionario);
		this.setValor(valor);
		this.setObservacao(obs);
		this.setData(data);
		this.setHora(hora);
	}

	public Dizimo() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
