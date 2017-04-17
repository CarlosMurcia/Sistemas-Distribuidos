package com.Peluqueria;


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
		repository1.save (new Opiniones ("Raul", "Altamente recomendable"));
		repository2.save (new Cita ("Lunes", "10:00 horas","Ana","Lavar"));
		repository2.save (new Cita ("Martes", "11:00 horas","Alicia","Peinar"));
		repository2.save (new Cita ("Miercoles", "12:00 horas","Sonia","Tinte"));
		repository3.save (new Oferta ("Martes corte caballero mitad de precio", "13/02/2017", "13/03/2017"));
		repository3.save (new Oferta ("Lavado y tinte 15€", "15/03/2017", "15/04/2017"));
		repository3.save (new Oferta ("Tratamiento 2x1", "22/05/2017", "30/06/2017"));
		
	}

    @GetMapping("/")
    public String index() {
        return "Index";
    }
    
    @GetMapping("/usuario")
	public String NuevoUsuario(Model model, Usuarios Usuarios, HttpServletRequest request){

    	repository.save(Usuarios);

		return "NuevoUsuario";
	}
	@GetMapping("/usuario/guardado")
	public String usuarioGuardado() {

		return "UsuarioGuardado";

	}
	
	@GetMapping("/usuario/registrado")
	public String usuarioRegistrado(Model model) {
		model.addAttribute("usuarios", repository.findAll ());

		return "UsuariosRegistrados";

	}
	
	@GetMapping("/opinion")
	public String NuevaOpinion(Model model, Opiniones Opiniones, HttpServletRequest request){

	    repository1.save(Opiniones);

		return "NuevaOpinion";
		}
	
	@GetMapping("/opinion/guardada")
	public String OpinionGuardada() {

		return "OpinionGuardada";

		}
	
	@GetMapping("/cita")
	public String NuevaCita(Model model, Cita cita, HttpServletRequest request){

	    repository2.save(cita);

		return "NuevaCita";
		}
	
	@PostMapping("/cita/guardada")
	public String CitaGuardada() {

		return "CitaGuardada";

		}
	@GetMapping("/oferta")
	public String NuevaOferta(Model model, Oferta oferta, HttpServletRequest request){

	    repository3.save(oferta);

		return "NuevaOferta";
		}
	
	@GetMapping("/oferta/guardada")
	public String OfertaGuardada() {

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
    	model.addAttribute("usuarios", repository.count());
    	model.addAttribute("Opiniones", repository.findAll ());
    	model.addAttribute("oferta", repository.findAll ());
    	
    	return "Home";
    }
    
    @GetMapping("/admin")
    public String admin() {
    	
    	return "Administrador";
    }
   
}
