package com.dizimaster.model;

import java.time.LocalDate;

public class Dizimista {
	private int id;
	private String cpf;
	private String nome;
	private char sexo;
	private LocalDate nascimento;
	private String celular;
	private float salario;
	private LocalDate dataCadastro;
	private boolean ativo;

	public Dizimista(int id, String cpf, String nome, char sexo, LocalDate nascimento, String celular, float salario, LocalDate dataCadastro, boolean ativo) {
		this.setId(id);
		this.setCpf(cpf);
		this.setNome(nome);
		this.setSexo(sexo);
		this.setNascimento(nascimento);
		this.setCelular(celular);
		this.setSalario(salario);
		this.setAtivo(ativo);
		this.setDataCadastro(dataCadastro);
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Dizimista() {
		
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

	public void setNascimento(LocalDate data) {
		this.nascimento = data;
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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
