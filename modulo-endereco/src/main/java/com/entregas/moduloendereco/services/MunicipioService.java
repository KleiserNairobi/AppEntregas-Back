package com.entregas.moduloendereco.services;

import com.entregas.moduloendereco.entities.Estado;
import com.entregas.moduloendereco.entities.Municipio;
import com.entregas.moduloendereco.filters.MunicipioFilter;
import com.entregas.moduloendereco.repositories.MunicipioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {

    @Autowired
    private MunicipioRepository repository;
    @Autowired
    private EstadoService estadoService;

    public List<Municipio> findAll() {
        return repository.findAll();
    }

    public Page<Municipio> findPage(MunicipioFilter filter, Pageable pageable) {
        return repository.filtrar(filter, pageable);
    }

    public Municipio find(Long id) {
        String mensagem = "Não existe um cadastro de município com o id " + id;
        return repository.findById(id).orElseThrow(() -> new RuntimeException(mensagem));
    }

    public List<Municipio> listByEstado(String uf) {
        Estado estado = estadoService.find(uf.toUpperCase());
        return repository.findByEstado(estado);
    }

    public Boolean isMunicipioComCobertura(String nome, String uf) {
        Estado estado = estadoService.find(uf.toUpperCase());
        findByNomeAndEstado(nome.toUpperCase(), uf.toUpperCase());
        return repository.isMunicipioComCobertura(nome.toUpperCase(), estado);
    }

    @Transactional
    public Municipio insert(Municipio entity) {
        if (entity.getId() != null) {
            throw new RuntimeException(
                    "Operação de inserção com atributo ID. Verifique se o intuito era atualizar."
            );
        }
        if (entity.getEstado().getSigla() == null) {
            throw new RuntimeException("A sigla do estado está nula");
        }
        Estado estado = estadoService.find(entity.getEstado().getSigla().toUpperCase());
        entity.setEstado(estado);
        return repository.save(entity);
    }

    @Transactional
    public Municipio update(Municipio entity, Long id) {
        Municipio municipio = find(id);
        BeanUtils.copyProperties(entity, municipio, "id");
        return repository.save(municipio);
    }

    @Transactional
    public void delete(Long id) {
        find(id);
        repository.deleteById(id);
    }

    public Municipio findByNomeAndEstado(String nome, String sigla) {
        Estado estado = estadoService.find(sigla);
        Optional<Municipio> optional = repository.findByNomeAndEstado(nome.toUpperCase(), estado);
        if (!optional.isPresent()) {
            throw new RuntimeException("Município não encontrado");
        }
        return optional.get();
    }


}
