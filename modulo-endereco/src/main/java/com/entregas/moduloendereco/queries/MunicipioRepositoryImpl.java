package com.entregas.moduloendereco.queries;

import com.entregas.moduloendereco.entities.Municipio;
import com.entregas.moduloendereco.filters.MunicipioFilter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MunicipioRepositoryImpl implements MunicipioRepositoryQuery {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Municipio> filtrar(MunicipioFilter filter, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Municipio> criteriaQuery = criteriaBuilder.createQuery(Municipio.class);
        Root<Municipio> root = criteriaQuery.from(Municipio.class);
        Predicate[] predicates = criarRestricoes(filter, criteriaBuilder, root);
        criteriaQuery.where(predicates);
        TypedQuery<Municipio> typedQuery = this.entityManager.createQuery(criteriaQuery);
        adicionarRestricaoDePaginacao(typedQuery, pageable);

        return new PageImpl<>(typedQuery.getResultList(), pageable, total(filter));
    }

    private Predicate[] criarRestricoes(
            MunicipioFilter filter,
            CriteriaBuilder criteriaBuilder,
            Root<Municipio> root
    ) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(filter.getNome())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), "%" + filter.getNome().toLowerCase() + "%"));
        }
        if (!StringUtils.isEmpty(filter.getUf())) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("estado").get("sigla")), "%" + filter.getUf().toLowerCase() + "%"));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionarRestricaoDePaginacao(TypedQuery<?> typedQuery, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistroPorPagina = pageable.getPageSize();
        int primeiroRegistroDaPagina = paginaAtual * totalRegistroPorPagina;

        typedQuery.setFirstResult(primeiroRegistroDaPagina);
        typedQuery.setMaxResults(totalRegistroPorPagina);
    }

    private Long total(MunicipioFilter filter) {
        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteriaQuery = criteriaBuilder.createQuery(Long.class);
        Root<Municipio> root = criteriaQuery.from(Municipio.class);
        Predicate[] predicates = criarRestricoes(filter, criteriaBuilder, root);
        criteriaQuery.where(predicates);
        criteriaQuery.select(criteriaBuilder.count(root));

        return this.entityManager.createQuery(criteriaQuery).getSingleResult();
    }

}
