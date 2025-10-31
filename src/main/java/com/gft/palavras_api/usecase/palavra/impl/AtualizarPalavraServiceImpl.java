package com.gft.palavras_api.usecase.palavra.impl;

import com.gft.palavras_api.dto.request.PalavraRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.usecase.palavra.AtualizarPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AtualizarPalavraServiceImpl implements AtualizarPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public PalavraResponseDTO atualizar(Long id, PalavraRequestDTO palavraRequestDTO) {
        Palavra palavra = palavraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada com id: " + id));

        palavra.setTermo(palavraRequestDTO.getTermo());
        Palavra updated = palavraRepository.save(palavra);
        
        Set<EtiquetaSimpleResponseDTO> etiquetasDTO = new HashSet<>();
        for (Etiqueta etiqueta : updated.getEtiquetas()) {
            EtiquetaSimpleResponseDTO dto = new EtiquetaSimpleResponseDTO();
            dto.setId(etiqueta.getId());
            dto.setNome(etiqueta.getNome());
            etiquetasDTO.add(dto);
        }
        
        PalavraResponseDTO response = new PalavraResponseDTO();
        response.setId(updated.getId());
        response.setTermo(updated.getTermo());
        response.setEtiquetas(etiquetasDTO);
        
        return response;
    }
}
