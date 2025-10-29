package com.gft.palavras_api.dto.response;

public class PalavraSimpleResponseDTO {
    
    private Long id;
    private String termo;

    public PalavraSimpleResponseDTO() {
    }

    public PalavraSimpleResponseDTO(Long id, String termo) {
        this.id = id;
        this.termo = termo;
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
}
