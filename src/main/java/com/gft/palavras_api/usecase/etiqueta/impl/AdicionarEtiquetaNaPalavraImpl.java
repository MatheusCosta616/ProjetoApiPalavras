package com.gft.palavras_api.usecase.etiqueta.impl;

import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.usecase.etiqueta.AdicionarEtiquetaNaPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdicionarEtiquetaNaPalavraImpl implements AdicionarEtiquetaNaPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public PalavraResponseDTO adicionarEtiquetaNaPalavra(Long palavraId, Long etiquetaId) {

        Palavra palavra = palavraRepository.findById(palavraId)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada"));

        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada"));

        palavra.getEtiquetas().add(etiqueta);

        Palavra saved = palavraRepository.save(palavra);
        
        Set<EtiquetaSimpleResponseDTO> etiquetasDTO = new HashSet<>();
        for (Etiqueta eti : saved.getEtiquetas()) {
            EtiquetaSimpleResponseDTO dto = new EtiquetaSimpleResponseDTO();
            dto.setId(eti.getId());
            dto.setNome(eti.getNome());
            etiquetasDTO.add(dto);
        }
        
        PalavraResponseDTO response = new PalavraResponseDTO();
        response.setId(saved.getId());
        response.setTermo(saved.getTermo());
        response.setEtiquetas(etiquetasDTO);
        
        return response;
    }
}
