package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.service.domain.etiqueta.AtualizarEitquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarEitquetaServiceImpl implements AtualizarEitquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Etiqueta atualizarEtiqueta(Long id, Etiqueta etiquetaDetalhes) {
        Etiqueta etiqueta = etiquetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + id));

        etiqueta.setNome(etiquetaDetalhes.getNome());
        return etiquetaRepository.save(etiqueta);
    }
}
