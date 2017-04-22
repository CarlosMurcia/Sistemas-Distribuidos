package com.Peluqueria;


import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {
	
	@Autowired 
	private UsuariosRepository repository;
	
	@Autowired 
	private OpinionesRepository repository1;
	
	@Autowired 
	private CitasRepository repository2;
	
	@Autowired 
	private OfertasRepository repository3;
	
	@PostConstruct
	public void init () {
		
		repository1.save (new Opiniones ("Carlos", "Buenisima opinion sobre la aplicación"));
		repository1.save (new Opiniones ("Rosa", "El personal muy amable"));
		repository2.save (new Cita ("Lunes", "10:00 horas","Ana","Lavar"));
		repository2.save (new Cita ("Martes", "11:00 horas","Alicia","Peinar"));
		repository3.save (new Oferta ("Martes corte caballero mitad de precio", "2017/03/27", "2017/04/20"));
		repository3.save (new Oferta ("Lavado y tinte 15€", "2017/04/15", "2017/05/23"));
		
		
	}

    @GetMapping("/")
    public String index() {
        return "Index";
    }
    
    @GetMapping("/usuario")
	public String NuevoUsuario(Model model){


		return "NuevoUsuario";
	}
	@GetMapping("/usuario/guardado")
	public String usuarioGuardado(Model model, Usuarios Usuarios) {
		
		
		ArrayList<String> roles = new ArrayList<String>();
	 	roles.add("ROLE_USER");
	 	Usuarios.setRoles(roles);
		repository.save(Usuarios);

		return "UsuarioGuardado";

	}
	
	@GetMapping("/usuario/registrado")
	public String usuarioRegistrado(Model model) {
		model.addAttribute("usuarios", repository.findAll ());

		return "UsuariosRegistrados";

	}
	@GetMapping("/opinion")
	public String NuevaOpinion(Model model){

	   

		return "NuevaOpinion";
		}
	
	@GetMapping("/opinion/guardada")
	public String OpinionGuardada(Model model, Opiniones Opiniones) {

		 repository1.save(Opiniones);
		 
		return "OpinionGuardada";

		}
	
	@GetMapping("/cita")
	public String NuevaCita(){


		return "NuevaCita";
		}
	
	@PostMapping("/cita/guardada")
	public String CitaGuardada(Model model, Cita cita) {
		
		repository2.save(cita);

		return "CitaGuardada";

		}
	
	@GetMapping("/cita/registrada")
	public String CitaRegistrada(Model model) {
		model.addAttribute("usuarios", repository.findAll ());
		model.addAttribute("cita", repository2.findAll ());

		return "CitaRegistrada";
	}
	

	@GetMapping("/oferta")
	public String NuevaOferta(){

	    

		return "NuevaOferta";
		}
	
	@GetMapping("/oferta/guardada")
	public String OfertaGuardada(Model model, Oferta oferta) {
		
		repository3.save(oferta);

		return "OfertaGuardada";

		}

    @GetMapping("/login")
    public String login(Model model) {
    	model.addAttribute("Opiniones", repository1.findAll ());
    	model.addAttribute("oferta", repository3.findAll ());
    	
    	
    	return "Login";
    }
    
    @GetMapping("/loginout")
    public String loginout() {
    	
    	
    	return "LoginOut";
    }
    
    @GetMapping("/loginerror")
    public String loginerror() {
    	return "LoginError";
    }

    @GetMapping("/home")
    public String home(Model model, HttpServletRequest request) {
    	
    	model.addAttribute("admin", request.isUserInRole("ADMIN"));
    	model.addAttribute("cita", repository2.findAll ());
    	
    	
    	return "Home";
    }
    
    @GetMapping("/admin")
    public String admin() {
    	
    	return "Administrador";
    }
   
}
