package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.BuscarPalavraPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarPalavraPorIdServiceImpl implements BuscarPalavraPorIdService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public Optional<Palavra> buscarPorId(Long id) {
        return palavraRepository.findById(id);
    }
}
