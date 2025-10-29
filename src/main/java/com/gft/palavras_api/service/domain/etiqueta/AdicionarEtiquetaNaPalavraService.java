package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.dto.response.PalavraResponseDTO;

public interface AdicionarEtiquetaNaPalavraService {
    PalavraResponseDTO adicionarEtiquetaNaPalavra(Long palavraId, Long etiquetaId);
}
