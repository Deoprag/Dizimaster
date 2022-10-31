package com.dizimaster.model;

import java.sql.Date;

public class Funcionario {
	private String cpf;
	private String nome;
	private Date nascimento;
	private char sexo;
	private String celular;
	private String email;
	private String senha;
	private float salario;
	private boolean ativo;
	
	public Funcionario(String cpf, String nome, Date nascimento, char sexo, String celular, String email, float salario, boolean ativo) {
		this.setCpf(cpf);
		this.setNome(nome);
		this.setNascimento(nascimento);
		this.setSexo(sexo);
		this.setCelular(celular);
		this.setEmail(email);
		this.setSenha("diz@2022");
		this.setSalario(salario);
		this.setAtivo(ativo);
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
