package com.gft.palavras_api.dto.request;

import jakarta.validation.constraints.NotBlank;

public class EtiquetaRequestDTO {
    
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    public EtiquetaRequestDTO() {
    }

    public EtiquetaRequestDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
