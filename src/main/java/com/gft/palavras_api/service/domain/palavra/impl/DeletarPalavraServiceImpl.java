package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.DeletarPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarPalavraServiceImpl implements DeletarPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public void deletarPalavra(Long id) {
        Palavra palavra = palavraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada com id: " + id));
        palavraRepository.delete(palavra);
    }
}
