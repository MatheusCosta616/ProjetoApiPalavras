package com.gft.palavras_api.controller;

import com.gft.palavras_api.dto.request.PalavraRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;
import com.gft.palavras_api.dto.response.EtiquetaSimpleResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.usecase.palavra.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/palavras")
public class PalavraController {
    private final AdicionarPalavraNaEtiquetaService adicionarPalavraNaEtiquetaService;
    private final AtualizarPalavraService atualizarPalavraService;
    private final BuscarEtiquetasPorPalavraService buscarEtiquetasPorPalavraService;
    private final BuscarPalavraPorIdService buscarPalavraPorIdService;
    private final CriarPalavraService criarPalavraService;
    private final DeletarPalavraService deletarPalavraService;
    private final ListarTodasPalavrasService listarTodasPalavrasService;

    public PalavraController(AdicionarPalavraNaEtiquetaService adicionarPalavraNaEtiquetaService,
                             AtualizarPalavraService atualizarPalavraService, 
                             BuscarEtiquetasPorPalavraService buscarEtiquetasPorPalavraService, 
                             BuscarPalavraPorIdService buscarPalavraPorIdService, 
                             CriarPalavraService criarPalavraService, 
                             DeletarPalavraService deletarPalavraService, 
                             ListarTodasPalavrasService listarTodasPalavrasService) {
        this.adicionarPalavraNaEtiquetaService = adicionarPalavraNaEtiquetaService;
        this.atualizarPalavraService = atualizarPalavraService;
        this.buscarEtiquetasPorPalavraService = buscarEtiquetasPorPalavraService;
        this.buscarPalavraPorIdService = buscarPalavraPorIdService;
        this.criarPalavraService = criarPalavraService;
        this.deletarPalavraService = deletarPalavraService;
        this.listarTodasPalavrasService = listarTodasPalavrasService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PalavraResponseDTO> criarPalavra(@RequestBody PalavraRequestDTO palavraRequestDTO){
        PalavraResponseDTO palavra = criarPalavraService.criarPalavra(palavraRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(palavra);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping
    public ResponseEntity<List<PalavraResponseDTO>> listarTodas(){
        List<PalavraResponseDTO> palavras = listarTodasPalavrasService.listarTodas();
        return ResponseEntity.ok(palavras);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public ResponseEntity<PalavraResponseDTO> buscarPorId(@PathVariable Long id){
        PalavraResponseDTO palavra = buscarPalavraPorIdService.buscarPorId(id);
        return ResponseEntity.ok(palavra);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PalavraResponseDTO> atualizar(@PathVariable Long id, @RequestBody PalavraRequestDTO palavraRequestDTO){
        PalavraResponseDTO palavra = atualizarPalavraService.atualizar(id, palavraRequestDTO);
        return ResponseEntity.ok(palavra);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        deletarPalavraService.deletarPalavra(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @GetMapping("/{id}/etiquetas")
    public ResponseEntity<Set<EtiquetaSimpleResponseDTO>> buscarEtiquetasPorPalavra(@PathVariable Long id){
        Set<EtiquetaSimpleResponseDTO> etiquetas = buscarEtiquetasPorPalavraService.buscarEtiquetasPorPalavra(id);
        return ResponseEntity.ok(etiquetas);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{palavraId}/etiquetas/{etiquetaId}")
    public ResponseEntity<EtiquetaResponseDTO> adicionarPalavraNaEtiqueta(@PathVariable Long palavraId, @PathVariable Long etiquetaId){
        EtiquetaResponseDTO etiqueta = adicionarPalavraNaEtiquetaService.adicionarPalavraNaEtiqueta(etiquetaId, palavraId);
        return ResponseEntity.ok(etiqueta);
    }
}
