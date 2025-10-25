package com.lg.taller.service;

import com.lg.taller.entity.Servicio;
import java.util.List;
import java.util.Optional;

public interface ServicioService {
	Servicio guardar(Servicio orden);
    List<Servicio> listar();
    Optional<Servicio> obtenerPorId(Long id);
    Servicio actualizar(Long id, Servicio orden);
    void eliminar(Long id);
    List<Servicio > listarPorVehiculo(Long vehiculoId);
}
