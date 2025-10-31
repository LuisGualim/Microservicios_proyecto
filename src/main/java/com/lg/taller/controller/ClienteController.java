package com.lg.taller.controller;

import com.lg.taller.entity.Cliente;
import com.lg.taller.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

	 @Autowired
	 private ClienteService clienteService;
	 
	 @PostMapping
	 public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
	     Cliente nuevo = clienteService.guardar(cliente);
	     return ResponseEntity.ok(nuevo);
	 }

	    @GetMapping
	    public ResponseEntity<List<Cliente>> listar() {
	        return ResponseEntity.ok(clienteService.listar());
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Cliente> obtenerPorId(@PathVariable Long id) {
	        return clienteService.obtenerPorId(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Cliente> actualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
	        return ResponseEntity.ok(clienteService.actualizar(id, cliente));
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
	        clienteService.eliminar(id);
	        return ResponseEntity.noContent().build();
	    }
}
