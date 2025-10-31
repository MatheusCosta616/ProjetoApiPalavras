package com.gft.palavras_api.usecase.etiqueta.impl;

import com.gft.palavras_api.dto.response.PalavraSimpleResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.usecase.etiqueta.BuscarPalavrasPorEtiquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BuscarPalavrasPorEtiquetaServiceImpl implements BuscarPalavrasPorEtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public Set<PalavraSimpleResponseDTO> buscarPalavrasPorEtiqueta(Long etiquetaId) {
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + etiquetaId));

        Set<PalavraSimpleResponseDTO> palavrasDTO = new HashSet<>();
        for (Palavra palavra : etiqueta.getPalavras()) {
            PalavraSimpleResponseDTO dto = new PalavraSimpleResponseDTO();
            dto.setId(palavra.getId());
            dto.setTermo(palavra.getTermo());
            palavrasDTO.add(dto);
        }
        
        return palavrasDTO;
    }
}
