package com.Peluqueria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cita {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String dia;
	private String hora;
	private String profesional;
	private String tratamiento;

	public Cita(){
		
	}

	public Cita(String dia, String hora, String profesional,String tratamiento) {
		super();
		this.dia = dia;
		this.hora = hora;
		this.profesional = profesional;
		this.tratamiento = tratamiento;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getProfesional() {
		return profesional;
	}

	public void setProfesional(String profesional) {
		this.profesional = profesional;
	}
	
	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	@Override
	public String toString() {
		return "Cita [dia=" + dia + ", hora=" + hora + ", profesional=" + profesional + ", tratamiento=" + tratamiento + "]";
	}

}
