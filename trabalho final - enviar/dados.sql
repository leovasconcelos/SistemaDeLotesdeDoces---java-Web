CREATE DATABASE pwe;

use pwe;

create TABLE usuario(
	id_distribuidor int not null auto_INCREMENT primary key,
	nome varchar(50),
	dataNascimento varchar(50),
	email varchar(50),
	senha varchar(50),
	Endereco varchar(50),
	nomeEmpresa varchar(50),
	tipo int,
	cnpj varchar(50)
);

/*
tipo 1 = distribuidor;
tipo 2 = cliente; preenche nomeEmpresa/dataNascimento
*/

create TABLE tipos(
	id_tipo int not null auto_INCREMENT primary key,
	tipo varchar(50)
);

create TABLE Doces(
	id_doce int not null auto_INCREMENT primary key,
	Nome varchar(50),
	Descricao varchar(50),
	Tipo int,
	PrecoUnitario varchar(50),
	FOREIGN KEY (Tipo) REFERENCES tipos (id_tipo)
);

create TABLE lote(
	id_lote int not null auto_INCREMENT primary key,
	doce int,
	quantidade varchar(50),
	valor_lote varchar(50),
	usuario int,
	FOREIGN KEY (doce) REFERENCES Doces (id_doce),
	FOREIGN KEY (usuario) REFERENCES usuario (id_distribuidor)
);

create TABLE chat(
	id_chat int not null auto_INCREMENT primary key,
	mensagem varchar(50),
	paraQuem int,
	deQuem int,
	FOREIGN KEY (paraQuem) REFERENCES usuario (id_distribuidor),
	FOREIGN KEY (deQuem) REFERENCES usuario (id_distribuidor)
);


INSERT INTO `usuario` VALUES (1,'leo',NULL,'leo','leo',NULL,NULL,0,NULL),(2,'adm',NULL,'adm','adm',NULL,NULL,1,NULL);
INSERT INTO `tipos` VALUES (1,'chocolate'),(2,'teste'),(4,'Tipo leo Teste');
INSERT INTO `doces` VALUES (1,'teste','teste',1,'10'),(2,'outroTeste','teste',2,'20'),(3,'teste leo','teste',4,'30');
INSERT INTO `lote` VALUES (1,1,'200','2000',1);
INSERT INTO `chat` VALUES (1,'Olá quero o lote',2,1),(2,'vendido',1,2);

