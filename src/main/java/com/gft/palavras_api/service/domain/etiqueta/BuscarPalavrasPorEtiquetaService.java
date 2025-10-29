package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.models.Palavra;

import java.util.Set;

public interface BuscarPalavrasPorEtiquetaService {
    Set<Palavra> buscarPalavrasPorEtiqueta(Long etiquetaId);
}
