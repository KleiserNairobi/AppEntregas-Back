package com.entregas.moduloendereco.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
    name = "municipio_seq",
    sequenceName = "municipio_seq",
    initialValue = 5391,
    allocationSize = 1
)
public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "municipio_seq")
    private Long id;

    @Size(min = 3, max = 60)
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    @NotNull(message = "Estado é obrigatório")
    private Estado estado;

    private Boolean cobertura;

}
