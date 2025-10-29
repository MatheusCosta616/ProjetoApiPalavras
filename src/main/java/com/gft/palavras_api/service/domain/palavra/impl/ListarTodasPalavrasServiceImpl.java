package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.ListarTodasPalavrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarTodasPalavrasServiceImpl implements ListarTodasPalavrasService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public List<Palavra> listarTodas() {
        return palavraRepository.findAll();
    }
}
