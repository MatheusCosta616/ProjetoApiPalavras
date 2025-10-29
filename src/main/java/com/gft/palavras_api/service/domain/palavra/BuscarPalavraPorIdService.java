package com.gft.palavras_api.service.domain.palavra;

import com.gft.palavras_api.dto.response.PalavraResponseDTO;

public interface BuscarPalavraPorIdService {
    PalavraResponseDTO buscarPorId(Long id);
}
