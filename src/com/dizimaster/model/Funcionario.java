package com.dizimaster.model;

import java.time.LocalDate;

public class Funcionario {
	private int id;
	private String cpf;
	private String nome;
	private LocalDate nascimento;
	private char sexo;
	private String celular;
	private String email;
	private LocalDate dataCadastro;
	private String senha;
	private boolean ativo;
	private boolean isAdmin;

	public Funcionario(int id, String cpf, String nome, LocalDate nascimento, char sexo, String celular, String email, LocalDate dataCadastro, boolean ativo, boolean isAdmin) {
		this.setId(id);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setSexo(sexo);
		this.setCelular(celular);
		this.setEmail(email);
		this.setDataCadastro(dataCadastro);
		this.setSenha("diz@2022");
		this.setAtivo(ativo);
		this.setAdmin(isAdmin);
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
	public LocalDate getNascimento() {
		return nascimento;
	}

	public void setNascimento(LocalDate nascimento) {
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

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
