package com.Peluqueria;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuariosRepository UsuariosRepository;

    @PostConstruct
    private void initDatabase() {
    	
    	UsuariosRepository.save(new Usuarios("user", "user@user.com", "912347656", "pass", "ROLE_USER"));
		UsuariosRepository.save(new Usuarios("admin", "admin@admin.com", "654789876", "adminpass", "ROLE_USER", "ROLE_ADMIN"));
		
    }

}
