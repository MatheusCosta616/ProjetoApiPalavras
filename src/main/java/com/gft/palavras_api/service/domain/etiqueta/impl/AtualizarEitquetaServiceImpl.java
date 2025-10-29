package com.gft.palavras_api.service.domain.etiqueta.impl;

import com.gft.palavras_api.dto.request.EtiquetaRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;
import com.gft.palavras_api.dto.response.PalavraSimpleResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.service.domain.etiqueta.AtualizarEitquetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class AtualizarEitquetaServiceImpl implements AtualizarEitquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Override
    public EtiquetaResponseDTO atualizarEtiqueta(Long id, EtiquetaRequestDTO etiquetaRequestDTO) {
        Etiqueta etiqueta = etiquetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + id));

        etiqueta.setNome(etiquetaRequestDTO.getNome());
        Etiqueta updated = etiquetaRepository.save(etiqueta);
        
        Set<PalavraSimpleResponseDTO> palavrasDTO = new HashSet<>();
        for (Palavra palavra : updated.getPalavras()) {
            PalavraSimpleResponseDTO dto = new PalavraSimpleResponseDTO();
            dto.setId(palavra.getId());
            dto.setTermo(palavra.getTermo());
            palavrasDTO.add(dto);
        }
        
        EtiquetaResponseDTO response = new EtiquetaResponseDTO();
        response.setId(updated.getId());
        response.setNome(updated.getNome());
        response.setPalavras(palavrasDTO);
        
        return response;
    }
}
