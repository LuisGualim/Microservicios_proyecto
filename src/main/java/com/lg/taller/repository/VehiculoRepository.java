package com.lg.taller.repository;

import com.lg.taller.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface VehiculoRepository  extends JpaRepository<Vehiculo, Long> {
    List<Vehiculo> findByClienteId(Long clienteId);
}