package salesianos.triana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/User/NuevaReserva")
	public String nuevaReserva() {
		return "reserva-nueva";
	}

	@GetMapping("/User/VerCalendario")
	public String verCalendario() {
		return "admin-calendario";
	}

	@GetMapping("/User/AdministrarReservas")
	public String administrarReservas() {
		return "admin-calendario";
	}

}