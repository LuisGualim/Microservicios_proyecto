package com.lg.taller.service;

import com.lg.taller.entity.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    Cliente guardar(Cliente cliente);
    List<Cliente> listar();
    Optional<Cliente> obtenerPorId(Long id);
    Cliente actualizar(Long id, Cliente cliente);
    void eliminar(Long id);
}
