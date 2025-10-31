package com.gft.palavras_api.usecase.etiqueta;

import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;

public interface BuscarEtiquetaPorIdService {
    EtiquetaResponseDTO buscarPorId(Long id);
}
