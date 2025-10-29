package com.gft.palavras_api.dto.response;

import java.util.Set;

public class EtiquetaResponseDTO {
    
    private Long id;
    private String nome;
    private Set<PalavraSimpleResponseDTO> palavras;

    public EtiquetaResponseDTO() {
    }

    public EtiquetaResponseDTO(Long id, String nome, Set<PalavraSimpleResponseDTO> palavras) {
        this.id = id;
        this.nome = nome;
        this.palavras = palavras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<PalavraSimpleResponseDTO> getPalavras() {
        return palavras;
    }

    public void setPalavras(Set<PalavraSimpleResponseDTO> palavras) {
        this.palavras = palavras;
    }
}
