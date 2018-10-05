package salesianos.triana.dam.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping({ "/user/nueva-reserva", "/admin/nueva-reserva" })
	public String nuevaReserva(Model model, Principal principal) {
		model.addAttribute("nuevaReserva", new ReservaFormBean());
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		model.addAttribute("salas", salaService.findAll());
		model.addAttribute("usuarios", usuarioService.findAll());
		return "public/reserva-nueva";
	}

	@PostMapping("/aniadirNuevaReserva")
	public String aniadirNuevaReserva(@ModelAttribute("nuevaReserva") ReservaFormBean nuevaReserva,
			BindingResult bindingResult, Model model, Principal principal, HttpServletRequest request,
			RedirectAttributes ra) {
		LocalDateTime fechaInicial = LocalDateTime.of(nuevaReserva.getFechaInicio(), nuevaReserva.getHoraInicio());
		LocalDateTime fechaFinal = LocalDateTime.of(nuevaReserva.getFechaFin(), nuevaReserva.getHoraFin());
		Usuario usuarioLogueado = usuarioService.findFirstByEmail(principal.getName());
		Reserva reserva;
		Long salaId = nuevaReserva.getSalaId();
		boolean errorFecha = fechaInicial.isAfter(fechaFinal) || fechaFinal.isBefore(fechaInicial);
		boolean earlierFechaInicialThanReserva = reservaService.salaIdAndFechaInicialEarlierThanReserva(salaId, fechaFinal);
		boolean laterFechaInicialThanReserva = reservaService.salaIdAndFechaInicialLaterThanReserva(salaId, fechaInicial);
		boolean solapan = earlierFechaInicialThanReserva || laterFechaInicialThanReserva;

		if (errorFecha) {
			ra.addFlashAttribute("errorFecha", true);
			return "redirect:/user/nueva-reserva";
		} else {
			if (!solapan) {
				if (request.isUserInRole("ROLE_ADMIN")) {
					reserva = new Reserva(fechaInicial, fechaFinal, usuarioService.findOne(nuevaReserva.getUsuarioId()),
							salaService.findOneById(salaId));
				} else {
					reserva = new Reserva(fechaInicial, fechaFinal, usuarioLogueado,
							salaService.findOneById(nuevaReserva.getSalaId()));
				}
				reservaService.save(reserva);
				ra.addFlashAttribute("reservaExito", true);
				return "redirect:/user/calendario-general";
			} else {
				ra.addFlashAttribute("errorSolapa", true);
				return "redirect:/user/nueva-reserva";
			}
		}

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