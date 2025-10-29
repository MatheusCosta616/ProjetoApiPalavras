package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.CriarPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarPalavraServiceImpl implements CriarPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public Palavra criarPalavra(Palavra palavra) {
        return palavraRepository.save(palavra);
    }
}
