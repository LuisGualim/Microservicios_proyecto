package com.lg.taller.impl;

import com.lg.taller.entity.Vehiculo;
import com.lg.taller.repository.VehiculoRepository;
import com.lg.taller.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VehiculoImpl implements VehiculoService {

	    @Autowired
	    private VehiculoRepository vehiculoRepository;

	    @Override
	    public Vehiculo guardar(Vehiculo vehiculo) {
	        return vehiculoRepository.save(vehiculo);
	    }

	    @Override
	    public List<Vehiculo> listar() {
	        return vehiculoRepository.findAll();
	    }

	    @Override
	    public Optional<Vehiculo> obtenerPorId(Long id) {
	        return vehiculoRepository.findById(id);
	    }

	    @Override
	    public Vehiculo actualizar(Long id, Vehiculo vehiculo) {
	        vehiculo.setId(id);
	        return vehiculoRepository.save(vehiculo);
	    }

	    @Override
	    public void eliminar(Long id) {
	        vehiculoRepository.deleteById(id);
	    }

	    @Override
	    public List<Vehiculo> listarPorCliente(Long clienteId) {
	        return vehiculoRepository.findByClienteId(clienteId);
	    }
}
