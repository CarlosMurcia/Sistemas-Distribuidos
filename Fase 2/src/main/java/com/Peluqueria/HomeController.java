package com.Peluqueria;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@Autowired 
	private UsuariosRepository repository;
	
	@PostConstruct
	public void init () {
		repository.save (new Usuario ("nombre1", "email1", "1111111"));
		repository.save (new Usuario ("nombre2", "email2", "2222222"));
	}
	

	@RequestMapping("/")
	public String home(Model model, Pageable page) {
		
		model.addAttribute("usuarios", repository.findAll (page));

		return "home";
	}

	@PostMapping("/usuario/nuevo")
	public String nuevoUsuario(Model model, Usuario usuario) {

		repository.save(usuario);

		return "usuario_guardado";

	}

	@RequestMapping("/calendario")
	public String Calendario(Model model, Usuario usuario) {

		

		return "Calendario";
		
	}

	@PostMapping("/reserva")
	public String Reserva(Model model, Usuario usuario) {


		return "reserva_guardada";
	
	}
	
	@GetMapping("/usuario/{id}")
	public String verUsuario(Model model, @PathVariable long id) {

		Usuario usuario = repository.findOne (id);

		model.addAttribute("usuario", usuario);

		return "ver_usuario";
	}
	

	}