package com.example.crud.service;

import com.example.crud.domain.Marca;
import com.example.crud.repository.MarcaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MarcaService {

    private final MarcaRepository repository;

    public List<Marca> findAll() {
        return repository.findAll();
    }

    public Marca findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Marca not found"));
    }

    public Marca save(Marca marca) {
        return repository.save(marca);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
