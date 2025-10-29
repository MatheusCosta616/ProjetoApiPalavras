package com.gft.palavras_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public class PalavraRequestDTO {
    
    @NotBlank(message = "O termo não pode estar vazio")
    private String termo;

    public PalavraRequestDTO() {
    }

    public PalavraRequestDTO(String termo) {
        this.termo = termo;
    }

    public String getTermo() {
        return termo;
    }

    public void setTermo(String termo) {
        this.termo = termo;
    }
}
