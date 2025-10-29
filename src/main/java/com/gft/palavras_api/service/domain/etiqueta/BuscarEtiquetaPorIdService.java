package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.models.Etiqueta;

import java.util.Optional;

public interface BuscarEtiquetaPorIdService {
    Optional<Etiqueta> buscarPorId(Long id);
}
