package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.dto.request.EtiquetaRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;
import com.gft.palavras_api.dto.response.PalavraSimpleResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.service.domain.etiqueta.CriarEtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CriarEtiquetaSeriveImpl implements CriarEtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public EtiquetaResponseDTO criarEtiqueta(EtiquetaRequestDTO etiquetaRequestDTO) {
        Etiqueta etiqueta = new Etiqueta(etiquetaRequestDTO.getNome());
        Etiqueta saved = etiquetaRepository.save(etiqueta);
        
        Set<PalavraSimpleResponseDTO> palavrasDTO = new HashSet<>();
        for (Palavra palavra : saved.getPalavras()) {
            PalavraSimpleResponseDTO dto = new PalavraSimpleResponseDTO();
            dto.setId(palavra.getId());
            dto.setTermo(palavra.getTermo());
            palavrasDTO.add(dto);
        }
        
        EtiquetaResponseDTO response = new EtiquetaResponseDTO();
        response.setId(saved.getId());
        response.setNome(saved.getNome());
        response.setPalavras(palavrasDTO);
        
        return response;
    }
}
