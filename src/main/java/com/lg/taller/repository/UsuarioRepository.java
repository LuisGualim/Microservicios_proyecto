package com.lg.taller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lg.taller.entity.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 
	
}