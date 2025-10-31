package com.gft.palavras_api.usecase.palavra.impl;

import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;
import com.gft.palavras_api.dto.response.PalavraSimpleResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.usecase.palavra.AdicionarPalavraNaEtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AdicionarPalavraNaEtiquetaImpl implements AdicionarPalavraNaEtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public EtiquetaResponseDTO adicionarPalavraNaEtiqueta(Long etiquetaId, Long palavraId) {

        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada"));

        Palavra palavra = palavraRepository.findById(palavraId)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada"));

        palavra.getEtiquetas().add(etiqueta);
        palavraRepository.save(palavra);

        Etiqueta saved = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada"));
        
        Set<PalavraSimpleResponseDTO> palavrasDTO = new HashSet<>();
        for (Palavra pal : saved.getPalavras()) {
            PalavraSimpleResponseDTO dto = new PalavraSimpleResponseDTO();
            dto.setId(pal.getId());
            dto.setTermo(pal.getTermo());
            palavrasDTO.add(dto);
        }
        
        EtiquetaResponseDTO response = new EtiquetaResponseDTO();
        response.setId(saved.getId());
        response.setNome(saved.getNome());
        response.setPalavras(palavrasDTO);
        
        return response;
    }
}
