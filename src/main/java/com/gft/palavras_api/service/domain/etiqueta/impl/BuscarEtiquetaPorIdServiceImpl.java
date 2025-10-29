package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.service.domain.etiqueta.BuscarEtiquetaPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarEtiquetaPorIdServiceImpl implements BuscarEtiquetaPorIdService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Optional<Etiqueta> buscarPorId(Long id) {
        return etiquetaRepository.findById(id);
    }
}
