package com.dizimaster.model;

public class Dizimista {
	private int id;
	private float salario;
	private String cpf;
	private String nome;
	private String celular;
	private PessoaEndereco endereco;
	
	
	public Dizimista(int id, float salario, String cpf, String nome, String celular) {
		this.id = id;
		this.salario = salario;
		this.cpf = cpf;
		this.nome = nome;
		this.celular = celular;
	}

	// ID
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	// SALARIO
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
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

	// CELULAR
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}

	public PessoaEndereco getEndereco() {
		return endereco;
	}

	public void setEndereco(PessoaEndereco endereco) {
		this.endereco = endereco;
	}
	
}
