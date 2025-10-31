package com.gft.palavras_api.usecase.palavra;

import com.gft.palavras_api.dto.response.PalavraResponseDTO;

import java.util.List;

public interface ListarTodasPalavrasService {
    List<PalavraResponseDTO> listarTodas();
}
