package com.dizimaster.model;

public class Funcionario {
	private int id;
	private float salario;
	private String cpf;
	private String nome;
	private String celular;
	private String email;
	private String senha;
	private String dataNasc;
	private String cidade;
	private String bairro;
	private String rua;
	private int numero;
	private boolean dizimista;
	
	public Funcionario(int id, float salario, String cpf, String nome, String celular, String email, boolean dizimista) {
		this.id = id;
		this.salario = salario;
		this.cpf = cpf;
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.senha = "diz@2022";
		this.dizimista = dizimista;
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
	
	// CELULAR
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	// EMAIL
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	// SENHA
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	// SALARIO
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	// DIZIMISTA
	public boolean isDizimista() {
		return dizimista;
	}
	public void setDizimista(boolean dizimista) {
		this.dizimista = dizimista;
	}
}
