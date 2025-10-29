package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.models.Palavra;

public interface AdicionarEtiquetaNaPalavraService {
    Palavra adicionarEtiquetaNaPalavra(Long palavraId, Long etiquetaId);
}
