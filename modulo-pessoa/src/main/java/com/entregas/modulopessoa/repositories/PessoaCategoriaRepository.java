package com.entregas.modulopessoa.repositories;

import com.entregas.modulopessoa.entities.PessoaCategoria;
import com.entregas.modulopessoa.entities.PessoaCategoriaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaCategoriaRepository extends JpaRepository<PessoaCategoria, PessoaCategoriaId> {
}
