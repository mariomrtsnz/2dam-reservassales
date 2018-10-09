package salesianos.triana.dam.controller;

import java.security.Principal;
import java.time.LocalDate;
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
import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.ReservaService;
import salesianos.triana.dam.service.SalaService;
import salesianos.triana.dam.service.UsuarioService;

@Controller
public class AdminController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private SalaService salaService;

	@Autowired
	private ReservaService reservaService;

	private static boolean finesDeSemana = true;

	private Long reservaId;

	@GetMapping("/habilitarFinesDeSemana")
	public String habilitarFinesDeSemana(RedirectAttributes ra) {
		if (finesDeSemana)
			setFinesDeSemana(false);
		else
			setFinesDeSemana(true);

		ra.addFlashAttribute("exitoDeshabilitarFinesDeSemana", true);
		return "redirect:/admin/calendario-general";
	}

	@GetMapping("/admin/calendario-general")
	public String AdministrarReservas(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("estadoFinesDeSemana", isFinesDeSemana());
		return "admin/admin-calendario";
	}

	@GetMapping("/admin/lista-usuarios")
	public String administrarUsuarios(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("usuarios", usuarioService.findAll());
		return "admin/usuarios-lista";
	}

	@GetMapping("/admin/lista-salas")
	public String AdministrarReserva(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("salas", salaService.findAll());
		return "admin/salas-lista";
	}

	@GetMapping("/admin/nuevo-usuario")
	public String crearUsuario(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("nuevoUsuario", new Usuario());
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		return "admin/usuario-nuevo";
	}

	@PostMapping("/aniadirNuevoUsuario")
	public String aniadirNuevoUsuario(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, BindingResult bindingresult,
			Model model, RedirectAttributes ra) {
		usuarioService.save(new Usuario(nuevoUsuario.getEmail(), nuevoUsuario.getPass(), nuevoUsuario.getNombre(),
				nuevoUsuario.getNumTlf(), nuevoUsuario.isEnabled(), nuevoUsuario.getFoto()));
		ra.addFlashAttribute("creadoExito", true);
		return "redirect:/admin/lista-usuarios";
	}

	@GetMapping("/admin/eliminar-usuario/{id}")
	public String eliminarUsuario(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
		Usuario usuario = usuarioService.findOne(id);
		usuarioService.remove(usuario);
		ra.addFlashAttribute("eliminadoExito", true);
		return "redirect:/admin/lista-usuarios";
	}

	@GetMapping("/admin/nueva-sala")
	public String crearSala(Model model, @AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("nuevaSala", new Sala());
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		return "admin/sala-nueva";
	}

	@PostMapping("/aniadirNuevaSala")
	public String aniadirNuevaSala(@ModelAttribute("nuevaSala") Sala nuevaSala, BindingResult bindingresult,
			Model model, RedirectAttributes ra) {
		salaService.save(new Sala(nuevaSala.getNombre(), nuevaSala.getAforoMax(), nuevaSala.getFoto()));
		ra.addFlashAttribute("creadoExito", true);
		return "redirect:/admin/lista-salas";
	}

	@GetMapping("/admin/eliminar-sala/{id}")
	public String eliminarSala(@PathVariable("id") Long id, Model model, RedirectAttributes ra) {
		Sala sala = salaService.findOneById(id);
		salaService.remove(sala);
		ra.addFlashAttribute("eliminadoExito", true);
		return "redirect:/admin/lista-salas";
	}

	@GetMapping("/admin/editar-sala/{id}")
	public String irAEditarSala(@PathVariable("id") Long id, Model model,
			@AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("salaEditable", salaService.findOneById(id));
		return "admin/sala-editar";
	}

	@PostMapping("/editarSala")
	public String editarSala(@ModelAttribute("salaEditable") Sala salaEditable, Model model,
			BindingResult bindingResult, RedirectAttributes ra, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		ra.addFlashAttribute("editadoExito", true);
		salaService.edit(salaEditable);
		return "redirect:/admin/lista-salas";
	}

	@GetMapping("/admin/editar-usuario/{id}")
	public String irAEditarUsuario(@PathVariable("id") Long id, Model model,
			@AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		model.addAttribute("usuarioEditable", usuarioService.findOne(id));
		return "admin/usuario-editar";
	}

	@PostMapping("/editarUsuario")
	public String editarUsuario(@ModelAttribute("usuarioEditable") Usuario usuarioEditable, Model model,
			BindingResult bindingResult, RedirectAttributes ra, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		ra.addFlashAttribute("editadoExito", true);
		usuarioService.edit(usuarioEditable);
		return "redirect:/admin/lista-usuarios";
	}

	@GetMapping("/admin/editar-reserva/{id}")
	public String irAEditarReserva(@PathVariable("id") Long id, Model model,
			@AuthenticationPrincipal Usuario usuarioLogueado) {
		model.addAttribute("usuarioLogueado", usuarioLogueado);
		Reserva reservaAEditar = reservaService.findOne(id);
		LocalTime horaInicio = LocalTime.of(reservaAEditar.getFechaInicial().getHour(),
				reservaAEditar.getFechaInicial().getMinute());
		LocalDate fechaInicio = LocalDate.of(reservaAEditar.getFechaInicial().getYear(),
				reservaAEditar.getFechaInicial().getMonth(), reservaAEditar.getFechaInicial().getDayOfMonth());
		LocalTime horaFin = LocalTime.of(reservaAEditar.getFechaFinal().getHour(),
				reservaAEditar.getFechaFinal().getMinute());
		LocalDate fechaFin = LocalDate.of(reservaAEditar.getFechaFinal().getYear(),
				reservaAEditar.getFechaFinal().getMonth(), reservaAEditar.getFechaFinal().getDayOfMonth());
		ReservaFormBean reservaAEditarFormBean = new ReservaFormBean(horaInicio, fechaInicio, horaFin, fechaFin,
				reservaAEditar.getSala().getId(), reservaAEditar.getUsuario().getId(), false, 0);
		model.addAttribute("reservaEditable", reservaAEditarFormBean);
		setReservaId(id);
		model.addAttribute("salas", salaService.findAll());
		model.addAttribute("usuarios", usuarioService.findAll());
		model.addAttribute("finesDeSemanaEstado", isFinesDeSemana());
		model.addAttribute("fotoReservaEditable", reservaAEditar.getSala().getFoto());
		return "admin/reserva-editar";
	}

	@PostMapping("/editarReserva")
	public String editarReserva(@ModelAttribute("reservaEditable") ReservaFormBean reservaEditable, Model model,
			BindingResult bindingResult, RedirectAttributes ra, Principal principal, HttpServletRequest request) {
		LocalTime horaInicioMinima = LocalTime.of(8, 00);
		LocalTime horaFinMaxima = LocalTime.of(21, 00);
		LocalDateTime fechaInicial = LocalDateTime.of(reservaEditable.getFechaInicio(),
				reservaEditable.getHoraInicio());
		LocalDateTime fechaFinal = LocalDateTime.of(reservaEditable.getFechaFin(), reservaEditable.getHoraFin());
		Usuario usuarioLogueado = usuarioService.findFirstByEmail(principal.getName());
		Long salaId = reservaEditable.getSalaId();
		Sala sala = salaService.findOneById(salaId);
		boolean errorFecha = fechaInicial.isAfter(fechaFinal) || fechaFinal.isBefore(fechaInicial);
		boolean reservaAntesDeExistentes = reservaService.salaIdAndReservaEarlierThanExisting(salaId, fechaInicial,
				fechaFinal);
		boolean reservaDespuesDeExistentes = reservaService.salaIdAndReservaLaterThanExisting(salaId, fechaInicial,
				fechaFinal);
		boolean reservaDuranteExistente = reservaService.findBySalaIdAndReservaBetweenExisting(salaId, fechaInicial,
				fechaFinal);
		boolean horaCorrecta = reservaEditable.getHoraInicio().isAfter(horaInicioMinima)
				&& reservaEditable.getHoraFin().isBefore(horaFinMaxima);
		Reserva reserva = reservaService.findOne(reservaId);
		reserva.setFechaInicial(fechaInicial);
		reserva.setFechaFinal(fechaFinal);
		reserva.setSala(sala);
		reserva.setUsuario(usuarioService.findOne(reservaEditable.getUsuarioId()));
		if (errorFecha) {
			ra.addFlashAttribute("errorFecha", true);
			return "redirect:/admin/editar-reserva/";
		} else if (!horaCorrecta) {
			ra.addFlashAttribute("errorHoras", true);
			return "redirect:/admin/editar-reserva/";
		} else {
			if ((reservaAntesDeExistentes && !reservaDuranteExistente)
					|| (reservaDespuesDeExistentes && !reservaDuranteExistente)) {
				if (request.isUserInRole("ROLE_USER")) {
					reserva.setUsuario(usuarioLogueado);
				}
				reservaService.edit(reserva);
				ra.addFlashAttribute("reservaExito", true);
				ra.addFlashAttribute("estadoFinesDeSemana", AdminController.isFinesDeSemana());
				return "redirect:/user/calendario-general";
			} else {
				ra.addFlashAttribute("errorSolapa", true);
				return "redirect:/user/nueva-reserva";
			}
		}
	}

	public static boolean isFinesDeSemana() {
		return finesDeSemana;
	}

	public static void setFinesDeSemana(boolean finesDeSemana) {
		AdminController.finesDeSemana = finesDeSemana;
	}

	public Long getReservaId() {
		return reservaId;
	}

	public void setReservaId(Long reservaId) {
		this.reservaId = reservaId;
	}

}