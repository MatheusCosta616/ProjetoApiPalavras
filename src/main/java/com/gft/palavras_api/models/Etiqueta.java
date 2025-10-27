package com.gft.palavras_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "etiquetas")
@Data
@NoArgsConstructor
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToMany(mappedBy = "etiquetas", fetch = FetchType.LAZY)

    @JsonIgnoreProperties("etiquetas")
    private Set<Palavra> palavras = new HashSet<>();

    public Etiqueta(String nome) {
        this.nome = nome;
    }
}
