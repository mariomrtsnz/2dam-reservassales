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
		return "public/registro";
	}

	@GetMapping("/home")
	public String home() {
		return "public/index-usuario";
	}
}