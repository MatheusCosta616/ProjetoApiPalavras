package com.gft.palavras_api.service;

import com.gft.palavras_api.models.Etiqueta;
import com.gft.palavras_api.models.Palavra;
import com.gft.palavras_api.repository.EtiquetaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EtiquetaService {
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    @Transactional
    public Etiqueta criarEtiqueta(Etiqueta etiqueta) {
        return etiquetaRepository.save(etiqueta);
    }

    public List<Etiqueta> listarTodas() {
        return etiquetaRepository.findAll();
    }

    public Optional<Etiqueta> buscarPorId(Long id) {
        return etiquetaRepository.findById(id);
    }

    @Transactional
    public Etiqueta atualizarEtiqueta(Long id, Etiqueta etiquetaDetalhes) {
        Etiqueta etiqueta = etiquetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + id));

        etiqueta.setNome(etiquetaDetalhes.getNome());
        return etiquetaRepository.save(etiqueta);
    }

    @Transactional
    public void deletarEtiqueta(Long id) {
        Etiqueta etiqueta = etiquetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + id));
        etiquetaRepository.delete(etiqueta);
    }

    public Set<Palavra> buscarPalavrasPorEtiqueta(Long etiquetaId) {
        Etiqueta etiqueta = etiquetaRepository.findById(etiquetaId)
                .orElseThrow(() -> new RuntimeException("Etiqueta não encontrada com id: " + etiquetaId));

        return etiqueta.getPalavras();
    }
}
