package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.dto.request.PalavraRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.CriarPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CriarPalavraServiceImpl implements CriarPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public PalavraResponseDTO criarPalavra(PalavraRequestDTO palavraRequestDTO) {
        Palavra palavra = new Palavra(palavraRequestDTO.getTermo());
        Palavra saved = palavraRepository.save(palavra);
        
        Set<EtiquetaSimpleResponseDTO> etiquetasDTO = new HashSet<>();
        for (Etiqueta etiqueta : saved.getEtiquetas()) {
            EtiquetaSimpleResponseDTO dto = new EtiquetaSimpleResponseDTO();
            dto.setId(etiqueta.getId());
            dto.setNome(etiqueta.getNome());
            etiquetasDTO.add(dto);
        }
        
        PalavraResponseDTO response = new PalavraResponseDTO();
        response.setId(saved.getId());
        response.setTermo(saved.getTermo());
        response.setEtiquetas(etiquetasDTO);
        
        return response;
    }
}
