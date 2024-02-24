package com.entregas.moduloendereco.resources;

import com.entregas.moduloendereco.entities.Municipio;
import com.entregas.moduloendereco.filters.MunicipioFilter;
import com.entregas.moduloendereco.services.MunicipioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/municipios")
public class MunicipioResource {

    @Autowired
    private MunicipioService service;

    @GetMapping
    public ResponseEntity<List<Municipio>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

//    @GetMapping("/page")
//    public Page<Municipio> findPage(MunicipioFilter filter, Pageable pageable) {
//        return service.findPage(filter, pageable);
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Municipio> find(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.find(id));
    }

    @GetMapping("/estado/{uf}")
    public ResponseEntity<List<Municipio>> listByEstado(@PathVariable String uf) {
        List<Municipio> municipios = service.listByEstado(uf);
        return ResponseEntity.ok(municipios);
    }

    @PostMapping
    public ResponseEntity<Municipio> insert(@Valid @RequestBody Municipio entity) {
        Municipio savedEntity = service.insert(entity);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(savedEntity.getId()).toUri();
        return ResponseEntity.status(HttpStatus.CREATED).location(uri).body(savedEntity);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@Valid @RequestBody Municipio entity, @PathVariable Long id) {
        service.update(entity, id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
