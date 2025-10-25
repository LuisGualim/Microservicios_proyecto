package com.lg.taller.repository;

import com.lg.taller.entity.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    List<Servicio> findByVehiculoId(Long vehiculoId);
}
