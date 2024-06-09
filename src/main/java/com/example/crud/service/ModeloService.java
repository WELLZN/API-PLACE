package com.example.crud.service;

import com.example.crud.domain.Modelo;
import com.example.crud.repository.ModeloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ModeloService {

    private final ModeloRepository repository;

    public List<Modelo> findAll() {
        return repository.findAll();
    }

    public Modelo findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Modelo not found"));
    }

    public Modelo save(Modelo modelo) {
        return repository.save(modelo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
