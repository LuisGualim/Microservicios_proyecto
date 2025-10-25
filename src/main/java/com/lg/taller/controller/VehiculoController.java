
package com.lg.taller.controller;

import com.lg.taller.entity.Vehiculo;
import com.lg.taller.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping
    public ResponseEntity<Vehiculo> guardar(@RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.guardar(vehiculo));
    }

    @GetMapping
    public ResponseEntity<List<Vehiculo>> listar() {
        return ResponseEntity.ok(vehiculoService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vehiculo> obtenerPorId(@PathVariable Long id) {
        return vehiculoService.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vehiculo> actualizar(@PathVariable Long id, @RequestBody Vehiculo vehiculo) {
        return ResponseEntity.ok(vehiculoService.actualizar(id, vehiculo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        vehiculoService.eliminar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Vehiculo>> listarPorCliente(@PathVariable Long clienteId) {
        return ResponseEntity.ok(vehiculoService.listarPorCliente(clienteId));
    }
    
}
