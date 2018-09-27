package salesianos.triana.dam.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String inicioSesion() {
		return "index";
	}

	@GetMapping("/registro")
	public String registro() {
		return "registro";
	}

	@GetMapping("/index/")
	public String index(Model model, Principal principal) {
		model.addAttribute("message", "Has iniciado sesión como" + principal.getName());
		return "index";
	}
}