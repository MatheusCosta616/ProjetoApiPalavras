package com.gft.palavras_api.service.domain.palavra.impl;

import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.PalavraRepository;
import com.gft.palavras_api.service.domain.palavra.ListarTodasPalavrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ListarTodasPalavrasServiceImpl implements ListarTodasPalavrasService {
    @Autowired
    private PalavraRepository palavraRepository;

    @Override
    public List<PalavraResponseDTO> listarTodas() {
        List<Palavra> palavras = palavraRepository.findAll();
        List<PalavraResponseDTO> response = new ArrayList<>();
        
        for (Palavra palavra : palavras) {
            Set<EtiquetaSimpleResponseDTO> etiquetasDTO = new HashSet<>();
            for (Etiqueta etiqueta : palavra.getEtiquetas()) {
                EtiquetaSimpleResponseDTO etiDTO = new EtiquetaSimpleResponseDTO();
                etiDTO.setId(etiqueta.getId());
                etiDTO.setNome(etiqueta.getNome());
                etiquetasDTO.add(etiDTO);
            }
            
            PalavraResponseDTO dto = new PalavraResponseDTO();
            dto.setId(palavra.getId());
            dto.setTermo(palavra.getTermo());
            dto.setEtiquetas(etiquetasDTO);
            response.add(dto);
        }
        
        return response;
    }
}
