package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.service.domain.etiqueta.ListarTodasEtiquetasSerivce;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListarTodasEtiquetasSerivceImpl implements ListarTodasEtiquetasSerivce {
    @Autowired
    private EtiquetaRepository etiquetaRepository;
    @Override
    public List<Etiqueta> listarTodas() {
        return etiquetaRepository.findAll();
    }
}
