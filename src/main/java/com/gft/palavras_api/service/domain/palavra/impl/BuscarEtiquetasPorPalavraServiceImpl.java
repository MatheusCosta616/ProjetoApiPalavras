package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.BuscarEtiquetasPorPalavraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BuscarEtiquetasPorPalavraServiceImpl implements BuscarEtiquetasPorPalavraService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public Set<EtiquetaSimpleResponseDTO> buscarEtiquetasPorPalavra(Long palavraId) {
        Palavra palavra = palavraRepository.findById(palavraId)
                .orElseThrow(() -> new RuntimeException("Palavra não encontrada com id: " + palavraId));
        
        Set<EtiquetaSimpleResponseDTO> etiquetasDTO = new HashSet<>();
        for (Etiqueta etiqueta : palavra.getEtiquetas()) {
            EtiquetaSimpleResponseDTO dto = new EtiquetaSimpleResponseDTO();
            dto.setId(etiqueta.getId());
            dto.setNome(etiqueta.getNome());
            etiquetasDTO.add(dto);
        }
        
        return etiquetasDTO;
    }
}
