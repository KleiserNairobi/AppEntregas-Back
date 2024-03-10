-- cria_tabela_pessoa

CREATE TABLE public.pessoa (
	id serial NOT NULL,
	tipo bpchar(1) NOT NULL,
	nome varchar(60) NOT NULL,
	email varchar(100) NOT NULL,
	telefone varchar(14) NULL,
	cpf_cnpj varchar(18) NULL,
	nome_fantasia varchar(60) NULL,
	ramo_atividade varchar(45) NULL,
	rg varchar(45) NULL,
	nascimento date NULL,
	ativo bool NOT NULL DEFAULT false,
	online bool NOT NULL DEFAULT false,
	data_inclusao timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	data_alteracao timestamp NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT pk_pessoa PRIMARY KEY (id),
	CONSTRAINT uk_email UNIQUE (email),
	CONSTRAINT uk_telefone UNIQUE (telefone)
);