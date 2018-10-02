package salesianos.triana.dam.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import salesianos.triana.dam.formbean.RegistroUsuario;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.UsuarioService;

@Controller
public class HomeController {

	@Autowired
	private HttpSession sesion;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/login")
	public String inicioSesion() {
		return "index";
	}

	@GetMapping("/registro")
	public String registro(Model model) {
		model.addAttribute("registroUsuario", new RegistroUsuario());
		return "public/registro";
	}
	
	@PostMapping("/registroEnvio")
	public String registroEnvio(@ModelAttribute("registroUsuario") RegistroUsuario registroUsuario, BindingResult bindingResult, Model model) {
		Usuario usuario = new Usuario(registroUsuario.getEmail(), registroUsuario.getPass(), registroUsuario.getNombre(), registroUsuario.getNumTlf(), false);
		usuarioService.save(usuario);
		return "index";
	}
	
	

	@GetMapping("/home")
	public String home(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "public/index-usuario";
	}
}