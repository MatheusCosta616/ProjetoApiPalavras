package com.gft.palavras_api.usecase.palavra;

import com.gft.palavras_api.dto.response.PalavraResponseDTO;

public interface BuscarPalavraPorIdService {
    PalavraResponseDTO buscarPorId(Long id);
}
