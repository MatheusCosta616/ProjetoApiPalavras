package com.gft.palavras_api.service.domain.palavra;

import com.gft.palavras_api.models.Etiqueta;

import java.util.Set;

public interface BuscarEtiquetasPorPalavraService {
    Set<Etiqueta> buscarEtiquetasPorPalavra(Long palavraId);
}
