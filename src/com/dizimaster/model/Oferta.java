package com.dizimaster.model;

import java.time.LocalDate;

public class Oferta {
	private int id;
	private int dizimista; // OPCIONAL
	private boolean isDizimista;
	private String nome;
	private float valor;
	private String observacao;
	private int funcionario;
	private LocalDate data;
	private String hora;

	public Oferta(int id, int dizimista, boolean isDizimista, String nome, float valor, String obs, int funcionario, LocalDate data, String hora) {
		this.setId(id);
		this.setDizimista(dizimista);
		this.setIsDizimista(isDizimista);
		this.setNome(nome);
		this.setFuncionario(funcionario);
		this.setValor(valor);
		this.setObservacao(obs);
		this.setData(data);
		this.setHora(hora);
	}
	
	public Oferta() {
		
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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
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

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
