package com.gft.palavras_api.controller;

import com.gft.palavras_api.service.domain.palavra.*;
import com.gft.palavras_api.service.domain.palavra.impl.DeletarPalavraServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/palavras")
public class PalavraController {
    private final AtualizarPalavraService atualizarPalavraService;
    private final BuscarEtiquetasPorPalavraService buscarEtiquetasPorPalavraService;
    private final CriarPalavraService criarPalavraService;
    private final DeletarPalavraService deletarPalavraService;
    private final ListarTodasPalavrasService listarTodasPalavrasService;

    public PalavraController(AtualizarPalavraService atualizarPalavraService, BuscarEtiquetasPorPalavraService buscarEtiquetasPorPalavraService, BuscarPalavraPorIdService buscarPalavraPorIdService, CriarPalavraService criarPalavraService, DeletarPalavraService deletarPalavraService, ListarTodasPalavrasService listarTodasPalavrasService) {
        this.atualizarPalavraService = atualizarPalavraService;
        this.buscarEtiquetasPorPalavraService = buscarEtiquetasPorPalavraService;
        this.criarPalavraService = criarPalavraService;
        this.deletarPalavraService = deletarPalavraService;
        this.listarTodasPalavrasService = listarTodasPalavrasService;
    }


}
