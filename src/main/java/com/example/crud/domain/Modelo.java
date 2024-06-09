package com.example.crud.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer ano;
    private Boolean ativo;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
}
