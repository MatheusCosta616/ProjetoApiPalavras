package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.dto.request.EtiquetaRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;

public interface CriarEtiquetaService {
    EtiquetaResponseDTO criarEtiqueta(EtiquetaRequestDTO etiquetaRequestDTO);
}
