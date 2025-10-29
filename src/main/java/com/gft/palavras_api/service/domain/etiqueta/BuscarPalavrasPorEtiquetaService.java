package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.dto.response.PalavraSimpleResponseDTO;

import java.util.Set;

public interface BuscarPalavrasPorEtiquetaService {
    Set<PalavraSimpleResponseDTO> buscarPalavrasPorEtiqueta(Long etiquetaId);
}
