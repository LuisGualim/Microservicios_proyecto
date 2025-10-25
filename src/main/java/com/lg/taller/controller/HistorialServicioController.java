package com.lg.taller.controller;

import com.lg.taller.entity.HistorialServicio;
import com.lg.taller.repository.HistorialServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historial")
@CrossOrigin(origins = "*")
public class HistorialServicioController {

    @Autowired
    private HistorialServicioRepository historialServicioRepository;

    @GetMapping
    public List<HistorialServicio> listar() {
        return historialServicioRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HistorialServicio> obtener(@PathVariable Long id) {
        return historialServicioRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<HistorialServicio> crear(@RequestBody HistorialServicio historial) {
        HistorialServicio nuevoHistorial = historialServicioRepository.save(historial);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoHistorial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistorialServicio> actualizar(@PathVariable Long id, @RequestBody HistorialServicio historial) {
        return historialServicioRepository.findById(id)
                .map(h -> {
                    h.setFechaServicio(historial.getFechaServicio());
                    h.setDetalles(historial.getDetalles());
                    historialServicioRepository.save(h);
                    return ResponseEntity.ok(h);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!historialServicioRepository.existsById(id))
            return ResponseEntity.notFound().build();
        historialServicioRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
