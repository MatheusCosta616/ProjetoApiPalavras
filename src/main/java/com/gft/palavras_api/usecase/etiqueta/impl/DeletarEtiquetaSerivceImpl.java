package com.gft.palavras_api.usecase.etiqueta.impl;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.usecase.etiqueta.DeletarEtiquetaSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletarEtiquetaSerivceImpl implements DeletarEtiquetaSerivce {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public void deletarEtiqueta(Long id) {
        Etiqueta etiqueta = etiquetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + id));
        etiquetaRepository.delete(etiqueta);
    }
}
