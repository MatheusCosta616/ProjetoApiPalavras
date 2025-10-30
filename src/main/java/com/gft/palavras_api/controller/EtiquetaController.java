package com.gft.palavras_api.controller;

import com.gft.palavras_api.dto.request.EtiquetaRequestDTO;
import com.gft.palavras_api.dto.response.EtiquetaResponseDTO;
import com.gft.palavras_api.dto.response.PalavraResponseDTO;
import com.gft.palavras_api.dto.response.PalavraSimpleResponseDTO;
import com.gft.palavras_api.service.domain.etiqueta.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/etiquetas")
public class EtiquetaController {
    private final AdicionarEtiquetaNaPalavraService adicionarEtiquetaNaPalavraService;
    private final AtualizarEitquetaService atualizarEitquetaService;
    private final BuscarEtiquetaPorIdService buscarEtiquetaPorIdService;
    private final BuscarPalavrasPorEtiquetaService buscarPalavrasPorEtiquetaService;
    private final CriarEtiquetaService criarEtiquetaService;
    private final DeletarEtiquetaSerivce deletarEtiquetaSerivce;
    private final ListarTodasEtiquetasSerivce listarTodasEtiquetasSerivce;

    public EtiquetaController(AdicionarEtiquetaNaPalavraService adicionarEtiquetaNaPalavraService,
                              AtualizarEitquetaService atualizarEitquetaService,
                              BuscarEtiquetaPorIdService buscarEtiquetaPorIdService,
                              BuscarPalavrasPorEtiquetaService buscarPalavrasPorEtiquetaService,
                              CriarEtiquetaService criarEtiquetaService,
                              DeletarEtiquetaSerivce deletarEtiquetaSerivce,
                              ListarTodasEtiquetasSerivce listarTodasEtiquetasSerivce) {
        this.adicionarEtiquetaNaPalavraService = adicionarEtiquetaNaPalavraService;
        this.atualizarEitquetaService = atualizarEitquetaService;
        this.buscarEtiquetaPorIdService = buscarEtiquetaPorIdService;
        this.buscarPalavrasPorEtiquetaService = buscarPalavrasPorEtiquetaService;
        this.criarEtiquetaService = criarEtiquetaService;
        this.deletarEtiquetaSerivce = deletarEtiquetaSerivce;
        this.listarTodasEtiquetasSerivce = listarTodasEtiquetasSerivce;
    }

    @PostMapping
    public ResponseEntity<EtiquetaResponseDTO> criarEtiqueta(@RequestBody EtiquetaRequestDTO etiquetaRequestDTO){
        EtiquetaResponseDTO etiqueta = criarEtiquetaService.criarEtiqueta(etiquetaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(etiqueta);
    }

    @GetMapping
    public ResponseEntity<List<EtiquetaResponseDTO>> listarTodas(){
        List<EtiquetaResponseDTO> etiquetas = listarTodasEtiquetasSerivce.listarTodas();
        return ResponseEntity.ok(etiquetas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EtiquetaResponseDTO> buscarPorId(@PathVariable Long id){
        EtiquetaResponseDTO etiqueta = buscarEtiquetaPorIdService.buscarPorId(id);
        return ResponseEntity.ok(etiqueta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtiquetaResponseDTO> atualizar(@PathVariable Long id, @RequestBody EtiquetaRequestDTO etiquetaRequestDTO){
        EtiquetaResponseDTO etiqueta = atualizarEitquetaService.atualizarEtiqueta(id, etiquetaRequestDTO);
        return ResponseEntity.ok(etiqueta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        deletarEtiquetaSerivce.deletarEtiqueta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/palavras")
    public ResponseEntity<Set<PalavraSimpleResponseDTO>> buscarPalavrasPorEtiqueta(@PathVariable Long id){
        Set<PalavraSimpleResponseDTO> palavras = buscarPalavrasPorEtiquetaService.buscarPalavrasPorEtiqueta(id);
        return ResponseEntity.ok(palavras);
    }

    @PostMapping("/{etiquetaId}/palavras/{palavraId}")
    public ResponseEntity<PalavraResponseDTO> adicionarEtiquetaNaPalavra(@PathVariable Long etiquetaId, @PathVariable Long palavraId){
        PalavraResponseDTO palavra = adicionarEtiquetaNaPalavraService.adicionarEtiquetaNaPalavra(palavraId, etiquetaId);
        return ResponseEntity.ok(palavra);
    }
}
