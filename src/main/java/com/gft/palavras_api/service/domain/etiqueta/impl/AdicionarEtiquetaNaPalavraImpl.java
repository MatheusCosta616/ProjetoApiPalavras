package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.etiqueta.AdicionarEtiquetaNaPalavraService;
import org.springframework.beans.factory.annotation.Autowired;

public class AdicionarEtiquetaNaPalavraImpl implements AdicionarEtiquetaNaPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Palavra adicionarEtiquetaNaPalavra(Long palavraId, Long etiquetaId) {

        Palavra palavra = palavraRepository.findById(palavraId)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada"));

        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada"));

        palavra.getEtiquetas().add(etiqueta);

        return palavraRepository.save(palavra);
    }
}
