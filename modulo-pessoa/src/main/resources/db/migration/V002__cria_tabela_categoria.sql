-- cria tabela categoria

CREATE TABLE public.categoria (
    id serial NOT NULL,
    descricao varchar(50) NOT NULL,
    CONSTRAINT pk_categoria PRIMARY KEY (id),
    CONSTRAINT uk_descricao UNIQUE (descricao)
);