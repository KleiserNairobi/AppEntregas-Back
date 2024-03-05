package com.entregas.modulopessoa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "pessoa_categoria")
public class PessoaCategoria {

    @EmbeddedId
    private PessoaCategoriaId id;

    @ManyToOne
    @MapsId("pessoaId")
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @ManyToOne
    @MapsId("categoriaId")
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

}
