package com.gft.palavras_api.usecase.etiqueta;

import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;

import java.util.List;

public interface ListarTodasEtiquetasSerivce {
   List<EtiquetaResponseDTO> listarTodas();
}
