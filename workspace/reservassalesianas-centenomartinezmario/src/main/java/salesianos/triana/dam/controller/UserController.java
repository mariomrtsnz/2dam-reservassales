package salesianos.triana.dam.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	public String nuevaReserva(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("nuevaReserva", new ReservaFormBean());
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("salas", salaService.findAll());
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("finesDeSemanaEstado", AdminController.isFinesDeSemana());
		return "public/reserva-nueva";
	}

	@PostMapping("/aniadirNuevaReserva")
	public String aniadirNuevaReserva(@ModelAttribute("nuevaReserva") ReservaFormBean nuevaReserva,
			BindingResult bindingResult, Model model, Principal principal, HttpServletRequest request,
			RedirectAttributes ra) {
		LocalTime horaInicioMinima = LocalTime.of(8, 00);
		LocalTime horaFinMaxima = LocalTime.of(21, 00);
		LocalDateTime fechaInicial = LocalDateTime.of(nuevaReserva.getFechaInicio(), nuevaReserva.getHoraInicio());
		LocalDateTime fechaFinal = LocalDateTime.of(nuevaReserva.getFechaFin(), nuevaReserva.getHoraFin());
		Usuario usuarioLogueado = usuarioService.findFirstByEmail(principal.getName());
		Reserva reserva;
		Long salaId = nuevaReserva.getSalaId();
		boolean errorFecha = fechaInicial.isAfter(fechaFinal) || fechaFinal.isBefore(fechaInicial);
		boolean reservaAntesDeExistentes = reservaService.salaIdAndReservaEarlierThanExisting(salaId, fechaInicial,
				fechaFinal);
		boolean reservaDespuesDeExistentes = reservaService.salaIdAndReservaLaterThanExisting(salaId, fechaInicial,
				fechaFinal);
		boolean existenteDuranteReserva = reservaService.findBySalaIdAndExistingBetweenReserva(salaId, fechaInicial,
				fechaFinal);
		boolean reservaDuranteExistente = reservaService.findBySalaIdAndReservaBetweenExisting(salaId, fechaInicial, fechaFinal);
		boolean horaCorrecta = nuevaReserva.getHoraInicio().isAfter(horaInicioMinima) && nuevaReserva.getHoraFin().isBefore(horaFinMaxima);

		if (errorFecha) {
			ra.addFlashAttribute("errorFecha", true);
			return "redirect:/user/nueva-reserva";
		} else if(!horaCorrecta) {
			ra.addFlashAttribute("errorHoras", true);
			return "redirect:/user/nueva-reserva";
		} else {
			if ((reservaAntesDeExistentes && !existenteDuranteReserva && !reservaDuranteExistente)
					|| (reservaDespuesDeExistentes && !existenteDuranteReserva && !reservaDuranteExistente)) {
				if (request.isUserInRole("ROLE_ADMIN")) {
					reserva = new Reserva(fechaInicial, fechaFinal, usuarioService.findOne(nuevaReserva.getUsuarioId()),
							salaService.findOneById(salaId));
				} else {
					reserva = new Reserva(fechaInicial, fechaFinal, usuarioLogueado,
							salaService.findOneById(nuevaReserva.getSalaId()));
				}
				reservaService.save(reserva);
				ra.addFlashAttribute("reservaExito", true);
				ra.addFlashAttribute("estadoFinesDeSemana", AdminController.isFinesDeSemana());
				return "redirect:/user/calendario-general";
			} else {
				ra.addFlashAttribute("errorSolapa", true);
				return "redirect:/user/nueva-reserva";
			}
		}
	}
	
	@GetMapping("/user/eliminar-reserva/{id}")
	public String eliminarReserva(@PathVariable("id") Long id, Model model, @AuthenticationPrincipal Usuario usuarioLogueado, RedirectAttributes ra) {
		reservaService.remove(reservaService.findOne(id));
		ra.addFlashAttribute("eliminadoExito", true);
		ra.addFlashAttribute("estadoFinesDeSemana", AdminController.isFinesDeSemana());
		return "redirect:/user/calendario-general";
	}

	@GetMapping("/user/calendario-general")
	public String verCalendario(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		return "/admin/admin-calendario";
	}

	@GetMapping("/user/calendario-personal")
	public String administrarReservas(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		return "/public/usuario-calendario";
	}

}