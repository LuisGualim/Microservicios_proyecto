package com.lg.taller.service;

import com.lg.taller.entity.Vehiculo;
import java.util.List;
import java.util.Optional;

public interface VehiculoService {
	Vehiculo guardar(Vehiculo vehiculo);
    List<Vehiculo> listar();
    Optional<Vehiculo> obtenerPorId(Long id);
    Vehiculo actualizar(Long id, Vehiculo vehiculo);
    void eliminar(Long id);
    List<Vehiculo> listarPorCliente(Long clienteId);
}
