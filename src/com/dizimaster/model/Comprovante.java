package com.dizimaster.model;

import java.time.LocalDate;

public class Comprovante {
	private Funcionario funcionario;
	private Dizimista dizimista;
	private LocalDate data;
	private String hora;
	private Dizimo dizimo;
	private Float valor;

	public Comprovante(Funcionario funcionario, Dizimista dizimista, LocalDate data, String hora, Float valor,
			Dizimo dizimo) {
		this.funcionario = funcionario;
		this.dizimista = dizimista;
		this.data = data;
		this.hora = hora;
		this.valor = valor;
		this.dizimo = dizimo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Dizimista getContribuidor() {
		return dizimista;
	}

	public void setContribuidor(Dizimista contribuidor) {
		this.dizimista = contribuidor;
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

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Dizimo getDizimo() {
		return dizimo;
	}

	public void setDizimo(Dizimo dizimo) {
		this.dizimo = dizimo;
	}
}
