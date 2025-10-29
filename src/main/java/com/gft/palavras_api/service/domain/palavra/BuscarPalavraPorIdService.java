package com.gft.palavras_api.service.domain.palavra;

import com.gft.palavras_api.models.Palavra;

import java.util.Optional;

public interface BuscarPalavraPorIdService {
    Optional<Palavra> buscarPorId(Long id);
}
