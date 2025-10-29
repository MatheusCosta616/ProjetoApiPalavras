package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.service.domain.etiqueta.CriarEtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarEtiquetaSeriveImpl implements CriarEtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Etiqueta criarEtiqueta(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }
}
