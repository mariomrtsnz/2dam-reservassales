package salesianos.triana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/Admin/AdministrarReservas")
	public String AdministrarReservas() {
		return "admin-calendario";
	}

	@GetMapping("/Admin/AdministrarUsuarios")
	public String administrarUsuarios() {
		return "usuarios-lista";
	}

	@GetMapping("/Admin/AdministrarSalas")
	public String AdministrarReserva() {
		return "salas-lista";
	}

	@GetMapping("/Admin/CrearUsuario")
	public String crearUsuario() {
		return "usuario-nuevo";
	}

}