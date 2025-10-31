package com.gft.palavras_api.usecase.palavra;

import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;

public interface AdicionarPalavraNaEtiquetaService {
    EtiquetaResponseDTO adicionarPalavraNaEtiqueta(Long etiquetaId, Long palavraId);
}
