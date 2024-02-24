package com.entregas.moduloendereco.queries;

import com.entregas.moduloendereco.entities.Municipio;
import com.entregas.moduloendereco.filters.MunicipioFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MunicipioRepositoryQuery {

    public Page<Municipio> filtrar(MunicipioFilter filter, Pageable pageable);

}
