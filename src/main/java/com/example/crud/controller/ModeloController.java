package com.example.crud.controller;
import com.example.crud.domain.Modelo;
import com.example.crud.service.ModeloService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/modelo")
public class ModeloController {
    //localhost:8080/modelo
    @Autowired
    private final ModeloService service;

    @GetMapping
    public List<Modelo> getAllModelo() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Modelo getModeloById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Modelo saveModelo(@RequestBody Modelo modelo) {
        return service.save(modelo);
    }

    @PutMapping("/{id}")
    public Modelo updateModelo(@PathVariable Long id, @RequestBody Modelo modelo) {
        Modelo existingModelo = service.findById(id);
        existingModelo.setNome(modelo.getNome());
        existingModelo.setAno(modelo.getAno());
        existingModelo.setAtivo(modelo.getAtivo());
        existingModelo.setMarca(modelo.getMarca());
        return service.save(existingModelo);
    }

    @DeleteMapping("/{id}")
    public void deleteModelo(@PathVariable Long id) {
        service.deleteById(id);
    }
}
