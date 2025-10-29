package com.gft.palavras_api.dto.request;

import jakarta.validation.constraints.NotNull;

public class AdicionarPalavraRequestDTO {
    
    @NotNull(message = "O ID da etiqueta não pode ser nulo")
    private Long etiquetaId;
    
    @NotNull(message = "O ID da palavra não pode ser nulo")
    private Long palavraId;

    public AdicionarPalavraRequestDTO() {
    }

    public AdicionarPalavraRequestDTO(Long etiquetaId, Long palavraId) {
        this.etiquetaId = etiquetaId;
        this.palavraId = palavraId;
    }

    public Long getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(Long etiquetaId) {
        this.etiquetaId = etiquetaId;
    }

    public Long getPalavraId() {
        return palavraId;
    }

    public void setPalavraId(Long palavraId) {
        this.palavraId = palavraId;
    }
}
