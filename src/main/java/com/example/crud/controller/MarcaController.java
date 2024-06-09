package com.example.crud.controller;

import com.example.crud.domain.Marca;
import com.example.crud.service.MarcaService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    private final MarcaService service;

    @GetMapping
    public List<Marca> getAllMarca() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Marca getMarcaById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Marca saveMarca(@RequestBody Marca marca) {
        return service.save(marca);
    }

    @PutMapping("/{id}")
    public Marca updateMarca(@PathVariable Long id, @RequestBody Marca marca) {
        Marca existingMarca = service.findById(id);
        existingMarca.setNome(marca.getNome());
        existingMarca.setCodigoDenatran(marca.getCodigoDenatran());
        existingMarca.setAtivo(marca.getAtivo());
        existingMarca.setModelos(marca.getModelos());
        return service.save(existingMarca);
    }

    @DeleteMapping("/{id}")
    public void deleteMarca(@PathVariable Long id) {
        service.deleteById(id);
    }
}
