package br.com.fiap.studit.controllers;

import br.com.fiap.studit.models.Exercicio;
import br.com.fiap.studit.services.ExercicioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/exercicio")
public class ExercicioController {
    private final ExercicioService exercicioService;

    @Autowired
    public ExercicioController(ExercicioService exercicioService) {
        this.exercicioService = exercicioService;
    }

    @GetMapping
    public ResponseEntity<Page<Exercicio>> getAllExercicios(
            @RequestParam(required = false) String materia,
            @PageableDefault(sort = "id", direction = Sort.Direction.ASC, size = 5) Pageable pageable) {
        Page<Exercicio> exercicios;

        if (materia != null) {
            exercicios = exercicioService.getAllExerciciosByMateria(materia, pageable);
        } else {
            exercicios = exercicioService.getAllExercicios(pageable);
        }

        return ResponseEntity.ok(exercicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exercicio> getExercicioById(@PathVariable Long id) {
        Optional<Exercicio> exercicio = exercicioService.getExercicioById(id);
        return exercicio.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Exercicio> saveExercicio(@RequestBody @Valid Exercicio exercicio) {
        Exercicio savedExercicio = exercicioService.saveExercicio(exercicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExercicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Exercicio> updateExercicio(@PathVariable Long id, @RequestBody @Valid Exercicio exercicio) {
        Optional<Exercicio> existingExercicio = exercicioService.getExercicioById(id);
        if (existingExercicio.isPresent()) {
            exercicio.setId(id);
            Exercicio updatedExercicio = exercicioService.updateExercicio(exercicio);
            return ResponseEntity.ok(updatedExercicio);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExercicioById(@PathVariable Long id) {
        Optional<Exercicio> existingExercicio = exercicioService.getExercicioById(id);
        if (existingExercicio.isPresent()) {
            exercicioService.deleteExercicioById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
