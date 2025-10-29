package com.gft.palavras_api.repository;

import com.gft.palavras_api.models.Palavra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PalavraRepository extends JpaRepository<Palavra, Long> {
}
