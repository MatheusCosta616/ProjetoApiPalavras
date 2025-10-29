package com.gft.palavras_api.service;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.repository.PalavraRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PalavraService {
    @Autowired
    private PalavraRepository palavraRepository;


    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Transactional
    public Palavra criarPalavra(Palavra palavra) {
        return palavraRepository.save(palavra);
    }

    public List<Palavra> listarTodas() {
        return palavraRepository.findAll();
    }

    public Set<Etiqueta> buscarEtiquetasPorPalavra(Long palavraId) {
        Palavra palavra = palavraRepository.findById(palavraId)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada com id: " + palavraId));
        return palavra.getEtiquetas();
    }

    @Transactional
    public Palavra adicionarEtiquetaNaPalavra(Long palavraId, Long etiquetaId) {

        Palavra palavra = palavraRepository.findById(palavraId)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada"));

        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada"));

        palavra.getEtiquetas().add(etiqueta);

        return palavraRepository.save(palavra);
    }
}
