package com.lg.taller.repository;

import com.lg.taller.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
}
