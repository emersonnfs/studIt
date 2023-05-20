package br.com.fiap.studit.controllers;

import br.com.fiap.studit.models.Usuario;
import br.com.fiap.studit.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<Page<Usuario>> getAllUsuarios(@RequestParam(required = false) String nome,
                                                        @PageableDefault(sort = "dataNascimento", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Usuario> usuarios;
        if(nome != null){
            usuarios = usuarioService.getAllUsuariosByNomeContainingIgnoreCase(nome,pageable);
        }
        else{
            usuarios = usuarioService.getAllUsuarios(pageable);
        }
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        return usuario.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> saveUsuario(@RequestBody @Valid Usuario usuario) {
        Usuario savedUsuario = usuarioService.saveUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        Optional<Usuario> existingUsuario = usuarioService.getUsuarioById(id);
        if (existingUsuario.isPresent()) {
            usuario.setId(id);
            Usuario updatedUsuario = usuarioService.updateUsuario(usuario);
            return ResponseEntity.ok(updatedUsuario);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarioById(@PathVariable Long id) {
        Optional<Usuario> existingUsuario = usuarioService.getUsuarioById(id);
        if (existingUsuario.isPresent()) {
            usuarioService.deleteUsuarioById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}