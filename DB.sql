create database if not exists dizimaster
default character set utf8
default collate utf8_general_ci;

use dizimaster_db;
select *from dizimo;
select *from oferta;
select *from funcionario;
select *from dizimista;
select *from despesa;

select DATE_FORMAT(dataOferta, '%Y') as YearNumber from oferta join dizimo GROUP BY YearNumber;
select DATE_FORMAT(dataOferta, '%M') as MonthText, DATE_FORMAT(dataOferta, '%m') as MonthNumber from oferta where DATE_FORMAT(dataOferta, '%Y')='2020' group by MonthNumber;
select (SELECT SUM(valorOferta) from oferta where DATE_FORMAT(dataOferta, '%m') = '12' and DATE_FORMAT(dataOferta, '%Y')= 2011) + (SELECT SUM(valorDizimo) from dizimo where DATE_FORMAT(dataDizimo, '%m') = '12' and DATE_FORMAT(dataDizimo, '%Y')= '2011') ;
SELECT SUM(valor) from dizimo where DATE_FORMAT(data, '%m') = '10' and DATE_FORMAT(data, '%Y')= '2022';
SELECT SUM(valor) from oferta where DATE_FORMAT(data, '%m') = '10' and DATE_FORMAT(data, '%Y')= '2022';
SELECT SUM(valorDespesa) from despesa where DATE_FORMAT(dataDespesa, '%m') = '10' and DATE_FORMAT(dataDespesa, '%Y')= '2022';
SELECT SUM(valor) from oferta where dizimista = 1 and DATE_FORMAT(data, '%m') >= 11 and DATE_FORMAT(data, '%m') <= 11 and DATE_FORMAT(data, '%Y') = 2022;

select SUM(valorDizimo) from dizimo;
select SUM(valorDespesa) from despesa;

alter table despesa
change column valorDespesa valor float not null;

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
    valorDizimo float not null,
	observacao varchar(200),
    funcionario int not null,
    dataDizimo date not null,
    hora time not null
) default charset = utf8;

create table if not exists oferta (
	id int primary key not null auto_increment,
    dizimista int,
    isDizimista boolean not null,
    nome varchar(100),
    valorOferta float not null,
    observacao varchar(200),
    funcionario int not null,
    dataOferta date not null,
    hora time not null
) default charset = utf8;

create table if not exists despesa (
	id int primary key not null auto_increment,
    valorDespesa float not null,
    descricao varchar(200) not null,
    funcionario int not null,
    dataDespesa date not null,
    hora time not null
) default charset = utf8;