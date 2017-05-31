package com.Peluqueria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Opiniones {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private String opinion;

	public Opiniones(){
		
	}

	public Opiniones(String nombre, String opinion) {
		super();
		this.nombre = nombre;
		this.opinion = opinion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}


	@Override
	public String toString() {
		return "Opiniones [nombre=" + nombre + ", opinion=" + opinion + "]";
	}

}
