package com.gft.palavras_api.repository;

import com.gft.palavras_api.models.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository extends JpaRepository<Etiqueta, Long> {
}
