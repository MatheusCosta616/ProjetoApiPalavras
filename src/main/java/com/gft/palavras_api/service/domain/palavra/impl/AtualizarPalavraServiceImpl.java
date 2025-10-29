package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.AtualizarPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPalavraServiceImpl implements AtualizarPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public Palavra atualizar(Long id, Palavra palavraDetalhes) {
        Palavra palavra = palavraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + id));

        palavra.setTermo(palavraDetalhes.getTermo());
        return palavraRepository.save(palavra);
    }
}
