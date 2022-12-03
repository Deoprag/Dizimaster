create database if not exists dizimaster_db
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
SELECT SUM(valor) from dizimo where DATE_FORMAT(data, '%m') = '11' and DATE_FORMAT(data, '%Y')= '2022';
SELECT SUM(valor) from oferta where DATE_FORMAT(data, '%m') = '10' and DATE_FORMAT(data, '%Y')= '2022';
SELECT SUM(valorDespesa) from despesa where DATE_FORMAT(dataDespesa, '%m') = '10' and DATE_FORMAT(dataDespesa, '%Y')= '2022';
SELECT SUM(valor) from oferta where dizimista = 1 and DATE_FORMAT(data, '%m') >= 11 and DATE_FORMAT(data, '%m') <= 11 and DATE_FORMAT(data, '%Y') = 2022;

select SUM(valorDizimo) from dizimo;
select SUM(valorDespesa) from despesa;

alter table funcionario
drop column salario;

insert into funcionario values (default, "14848328683", "Pedro Rabelo", "2004-02-27", 'm', "41992455737", "pdroesofiarabelo@gmail.com", "2022-12-2", "Pedro:9502", true, true);
create table if not exists funcionario (
	id int primary key not null auto_increment,
    cpf char(11) not null unique,
    nome varchar(100) not null,
    nascimento date not null,
    sexo char not null,
    celular char(11) not null,
    email varchar(100) not null,
    dataCadastro date not null,
    senha varchar(32) not null default "dizi@2022",
    ativo boolean not null default true,
    isAdmin boolean not null default false
) default charset = utf8;

