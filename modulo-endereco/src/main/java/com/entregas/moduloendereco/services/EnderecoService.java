package com.entregas.moduloendereco.services;

import com.entregas.moduloendereco.entities.Endereco;
import com.entregas.moduloendereco.repositories.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired private EnderecoRepository repository;

    public List<Endereco> findAll() {
        return repository.findAll();
    }

    public Endereco find(Long id) {
        Optional<Endereco> optional = repository.findById(id);
        if (!optional.isPresent()) {
            throw new RuntimeException("Endereço não encontrado");
        }
        return optional.get();
    }

    @Transactional
    public Endereco insert(Endereco entity) {
        if (entity.getId() != null) {
            throw new RuntimeException(
                    "Operação de inserção com atributo ID. Verifique se o intuito era atualizar."
            );
        }
        return repository.save(entity);
    }

    @Transactional
    public Endereco update(Endereco entity, Long id) {
        Endereco endereco = find(id);
        BeanUtils.copyProperties(entity, endereco, "id");
        return repository.save(endereco);
    }

    @Transactional
    public void delete(Long id) {
        find(id);
        repository.deleteById(id);
    }

}
