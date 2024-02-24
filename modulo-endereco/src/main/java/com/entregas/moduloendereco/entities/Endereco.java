package com.entregas.moduloendereco.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_seq")
    @SequenceGenerator(name = "endereco_seq", sequenceName = "endereco_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    @NotNull(message = "CEP é obrigatório")
    @Size(min = 9, max = 9, message = "CEP deve ter {max} caracteres")
    private String cep;

    @NotNull(message = "Logradouro é obrigatório")
    @Size(max = 60, message = "Logradouro deve ter no máximo {max} caracteres")
    private String logradouro;

    @Size(max = 10, message = "Número deve ter no máximo {max} caracteres")
    private String numero;

    @NotNull(message = "Complemento é obrigatório")
    @Size(max = 60, message = "Complemento deve ter no máximo {max} caracteres")
    private String complemento;

    @NotNull(message = "Bairro é obrigatório")
    @Size(max = 60, message = "Bairro deve ter no máximo {max} caracteres")
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "municipio_id")
    @NotNull(message = "Município é obrigatório")
    private Municipio municipio;

    @Size(max = 60, message = "Referência deve ter no máximo {max} caracteres")
    private String referencia;

    private BigDecimal latitude;

    private BigDecimal longitude;


}
