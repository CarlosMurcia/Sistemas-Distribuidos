package com.Peluqueria;

import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuarios, Long> {

    Usuarios findByNombre(String nombre);
    Usuarios findByEmail(String email);
    Usuarios findByTelefono(String telefono);
	
	
}
