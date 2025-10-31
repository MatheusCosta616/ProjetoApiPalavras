package com.gft.palavras_api.usecase.etiqueta;

import com.gft.palavras_api.dto.response.PalavraResponseDTO;

public interface AdicionarEtiquetaNaPalavraService {
    PalavraResponseDTO adicionarEtiquetaNaPalavra(Long palavraId, Long etiquetaId);
}
