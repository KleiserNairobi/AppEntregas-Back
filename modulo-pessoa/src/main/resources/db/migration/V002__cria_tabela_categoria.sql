-- cria tabela categoria

CREATE SEQUENCE IF NOT EXISTS public.categoria_seq START 1;

CREATE TABLE public.categoria (
    id serial NOT NULL DEFAULT nextval('categoria_seq'),
    descricao varchar(50) NOT NULL,
    CONSTRAINT pk_categoria PRIMARY KEY (id),
    CONSTRAINT uk_descricao UNIQUE (descricao),
);