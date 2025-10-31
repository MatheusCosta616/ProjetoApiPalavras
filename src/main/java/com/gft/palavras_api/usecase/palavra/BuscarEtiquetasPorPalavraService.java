package com.gft.palavras_api.usecase.palavra;

import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;

import java.util.Set;

public interface BuscarEtiquetasPorPalavraService {
    Set<EtiquetaSimpleResponseDTO> buscarEtiquetasPorPalavra(Long palavraId);
}
