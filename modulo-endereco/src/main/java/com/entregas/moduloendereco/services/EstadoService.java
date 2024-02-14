package com.entregas.moduloendereco.services;

import com.entregas.moduloendereco.entities.Estado;
import com.entregas.moduloendereco.repositories.EstadoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository repository;

    public List<Estado> findAll() {
        return repository.findAll();
    }

    public Estado find(String sigla) {
        String mensagem = "Não existe um cadastro de estado com a sigla ";
        return repository.findById(sigla.toUpperCase()).orElseThrow(
                () -> new RuntimeException(mensagem + sigla.toUpperCase())
        );
    }

    @Transactional
    public Estado insert(Estado entity) {
        if (entity.getSigla() == null) {
            throw new RuntimeException("A sigla do estado está nula");
        }
        entity.setSigla(entity.getSigla().toUpperCase());
        return repository.save(entity);
    }

    @Transactional
    public Estado update(Estado entity, String sigla) {
        Estado estado = find(sigla.toUpperCase());
        BeanUtils.copyProperties(entity, estado, "id");
        return repository.save(estado);
    }

    @Transactional
    public void delete(String sigla) {
        find(sigla);
        repository.deleteById(sigla.toUpperCase());
    }

}
