package salesianos.triana.dam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

	@GetMapping("/admin/calendario-general")
	public String AdministrarReservas(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/admin-calendario";
	}

	@GetMapping("/admin/lista-usuarios")
	public String administrarUsuarios(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		model.addAttribute("usuarios", usuarioService.findAll());
		return "admin/usuarios-lista";
	}

	@GetMapping("/admin/lista-salas")
	public String AdministrarReserva(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		model.addAttribute("salas", salaService.findAll());
		return "admin/salas-lista";
	}

	@GetMapping("/admin/nuevo-usuario")
	public String crearUsuario(Model model, Principal principal) {
		model.addAttribute("nuevoUsuario", new Usuario());
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/usuario-nuevo";
	}

	@PostMapping("/aniadirNuevoUsuario")
	public String aniadirNuevoUsuario(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, BindingResult bindingresult,
			Model model) {
		usuarioService.save(new Usuario(nuevoUsuario.getEmail(), nuevoUsuario.getPass(), nuevoUsuario.getNombre(),
				nuevoUsuario.getNumTlf(), nuevoUsuario.isEnabled()));
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
	public String crearSala(Model model, Principal principal) {
		model.addAttribute("nuevaSala", new Sala());
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/sala-nueva";
	}

	@PostMapping("/aniadirNuevaSala")
	public String aniadirNuevaSala(@ModelAttribute("nuevaSala") Sala nuevaSala, BindingResult bindingresult,
			Model model) {
		salaService.save(new Sala(nuevaSala.getNombre(), nuevaSala.getAforoMax()));
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
	public String irAEditarSala(@PathVariable("id") Long id, Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		model.addAttribute("salaEditable", salaService.findOneById(id));
		return "admin/sala-editar";
	}

	@PostMapping("/editarSala")
	public String editarSala(@ModelAttribute("salaEditable") Sala salaEditable, Model model,
			BindingResult bindingResult, RedirectAttributes ra, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		ra.addFlashAttribute("exitoEdit", true);
		salaService.edit(salaEditable);
		return "redirect:/admin/lista-salas";
	}

	@GetMapping("/admin/editar-usuario/{id}")
	public String irAEditarUsuario(@PathVariable("id") Long id, Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		model.addAttribute("usuarioEditable", usuarioService.findOne(id));
		return "admin/usuario-editar";
	}

	@PostMapping("/editarUsuario")
	public String editarUsuario(@ModelAttribute("usuarioEditable") Usuario usuarioEditable, Model model, BindingResult bindingResult, RedirectAttributes ra, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		ra.addFlashAttribute("exitoEdit", true);
		usuarioService.edit(usuarioEditable);
		return "redirect:/admin/lista-usuarios";
	}

	@GetMapping("/admin/editar-reserva/{id}")
	public String irAEditarReserva(@PathVariable("id") Long id, Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		model.addAttribute("reservaEditable", reservaService.findOne(id));
		return "admin/reserva-editar";
	}
	
	@PostMapping("/editarReserva")
	public String editarReserva(@ModelAttribute("reservaEditable") Reserva reservaEditable, Model model, BindingResult bindingResult, RedirectAttributes ra, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		ra.addFlashAttribute("exitoEdit", true);
		reservaService.edit(reservaEditable);
		return "redirect:/admin/calendario-general";
	}

}