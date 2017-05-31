package com.Peluqueria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opinion {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String opiniones;

	public Opinion(){
		
	}

	public Opinion(String nombre, String opiniones) {
		super();
		this.nombre = nombre;
		this.opiniones = opiniones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOpiniones() {
		return opiniones;
	}

	public void setOpiniones(String opiniones) {
		this.opiniones = opiniones;
	}


	@Override
	public String toString() {
		return "Opinion [nombre=" + nombre + ", opiniones=" + opiniones + "]";
	}

}
