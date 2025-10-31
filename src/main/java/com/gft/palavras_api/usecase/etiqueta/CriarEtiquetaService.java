package com.gft.palavras_api.usecase.etiqueta;

import com.gft.palavras_api.dto.request.EtiquetaRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;

public interface CriarEtiquetaService {
    EtiquetaResponseDTO criarEtiqueta(EtiquetaRequestDTO etiquetaRequestDTO);
}
