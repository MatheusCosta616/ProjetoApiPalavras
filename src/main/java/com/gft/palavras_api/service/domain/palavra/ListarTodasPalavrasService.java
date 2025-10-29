package com.gft.palavras_api.service.domain.palavra;

import com.gft.palavras_api.dto.response.PalavraResponseDTO;

import java.util.List;

public interface ListarTodasPalavrasService {
    List<PalavraResponseDTO> listarTodas();
}
