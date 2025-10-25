package com.lg.taller.controller;

import com.lg.taller.entity.Cita;
import com.lg.taller.repository.CitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaRepository citaRepository;

    @GetMapping
    public List<Cita> listar() {
        return citaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> obtener(@PathVariable Long id) {
        return citaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Cita> crear(@RequestBody Cita cita) {
        Cita nuevaCita = citaRepository.save(cita);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizar(@PathVariable Long id, @RequestBody Cita cita) {
        return citaRepository.findById(id)
                .map(c -> {
                    c.setFechaCita(cita.getFechaCita());
                    c.setEstado(cita.getEstado());
                    citaRepository.save(c);
                    return ResponseEntity.ok(c);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!citaRepository.existsById(id))
            return ResponseEntity.notFound().build();
        citaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
