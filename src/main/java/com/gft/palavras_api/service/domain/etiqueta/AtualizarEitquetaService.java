package com.gft.palavras_api.service.domain.etiqueta;

import com.gft.palavras_api.models.Etiqueta;

public interface AtualizarEitquetaService {
    Etiqueta atualizarEtiqueta(Long id, Etiqueta etiquetaDetalhes);
}
