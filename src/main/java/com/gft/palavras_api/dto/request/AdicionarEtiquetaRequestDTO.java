package com.gft.palavras_api.dto.request;

import jakarta.validation.constraints.NotNull;

public class AdicionarEtiquetaRequestDTO {
    
    @NotNull(message = "O ID da palavra não pode ser nulo")
    private Long palavraId;
    
    @NotNull(message = "O ID da etiqueta não pode ser nulo")
    private Long etiquetaId;

    public AdicionarEtiquetaRequestDTO() {
    }

    public AdicionarEtiquetaRequestDTO(Long palavraId, Long etiquetaId) {
        this.palavraId = palavraId;
        this.etiquetaId = etiquetaId;
    }

    public Long getPalavraId() {
        return palavraId;
    }

    public void setPalavraId(Long palavraId) {
        this.palavraId = palavraId;
    }

    public Long getEtiquetaId() {
        return etiquetaId;
    }

    public void setEtiquetaId(Long etiquetaId) {
        this.etiquetaId = etiquetaId;
    }
}
