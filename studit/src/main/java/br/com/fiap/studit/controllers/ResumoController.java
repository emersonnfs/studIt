package br.com.fiap.studit.controllers;

import br.com.fiap.studit.models.Resumo;
import br.com.fiap.studit.services.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/resumo")
public class ResumoController {
    private final ResumoService resumoService;

    @Autowired
    public ResumoController(ResumoService resumoService) {
        this.resumoService = resumoService;
    }

    @GetMapping
    public ResponseEntity<List<Resumo>> getAllResumos() {
        List<Resumo> resumos = resumoService.getAllResumos();
        return ResponseEntity.ok(resumos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Resumo> getResumoById(@PathVariable Long id) {
        Optional<Resumo> resumo = resumoService.getResumoById(id);
        return resumo.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Resumo> saveResumo(@RequestBody Resumo resumo) {
        Resumo savedResumo = resumoService.saveResumo(resumo);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedResumo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Resumo> updateResumo(@PathVariable Long id, @RequestBody Resumo resumo) {
        Optional<Resumo> existingResumo = resumoService.getResumoById(id);
        if (existingResumo.isPresent()) {
            resumo.setId(id);
            Resumo updatedResumo = resumoService.updateResumo(resumo);
            return ResponseEntity.ok(updatedResumo);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteResumoById(@PathVariable Long id) {
        Optional<Resumo> existingResumo = resumoService.getResumoById(id);
        if (existingResumo.isPresent()) {
            resumoService.deleteResumoById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
