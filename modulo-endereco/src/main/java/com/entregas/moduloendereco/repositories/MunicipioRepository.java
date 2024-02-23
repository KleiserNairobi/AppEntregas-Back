package com.entregas.moduloendereco.repositories;

import com.entregas.moduloendereco.entities.Estado;
import com.entregas.moduloendereco.entities.Municipio;
import com.entregas.moduloendereco.queries.MunicipioRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MunicipioRepository extends JpaRepository<Municipio, Long>, MunicipioRepositoryQuery {

    @Query(" from Municipio m where m.estado = :estado order by m.estado, m.nome ")
    List<Municipio> findByEstado(@Param("estado") Estado estado);

    Optional<Municipio> findByNomeAndEstado(String nome, Estado estado);

    @Query("SELECT COUNT(m.id) > 0 FROM Municipio m WHERE m.cobertura = true AND m.estado = :estado AND m.nome = :nome")
    Boolean isMunicipioComCobertura(@Param("nome") String nome, @Param("estado") Estado estado);

}
