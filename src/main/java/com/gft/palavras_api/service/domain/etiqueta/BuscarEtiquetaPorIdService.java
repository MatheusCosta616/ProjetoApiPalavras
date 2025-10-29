package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;

public interface BuscarEtiquetaPorIdService {
    EtiquetaResponseDTO buscarPorId(Long id);
}
