package com.dizimaster.model;

import java.sql.Date;

public class Dizimista {
	private int id;
	private String cpf;
	private String nome;
	private Date nascimento;
	private String celular;
	private float salario;

	public Dizimista(int id, String cpf, String nome, Date nascimento, String celular, float salario) {
		this.setId(id);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setCelular(celular);
		this.setSalario(salario);
	}

	public Dizimista() {
		// TODO Auto-generated constructor stub
	}

	// ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// CPF
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	// NOME
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// NASCIMENTO
	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	// CELULAR
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
