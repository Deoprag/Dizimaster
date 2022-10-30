create database if not exists dizimaster
default character set utf8
default collate utf8_general_ci;

use dizimaster_db;

create table if not exists funcionario (
	id int primary key not null auto_increment,
    cpf char(11) not null unique,
    nome varchar(100) not null,
    sexo char not null,
    celular char(11) not null,
    email varchar(100) not null,
    senha varchar(32) not null,
    ativo boolean not null default true
) default charset = utf8;