package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.service.domain.etiqueta.BuscarPalavrasPorEtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

public class BuscarPalavrasPorEtiquetaServiceImpl implements BuscarPalavrasPorEtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Set<Palavra> buscarPalavrasPorEtiqueta(Long etiquetaId) {
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + etiquetaId));

        return etiqueta.getPalavras();
    }
}
