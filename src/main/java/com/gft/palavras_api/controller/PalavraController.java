package com.gft.palavras_api.controller;

import com.gft.palavras_api.dto.request.PalavraRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;
import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.service.domain.palavra.*;
import com.gft.palavras_api.service.domain.palavra.impl.DeletarPalavraServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

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

    @PostMapping
    public ResponseEntity<?> criarPalavra(@RequestBody PalavraRequestDTO palavraRequestDTO){
        PalavraResponseDTO palavra = criarPalavraService.criarPalavra(palavraRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(palavra);
    }

    @GetMapping
    public ResponseEntity<EtiquetaSimpleResponseDTO> buscarEtiquetasPorPalavra(@RequestParam Long palavraId){
        Set<EtiquetaSimpleResponseDTO> etiquetas = buscarEtiquetasPorPalavraService.buscarEtiquetasPorPalavra(palavraId);
        return ResponseEntity.ok(etiquetas);
    }
}
