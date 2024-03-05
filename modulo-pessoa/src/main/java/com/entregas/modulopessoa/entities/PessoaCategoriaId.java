package com.entregas.modulopessoa.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PessoaCategoriaId  implements Serializable {

    private int pessoaId;
    private int categoriaId;

}
