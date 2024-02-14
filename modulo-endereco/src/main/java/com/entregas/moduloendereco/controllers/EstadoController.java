package com.entregas.moduloendereco.controllers;

import com.entregas.moduloendereco.entities.Estado;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/estados")
public class EstadoController {

    @GetMapping
    public ResponseEntity<List<Estado>> findAll() {
        return null;
    }

    @GetMapping("/{sigla}")
    public ResponseEntity<Estado> find(@PathVariable String sigla) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Estado> insert(@Valid @RequestBody Estado entity) {
        return null;
    }

    @PutMapping("/{sigla}")
    public ResponseEntity<Void> update(@Valid @RequestBody Estado entity, @PathVariable String sigla) {
        return null;
    }

    @DeleteMapping("/{sigla}")
    public ResponseEntity<Void> delete(@PathVariable String sigla) {
        return null;
    }

}
