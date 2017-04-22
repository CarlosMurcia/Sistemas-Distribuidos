package com.Peluqueria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Entity
public class Usuarios {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String nombre;
	private String email;
	private String telefono;
	private String password;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Cita cita;

	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	public Usuarios() {
	}

	public Usuarios(String nombre, String email, String telefono, String password, String... roles) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordHash) {
		this.password = new BCryptPasswordEncoder().encode(passwordHash);
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


}