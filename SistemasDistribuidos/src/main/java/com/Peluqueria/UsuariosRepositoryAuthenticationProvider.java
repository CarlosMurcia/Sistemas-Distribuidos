package com.Peluqueria;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UsuariosRepositoryAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UsuariosRepository UsuariosRepository;

	@Override
	public Authentication authenticate(Authentication auth) throws AuthenticationException {

		Usuarios usuarios = UsuariosRepository.findByNombre(auth.getName());

		if (usuarios == null) {
			throw new BadCredentialsException("Usuario no encontrado");
		}

		String password = (String) auth.getCredentials();
		if (!new BCryptPasswordEncoder().matches(password, usuarios.getPassword())) {
			throw new BadCredentialsException("Contraseña no válida");
		}

		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : usuarios.getRoles()) {
			roles.add(new SimpleGrantedAuthority(role));
		}

		return new UsernamePasswordAuthenticationToken(usuarios.getNombre(), password, roles);
	}

	@Override
	public boolean supports(Class<?> authenticationObject) {
		return true;
	}
}
