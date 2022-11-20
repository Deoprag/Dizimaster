create database if not exists dizimaster
default character set utf8
default collate utf8_general_ci;

use dizimaster_db;
select *from dizimo;
select *from oferta;
select *from funcionario;
select *from dizimista;
select *from despesa;

create table if not exists funcionario (
	id int primary key not null auto_increment,
    cpf char(11) not null unique,
    nome varchar(100) not null,
    nascimento date not null,
    sexo char not null,
    celular char(11) not null,
    salario float,
    email varchar(100) not null,
    senha varchar(32) not null default "dizi@2022",
    ativo boolean not null default true
) default charset = utf8;

create table if not exists dizimista (
	id int primary key not null auto_increment,
    cpf char(11) not null unique,
    nome varchar(100) not null,
    nascimento date not null,
    sexo char not null,
    celular char(11) not null,
    salario float,
    ativo boolean not null default true
) default charset = utf8;

create table if not exists dizimo (
	id int primary key not null auto_increment,
    dizimista int not null,
    valor float not null,
	observacao varchar(200),
    funcionario int not null,
    data date not null,
    hora time not null
) default charset = utf8;

create table if not exists oferta (
	id int primary key not null auto_increment,
    dizimista int,
    isDizimista boolean not null,
    nome varchar(100),
    valor float not null,
    observacao varchar(200),
    funcionario int not null,
    data date not null,
    hora time not null
) default charset = utf8;

create table if not exists despesa (
	id int primary key not null auto_increment,
    valor float not null,
    descricao varchar(200) not null,
    funcionario int not null,
    data date not null,
    hora time not null
) default charset = utf8;