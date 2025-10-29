package com.gft.palavras_api.service.domain.palavra;

import com.gft.palavras_api.dto.request.PalavraRequestDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;

public interface AtualizarPalavraService {
    PalavraResponseDTO atualizar(Long id, PalavraRequestDTO palavraRequestDTO);
}
