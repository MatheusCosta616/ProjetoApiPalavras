package com.gft.palavras_api.usecase.etiqueta.impl;

import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;
import com.gft.palavras_api.dto.response.PalavraSimpleResponseDTO;
import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import com.gft.palavras_api.usecase.etiqueta.ListarTodasEtiquetasSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ListarTodasEtiquetasSerivceImpl implements ListarTodasEtiquetasSerivce {
    @Autowired
    private EtiquetaRepository etiquetaRepository;
    
    @Override
    public List<EtiquetaResponseDTO> listarTodas() {
        List<Etiqueta> etiquetas = etiquetaRepository.findAll();
        List<EtiquetaResponseDTO> response = new ArrayList<>();
        
        for (Etiqueta etiqueta : etiquetas) {
            Set<PalavraSimpleResponseDTO> palavrasDTO = new HashSet<>();
            for (Palavra palavra : etiqueta.getPalavras()) {
                PalavraSimpleResponseDTO palDTO = new PalavraSimpleResponseDTO();
                palDTO.setId(palavra.getId());
                palDTO.setTermo(palavra.getTermo());
                palavrasDTO.add(palDTO);
            }
            
            EtiquetaResponseDTO dto = new EtiquetaResponseDTO();
            dto.setId(etiqueta.getId());
            dto.setNome(etiqueta.getNome());
            dto.setPalavras(palavrasDTO);
            response.add(dto);
        }
        
        return response;
    }
}
