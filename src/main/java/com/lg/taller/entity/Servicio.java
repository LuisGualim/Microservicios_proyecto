package com.lg.taller.entity;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
public class Servicio {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private LocalDate fecha;
	    private String descripcion;
	    private double costo;

	    @ManyToOne
	    @JoinColumn(name = "vehiculo_id", nullable = false)
	    private Vehiculo vehiculo;

	    // Constructores
	    public Servicio() {}

	    public Servicio(LocalDate fecha, String descripcion, double costo, Vehiculo vehiculo) {
	        this.fecha = fecha;
	        this.descripcion = descripcion;
	        this.costo = costo;
	        this.vehiculo = vehiculo;
	    }

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
			this.fecha = fecha;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public double getCosto() {
			return costo;
		}

		public void setCosto(double costo) {
			this.costo = costo;
		}

		public Vehiculo getVehiculo() {
			return vehiculo;
		}

		public void setVehiculo(Vehiculo vehiculo) {
			this.vehiculo = vehiculo;
		}
	    
}