create table if not exists dizimista (
	id int primary key not null auto_increment,
    cpf char(11) not null unique,
    nome varchar(100) not null,
    nascimento date not null,
    sexo char not null,
    celular char(11) not null,
    dataCadastro date not null,
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

INSERT INTO `dizimo` (`dizimista`,`valor`,`observacao`,`funcionario`,`data`,`hora`)
VALUES
  (0,35,"Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec",2,"2022-11-27","12:55:24"),
  (0,24,"Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Fusce aliquet magna",11,"2022-11-9","21:19:04"),
  (0,29,"semper tellus id nunc interdum feugiat. Sed nec metus facilisis lorem tristique aliquet. Phasellus fermentum convallis ligula. Donec",7,"2022-11-21","9:13:31"),
  (0,24,"est, mollis non, cursus non, egestas a, dui. Cras pellentesque. Sed",11,"2022-11-27","16:11:52"),
  (0,21,"varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur",17,"2022-11-27","9:47:24"),
  (0,30,"ac mattis semper, dui lectus rutrum urna, nec luctus felis purus ac",4,"2022-11-7","11:59:26"),
  (0,15,"felis. Donec tempor, est ac mattis semper, dui lectus rutrum urna, nec luctus felis purus ac",5,"2022-11-9","8:03:27"),
  (0,35,"quam, elementum at, egestas a, scelerisque sed, sapien. Nunc pulvinar arcu et pede. Nunc sed orci lobortis augue",17,"2022-11-8","14:15:43"),
  (0,16,"sagittis placerat. Cras dictum ultricies ligula. Nullam enim. Sed nulla ante, iaculis nec,",10,"2022-11-1","7:42:46"),
  (0,26,"sagittis felis. Donec tempor, est ac mattis semper, dui lectus rutrum",3,"2022-11-6","17:56:26"),
  (0,20,"enim, condimentum eget, volutpat ornare, facilisis eget, ipsum. Donec sollicitudin adipiscing ligula. Aenean gravida nunc",11,"2022-11-25","19:54:54"),
  (0,14,"eu tellus eu augue porttitor interdum. Sed auctor odio a purus.",13,"2022-11-14","19:26:50"),
  (0,45,"auctor, velit eget laoreet posuere, enim nisl elementum purus, accumsan interdum libero dui",6,"2022-11-5","21:43:23"),
  (0,45,"ac nulla. In tincidunt congue turpis. In condimentum. Donec at arcu. Vestibulum ante ipsum primis in",15,"2022-11-17","8:06:10"),
  (0,31,"arcu. Morbi sit amet massa. Quisque porttitor eros nec tellus. Nunc lectus pede, ultrices a,",2,"2022-11-21","7:47:30"),
  (0,35,"aliquet molestie tellus. Aenean egestas hendrerit neque. In ornare sagittis felis. Donec tempor, est",8,"2022-11-28","13:05:29"),
  (0,49,"venenatis vel, faucibus id, libero. Donec consectetuer mauris id sapien. Cras dolor",16,"2022-11-16","20:43:11"),
  (0,21,"quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt",20,"2022-11-13","10:57:46"),
  (0,24,"nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus",10,"2022-11-19","18:34:09"),
  (0,28,"dolor dapibus gravida. Aliquam tincidunt, nunc ac mattis ornare, lectus ante",10,"2022-11-7","2:17:47"),
  (0,18,"tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis a mi fringilla mi",10,"2022-11-30","5:33:31"),
  (0,15,"Pellentesque ultricies dignissim lacus. Aliquam rutrum lorem ac risus. Morbi metus. Vivamus euismod urna. Nullam lobortis quam a felis",5,"2022-11-29","14:35:20"),
  (0,20,"imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum dolor sit",15,"2022-11-12","0:04:49"),
  (0,11,"quam. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Aliquam fringilla cursus",20,"2022-11-9","6:13:17"),
  (0,12,"bibendum. Donec felis orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus eu",14,"2022-11-9","1:33:18"),
  (0,26,"sit amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio a purus.",2,"2022-11-3","6:24:42"),
  (0,39,"libero et tristique pellentesque, tellus sem mollis dui, in sodales elit erat vitae risus. Duis",14,"2022-11-12","21:30:28"),
  (0,49,"auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris nulla. Integer urna. Vivamus molestie dapibus ligula. Aliquam erat",16,"2022-11-15","13:55:33"),
  (0,11,"nulla vulputate dui, nec tempus mauris erat eget ipsum. Suspendisse",13,"2022-11-24","2:01:40"),
  (0,37,"vel arcu eu odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia",5,"2022-11-12","10:07:21"),
  (0,12,"placerat eget, venenatis a, magna. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.",7,"2022-11-6","17:41:05"),
  (0,35,"dui nec urna suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices",13,"2022-11-14","22:12:14"),
  (0,30,"pellentesque a, facilisis non, bibendum sed, est. Nunc laoreet lectus quis massa. Mauris vestibulum, neque sed",12,"2022-11-17","8:13:41"),
  (0,17,"risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a,",5,"2022-11-20","6:47:58"),
  (0,43,"vel pede blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae",9,"2022-11-28","10:17:04"),
  (0,11,"Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit",5,"2022-11-8","22:59:18"),
  (0,40,"eu, ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit at, nisi.",15,"2022-11-30","3:48:54"),
  (0,21,"vulputate, lacus. Cras interdum. Nunc sollicitudin commodo ipsum. Suspendisse non leo. Vivamus",3,"2022-11-30","18:12:05"),
  (0,47,"netus et malesuada fames ac turpis egestas. Fusce aliquet magna a neque. Nullam ut",6,"2022-11-26","1:10:17"),
  (0,46,"cursus luctus, ipsum leo elementum sem, vitae aliquam eros turpis",19,"2022-11-3","21:40:40"),
  (0,47,"risus quis diam luctus lobortis. Class aptent taciti sociosqu ad litora torquent per conubia",15,"2022-11-2","16:32:38"),
  (0,31,"pretium neque. Morbi quis urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue turpis. In",3,"2022-11-24","1:32:06"),
  (0,22,"eu tellus eu augue porttitor interdum. Sed auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis",18,"2022-11-9","6:53:24"),
  (0,30,"eget magna. Suspendisse tristique neque venenatis lacus. Etiam bibendum fermentum metus. Aenean sed pede nec ante blandit viverra. Donec tempus,",2,"2022-11-1","3:31:36"),
  (0,23,"diam. Sed diam lorem, auctor quis, tristique ac, eleifend vitae, erat. Vivamus nisi. Mauris",4,"2022-11-9","13:53:23"),
  (0,44,"Curabitur sed tortor. Integer aliquam adipiscing lacus. Ut nec urna et",20,"2022-11-26","3:16:08"),
  (0,48,"Donec elementum, lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque habitant",6,"2022-11-3","11:26:14"),
  (0,15,"justo sit amet nulla. Donec non justo. Proin non massa non ante bibendum ullamcorper. Duis",12,"2022-11-27","15:32:04"),
  (0,18,"sapien molestie orci tincidunt adipiscing. Mauris molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu",11,"2022-11-21","4:54:25"),
  (0,16,"euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis placerat. Cras dictum ultricies ligula. Nullam",3,"2022-11-3","19:01:01");
  
INSERT INTO `despesa` (`valor`,`descricao`,`funcionario`,`data`,`hora`)
VALUES
  (38,"blandit congue. In scelerisque scelerisque dui. Suspendisse ac metus vitae velit egestas lacinia. Sed",16,"2022-11-21","18:52:03"),
  (19,"tortor nibh sit amet orci. Ut sagittis lobortis mauris. Suspendisse aliquet molestie tellus. Aenean egestas hendrerit neque. In",7,"2022-11-7","21:25:37"),
  (36,"dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna tellus faucibus",8,"2022-11-25","14:17:57"),
  (12,"Quisque libero lacus, varius et, euismod et, commodo at, libero. Morbi accumsan laoreet ipsum. Curabitur consequat, lectus sit amet luctus",12,"2022-11-10","16:35:34"),
  (29,"tristique senectus et netus et malesuada fames ac turpis egestas. Fusce",13,"2022-11-23","1:25:33"),
  (31,"lectus, a sollicitudin orci sem eget massa. Suspendisse eleifend. Cras sed leo. Cras vehicula",16,"2022-11-20","0:24:42"),
  (32,"non massa non ante bibendum ullamcorper. Duis cursus, diam at pretium aliquet,",8,"2022-11-2","0:01:22"),
  (16,"augue, eu tempor erat neque non quam. Pellentesque habitant morbi tristique senectus et",7,"2022-11-5","16:25:40"),
  (27,"nisi magna sed dui. Fusce aliquam, enim nec tempus scelerisque, lorem",11,"2022-11-17","2:33:19"),
  (32,"tempus scelerisque, lorem ipsum sodales purus, in molestie tortor nibh sit",5,"2022-11-15","16:57:39"),
  (35,"tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante. Nunc mauris sapien, cursus in, hendrerit consectetuer,",15,"2022-11-19","1:06:21"),
  (37,"malesuada vel, convallis in, cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat",15,"2022-11-4","11:22:30"),
  (34,"dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu",7,"2022-11-7","16:14:33"),
  (37,"nec, diam. Duis mi enim, condimentum eget, volutpat ornare, facilisis eget, ipsum. Donec sollicitudin adipiscing ligula.",19,"2022-11-17","20:16:34"),
  (17,"euismod urna. Nullam lobortis quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor",3,"2022-11-5","21:53:59"),
  (15,"turpis. Aliquam adipiscing lobortis risus. In mi pede, nonummy ut, molestie in, tempus eu, ligula. Aenean euismod mauris eu",5,"2022-11-12","16:52:48"),
  (22,"convallis erat, eget tincidunt dui augue eu tellus. Phasellus elit pede, malesuada vel, venenatis vel,",5,"2022-11-14","12:55:40"),
  (25,"amet lorem semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus.",4,"2022-11-6","19:09:46"),
  (21,"purus gravida sagittis. Duis gravida. Praesent eu nulla at sem molestie sodales. Mauris blandit enim consequat purus. Maecenas",6,"2022-11-18","18:53:07"),
  (13,"Nulla dignissim. Maecenas ornare egestas ligula. Nullam feugiat placerat velit. Quisque varius. Nam porttitor scelerisque neque. Nullam",10,"2022-11-12","14:29:49"),
  (29,"eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta elit, a feugiat tellus lorem eu",4,"2022-11-24","17:00:11"),
  (16,"rutrum, justo. Praesent luctus. Curabitur egestas nunc sed libero. Proin sed",16,"2022-11-8","2:15:46"),
  (23,"felis orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras",5,"2022-11-24","7:40:32"),
  (22,"pede. Praesent eu dui. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus",8,"2022-11-8","21:50:18"),
  (28,"aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce feugiat. Lorem ipsum",18,"2022-11-8","17:12:17"),
  (16,"mi lorem, vehicula et, rutrum eu, ultrices sit amet, risus. Donec nibh enim, gravida sit amet, dapibus id, blandit at,",1,"2022-11-11","21:39:33"),
  (40,"suscipit nonummy. Fusce fermentum fermentum arcu. Vestibulum ante ipsum primis in faucibus orci luctus et",11,"2022-11-15","3:38:34"),
  (24,"luctus sit amet, faucibus ut, nulla. Cras eu tellus eu augue porttitor interdum. Sed auctor odio",17,"2022-11-12","10:39:38"),
  (15,"non enim commodo hendrerit. Donec porttitor tellus non magna. Nam",7,"2022-11-2","20:23:42"),
  (24,"odio tristique pharetra. Quisque ac libero nec ligula consectetuer rhoncus. Nullam velit dui, semper et, lacinia vitae, sodales at,",17,"2022-11-8","18:15:09"),
  (31,"auctor vitae, aliquet nec, imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec,",4,"2022-11-1","23:05:06"),
  (40,"hendrerit neque. In ornare sagittis felis. Donec tempor, est ac mattis",6,"2022-11-28","2:27:40"),
  (35,"in consectetuer ipsum nunc id enim. Curabitur massa. Vestibulum accumsan neque et nunc. Quisque",12,"2022-11-23","2:42:18"),
  (12,"quam. Curabitur vel lectus. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur",7,"2022-11-20","16:19:37"),
  (10,"ligula eu enim. Etiam imperdiet dictum magna. Ut tincidunt orci quis lectus. Nullam suscipit, est ac facilisis facilisis, magna",11,"2022-11-27","21:54:27"),
  (37,"parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla eu neque pellentesque",11,"2022-11-2","17:53:48"),
  (10,"nisl. Maecenas malesuada fringilla est. Mauris eu turpis. Nulla aliquet. Proin velit.",13,"2022-11-26","21:10:46"),
  (24,"enim mi tempor lorem, eget mollis lectus pede et risus. Quisque",5,"2022-11-26","3:55:55"),
  (38,"odio. Aliquam vulputate ullamcorper magna. Sed eu eros. Nam consequat dolor vitae",10,"2022-11-30","4:47:38"),
  (36,"amet, dapibus id, blandit at, nisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Proin",2,"2022-11-4","1:48:43"),
  (28,"Duis dignissim tempor arcu. Vestibulum ut eros non enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula",7,"2022-11-4","9:21:25"),
  (13,"Nam porttitor scelerisque neque. Nullam nisl. Maecenas malesuada fringilla est. Mauris",11,"2022-11-11","20:18:23"),
  (18,"Aliquam ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget",6,"2022-11-19","20:40:49"),
  (39,"semper auctor. Mauris vel turpis. Aliquam adipiscing lobortis risus. In mi pede, nonummy ut, molestie in, tempus eu, ligula.",15,"2022-11-9","10:33:51"),
  (13,"dis parturient montes, nascetur ridiculus mus. Donec dignissim magna a tortor. Nunc commodo auctor velit. Aliquam nisl. Nulla",6,"2022-11-24","0:40:19"),
  (29,"sed libero. Proin sed turpis nec mauris blandit mattis. Cras eget nisi",9,"2022-11-11","7:06:42"),
  (14,"volutpat ornare, facilisis eget, ipsum. Donec sollicitudin adipiscing ligula. Aenean gravida nunc sed pede. Cum",4,"2022-11-16","8:02:56"),
  (34,"auctor odio a purus. Duis elementum, dui quis accumsan convallis, ante lectus convallis est, vitae",4,"2022-11-19","7:12:47"),
  (16,"risus. Donec egestas. Aliquam nec enim. Nunc ut erat. Sed nunc est, mollis non, cursus non, egestas a,",8,"2022-11-30","19:36:44"),
  (39,"a nunc. In at pede. Cras vulputate velit eu sem. Pellentesque ut ipsum ac mi eleifend egestas. Sed pharetra,",8,"2022-11-14","5:25:21");