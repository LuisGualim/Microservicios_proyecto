package com.lg.taller.controller;

import com.lg.taller.entity.Usuario;
import com.lg.taller.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtener(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> crear(@RequestBody Usuario usuario) {
        Usuario nuevo = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioRepository.findById(id)
                .map(u -> {
                    u.setNombre(usuario.getNombre());
                    u.setCorreo(usuario.getCorreo());
                    u.setPassword(usuario.getPassword());
                    u.setRol(usuario.getRol());
                    usuarioRepository.save(u);
                    return ResponseEntity.ok(u);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!usuarioRepository.existsById(id))
            return ResponseEntity.notFound().build();
        usuarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
