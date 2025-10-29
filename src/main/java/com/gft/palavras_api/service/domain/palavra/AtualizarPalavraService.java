package com.gft.palavras_api.service.domain.palavra;

import com.gft.palavras_api.models.Palavra;

public interface AtualizarPalavraService {
    Palavra atualizar(Long id, Palavra palavra);
}
