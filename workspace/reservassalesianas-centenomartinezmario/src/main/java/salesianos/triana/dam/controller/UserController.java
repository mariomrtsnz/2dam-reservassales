package salesianos.triana.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/user/nueva-reserva")
	public String nuevaReserva() {
		return "public/reserva-nueva";
	}

	@GetMapping("/user/calendario-general")
	public String verCalendario() {
		return "/admin/admin-calendario";
	}

	@GetMapping("/user/calendario-personal")
	public String administrarReservas() {
		return "/admin/admin-calendario";
	}

}