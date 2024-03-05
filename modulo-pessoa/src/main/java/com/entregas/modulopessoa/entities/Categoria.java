package com.entregas.modulopessoa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categoria_seq")
    @SequenceGenerator(name = "categoria_seq", sequenceName = "categoria_seq", initialValue = 1, allocationSize = 1)
    private int id;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(min = 3, max = 15, message = "Categoria deve ter entre {min} e {max} caracteres")
    private String descricao;

}


