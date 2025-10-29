package com.gft.palavras_api.service.domain.palavra;

import com.gft.palavras_api.dto.request.PalavraRequestDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;

public interface CriarPalavraService {
    PalavraResponseDTO criarPalavra(PalavraRequestDTO palavraRequestDTO);
}
