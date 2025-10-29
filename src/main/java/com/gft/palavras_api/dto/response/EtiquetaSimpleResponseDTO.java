package com.gft.palavras_api.dto.response;

public class EtiquetaSimpleResponseDTO {
    
    private Long id;
    private String nome;

    public EtiquetaSimpleResponseDTO() {
    }

    public EtiquetaSimpleResponseDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
