package com.gft.palavras_api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "palavras")
@Data
@NoArgsConstructor
public class Palavra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String termo;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "palavra_etiqueta",
            joinColumns = @JoinColumn(name = "palavra_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )

    @JsonIgnoreProperties("palavras")
    private Set<Etiqueta> etiquetas = new HashSet<>();

    public Palavra(String termo) {
        this.termo = termo;
    }
}
