package com.lg.taller.impl;

import com.lg.taller.entity.Servicio;
import com.lg.taller.repository.ServicioRepository;
import com.lg.taller.service.ServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioImpl implements ServicioService {

    @Autowired
    private ServicioRepository ServicioRepository;

    @Override
    public Servicio guardar(Servicio orden) {
        return ServicioRepository.save(orden);
    }

    @Override
    public List<Servicio> listar() {
        return ServicioRepository.findAll();
    }

    @Override
    public Optional<Servicio> obtenerPorId(Long id) {
        return ServicioRepository.findById(id);
    }

    @Override
    public Servicio actualizar(Long id, Servicio orden) {
        orden.setId(id);
        return ServicioRepository.save(orden);
    }

    @Override
    public void eliminar(Long id) {
    	ServicioRepository.deleteById(id);
    }

    @Override
    public List<Servicio> listarPorVehiculo(Long vehiculoId) {
        return ServicioRepository.findByVehiculoId(vehiculoId);
    }

}
