package com.lg.taller.controller;

import com.lg.taller.entity.Servicio;
import com.lg.taller.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

	@Autowired
    private ServicioService servicioService;

    @PostMapping
    public ResponseEntity<Servicio> guardar(@RequestBody Servicio orden) {
        return ResponseEntity.ok(servicioService.guardar(orden));
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> listar() {
        return ResponseEntity.ok(servicioService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servicio> obtenerPorId(@PathVariable Long id) {
        return servicioService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicio> actualizar(@PathVariable Long id, @RequestBody Servicio orden) {
        return ResponseEntity.ok(servicioService.actualizar(id, orden));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    	servicioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/vehiculo/{vehiculoId}")
    public ResponseEntity<List<Servicio>> listarPorVehiculo(@PathVariable Long vehiculoId) {
        return ResponseEntity.ok(servicioService.listarPorVehiculo(vehiculoId));
    }
}

