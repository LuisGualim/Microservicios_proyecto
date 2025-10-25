package com.lg.taller.impl;

import com.lg.taller.entity.Cliente;
import com.lg.taller.repository.ClienteRepository;
import com.lg.taller.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }


    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepository.findById(id);
    }

 
    public Cliente actualizar(Long id, Cliente cliente) {
        cliente.setId(id);
        return clienteRepository.save(cliente);
    }

    public void eliminar(Long id) {
        clienteRepository.deleteById(id);
    }
}