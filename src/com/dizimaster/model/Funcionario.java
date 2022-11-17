package com.dizimaster.model;

import java.sql.Date;

public class Funcionario {
	private int id;
	private String cpf;
	private String nome;
	private Date nascimento;
	private char sexo;
	private String celular;
	private String email;
	private String senha;
	private boolean ativo;

	public Funcionario(int id, String cpf, String nome, Date nascimento, char sexo, String celular, String email, boolean ativo) {
		this.setId(id);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setSexo(sexo);
		this.setCelular(celular);
		this.setEmail(email);
		this.setSenha("diz@2022");
		this.setAtivo(ativo);
	}
	
	public Funcionario() {
		
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

	// SEXO
	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
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

	// ATIVO
	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
