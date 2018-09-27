package salesianos.triana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

	@GetMapping("/admin/calendario-general")
	public String AdministrarReservas() {
		return "admin/admin-calendario";
	}

	@GetMapping("/admin/lista-usuarios")
	public String administrarUsuarios() {
		return "admin/usuarios-lista";
	}

	@GetMapping("/admin/lista-salas")
	public String AdministrarReserva() {
		return "admin/salas-lista";
	}

	@GetMapping("/admin/nuevo-usuario")
	public String crearUsuario() {
		return "admin/usuario-nuevo";
	}
	
	@GetMapping("/admin/nueva-sala")
	public String crearSala() {
		return "admin/sala-nueva";
	}

}