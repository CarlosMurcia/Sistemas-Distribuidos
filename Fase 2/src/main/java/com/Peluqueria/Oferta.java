package com.Peluqueria;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Oferta {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String nuevaOferta;
	private String altaOferta;
	private String bajaOferta;
	
	public Oferta(){
		
	}

	public Oferta(String nuevaOferta, String altaOferta, String bajaOferta) {
		super();
		this.nuevaOferta = nuevaOferta;
		this.altaOferta = altaOferta;
		this.bajaOferta = bajaOferta;
		
	}
	
	public String getNuevaOferta() {
		return nuevaOferta;
	}

	public void setNuevaOferta(String nuevaOferta) {
		this.nuevaOferta = nuevaOferta;
	}

	public String getaAltaOferta() {
		return altaOferta;
	}

	public void setAltaOferta(String altaOferta) {
		this.altaOferta = altaOferta;
	}

	public String getBajaOferta() {
		return bajaOferta;
	}

	public void setBajaOferta(String bajaOferta) {
		this.bajaOferta = bajaOferta;
	}
	


	@Override
	public String toString() {
		return "Oferta [nuevaOferta=" + nuevaOferta + ", altaOferta=" + altaOferta + ", bajaOferta=" + bajaOferta + "]";
	}
	
}



