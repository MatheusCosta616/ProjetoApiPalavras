package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.BuscarPalavraPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BuscarPalavraPorIdServiceImpl implements BuscarPalavraPorIdService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public PalavraResponseDTO buscarPorId(Long id) {
        Palavra palavra = palavraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada com id: " + id));
        
        Set<EtiquetaSimpleResponseDTO> etiquetasDTO = new HashSet<>();
        for (Etiqueta etiqueta : palavra.getEtiquetas()) {
            EtiquetaSimpleResponseDTO dto = new EtiquetaSimpleResponseDTO();
            dto.setId(etiqueta.getId());
            dto.setNome(etiqueta.getNome());
            etiquetasDTO.add(dto);
        }
        
        PalavraResponseDTO response = new PalavraResponseDTO();
        response.setId(palavra.getId());
        response.setTermo(palavra.getTermo());
        response.setEtiquetas(etiquetasDTO);
        
        return response;
    }
}
