package com.lg.taller.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class HistorialServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;  // Relación con Vehículo

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Usuario cliente;  // Relación con Cliente (quién recibió el servicio)

    @ManyToOne
    @JoinColumn(name = "servicio_id", nullable = false)
    private Servicio servicio;  // Relación con Servicio (tipo de servicio realizado)

    private Date fechaServicio;  // Fecha en que se realizó el servicio

    private String detalles;  // Descripción del servicio realizado

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Date getFechaServicio() {
        return fechaServicio;
    }

    public void setFechaServicio(Date fechaServicio) {
        this.fechaServicio = fechaServicio;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}
