package com.entregas.moduloendereco.resources;

import com.entregas.moduloendereco.entities.Estado;
import com.entregas.moduloendereco.services.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/estados")
public class EstadoResource {

    @Autowired
    private EstadoService service;

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{sigla}")
    public ResponseEntity<Estado> find(@PathVariable String sigla) {
        return ResponseEntity.ok().body(service.find(sigla));
    }

    @PostMapping
    public ResponseEntity<Estado> insert(@Valid @RequestBody Estado entity) {
        Estado savedEntity = service.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{sigla}").buildAndExpand(savedEntity.getSigla()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(savedEntity);
    }

    @PutMapping("/{sigla}")
    public ResponseEntity<Void> update(@Valid @RequestBody Estado entity, @PathVariable String sigla) {
        service.update(entity, sigla);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{sigla}")
    public ResponseEntity<Void> delete(@PathVariable String sigla) {
        service.delete(sigla);
        return ResponseEntity.noContent().build();
    }

}
