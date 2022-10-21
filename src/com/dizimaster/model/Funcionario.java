package com.dizimaster.model;

import java.time.LocalDate;

public class Funcionario {
	private int id;
	private float salario;
	private String cpf;
	private String nome;
	private String celular;
	private String email;
	private String senha;
	private LocalDate nascimento;
	private boolean dizimista;
	
	public Funcionario(int id, float salario, String cpf, String nome, String celular, String email, LocalDate nascimento, boolean dizimista) {
		this.id = id;
		this.salario = salario;
		this.cpf = cpf;
		this.nome = nome;
		this.celular = celular;
		this.email = email;
		this.senha = "diz@2022";
		this.nascimento = nascimento;
		this.dizimista = dizimista;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public LocalDate getNascimento() {
		return nascimento;
	}
	public void setNascimento(LocalDate nascimento) {
		this.nascimento = nascimento;
	}
	public boolean isDizimista() {
		return dizimista;
	}
	public void setDizimista(boolean dizimista) {
		this.dizimista = dizimista;
	}
}
