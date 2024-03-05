-- cria tabela pessoa categoria

CREATE TABLE public.pessoa_categoria (
    pessoa_id int4 NOT NULL,
    categoria_id int4 NOT NULL,
    PRIMARY KEY (pessoa_id, categoria_id),
    FOREIGN KEY (pessoa_id) REFERENCES pessoa(id),
    FOREIGN KEY (categoria_id) REFERENCES categoria(id)
);