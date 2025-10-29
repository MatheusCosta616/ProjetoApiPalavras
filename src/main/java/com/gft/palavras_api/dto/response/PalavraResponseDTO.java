package com.gft.palavras_api.dto.response;

import java.util.Set;

public class PalavraResponseDTO {
    
    private Long id;
    private String termo;
    private Set<EtiquetaSimpleResponseDTO> etiquetas;

    public PalavraResponseDTO() {
    }

    public PalavraResponseDTO(Long id, String termo, Set<EtiquetaSimpleResponseDTO> etiquetas) {
        this.id = id;
        this.termo = termo;
        this.etiquetas = etiquetas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }

    public Set<EtiquetaSimpleResponseDTO> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<EtiquetaSimpleResponseDTO> etiquetas) {
        this.etiquetas = etiquetas;
    }
}
