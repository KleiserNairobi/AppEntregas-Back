package com.entregas.moduloendereco.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Estado {

    @Id
    @Size(min = 2, max = 2)
    private String sigla;

    @Size(max = 40)
    private String nome;

}
