package com.entregas.modulopessoa.entities;

import com.entregas.modulopessoa.enums.TipoPessoa;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Tipo é obrigatório")
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipo;

    @NotEmpty(message = "Nome é obrigatório")
    @Size(min = 3, max = 60, message = "Nome deve ter entre {min} e {max} caracteres")
    private String nome;

    @Email(message = "Formato inválido")
    @Size(max = 100, message = "Email deve ter no máximo {max} caracteres")
    private String email;

    @Size(min = 13, max = 14, message = "Telefone deve ter entre {min} e {max} caracteres")
    private String telefone;

    @Size(min = 14, max = 18, message = "CPF/CNPJ deve ter entre {min} e {max} caracteres")
    @Column(name = "cpf_cnpj")
    private String cpfCnpj;

    @Size(max = 60, message = "Nome fantasia deve ter no máximo {max} caracteres")
    @Column(name = "nome_fantasia")
    private String nomeFantasia;

    @Size(max = 45, message = "Ramo atividade deve ter no máximo {max} caracteres")
    @Column(name = "ramo_atividade")
    private String ramoAtividade;

    @Size(max = 45, message = "RG deve ter no máximo {max} caracteres")
    private String rg;

    private LocalDate nascimento;

    @NotNull(message = "Informe se a pessoa está ativa")
    private Boolean ativo;

    @NotNull(message = "Informe se a pessoa está online")
    private Boolean online;

    @Column(name = "data_inclusao")
    private LocalDate dataInclusao;

    @Column(name = "data_alteracao")
    private LocalDate dataAlteracao;

}
