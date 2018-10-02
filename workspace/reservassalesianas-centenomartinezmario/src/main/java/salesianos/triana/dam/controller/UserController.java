package salesianos.triana.dam.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import salesianos.triana.dam.formbean.ReservaFormBean;
import salesianos.triana.dam.model.Reserva;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.ReservaService;
import salesianos.triana.dam.service.SalaService;
import salesianos.triana.dam.service.UsuarioService;

@Controller
public class UserController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private SalaService salaService;
	
	@Autowired
	private ReservaService reservaService;
	
	@GetMapping("/user/nueva-reserva")
	public String nuevaReserva(Model model, Principal principal) {
		model.addAttribute("nuevaReserva", new ReservaFormBean());
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "public/reserva-nueva";
	}
	
	@PostMapping("/aniadirNuevaReserva")
	public String aniadirNuevaReserva(@ModelAttribute("nuevaReserva") ReservaFormBean nuevaReserva, BindingResult bindingResult, Model model, Principal principal) {
		LocalDateTime fechaInicial = LocalDateTime.of(nuevaReserva.getFechaInicio(), nuevaReserva.getHoraInicio());
		LocalDateTime fechaFinal = LocalDateTime.of(nuevaReserva.getFechaFin(), nuevaReserva.getHoraFin());
		Usuario usuarioLogueado = usuarioService.findFirstByEmail(principal.getName());
		Reserva reserva;
//		Si usuarioLogueado es Admin, asignar el usuario a new Reserva por buscando por la Id del ReservaFormBean. Si no, asignarle el usuarioLogueado.
//		if (usuarioLogueado) {
//			
//		} else {
//			reserva = new Reserva(fechaInicial, fechaFinal, usuarioLogueado, salaService.findOneById(nuevaReserva.getSalaId()));
//		}
//		reservaService.save(reserva);
		return "redirect:/user/calendario-general";
	}

	@GetMapping("/user/calendario-general")
	public String verCalendario(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "/admin/admin-calendario";
	}

	@GetMapping("/user/calendario-personal")
	public String administrarReservas(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "/admin/admin-calendario";
	}

}