package salesianos.triana.dam.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.SalaService;
import salesianos.triana.dam.service.UsuarioService;

@Controller
public class AdminController {

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private SalaService salaService;

	@GetMapping("/admin/calendario-general")
	public String AdministrarReservas(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/admin-calendario";
	}

	@GetMapping("/admin/lista-usuarios")
	public String administrarUsuarios(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/usuarios-lista";
	}

	@GetMapping("/admin/lista-salas")
	public String AdministrarReserva(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/salas-lista";
	}

	@GetMapping("/admin/nuevo-usuario")
	public String crearUsuario(Model model, Principal principal) {
		model.addAttribute("nuevoUsuario", new Usuario());
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/usuario-nuevo";
	}
	
	@PostMapping("/aniadirNuevoUsuario")
	public String aniadirNuevoUsuario(@ModelAttribute("nuevoUsuario") Usuario nuevoUsuario, BindingResult bindingresult, Model model) {
		usuarioService.save(new Usuario(nuevoUsuario.getEmail(), nuevoUsuario.getPass(), nuevoUsuario.getNombre(), nuevoUsuario.getNumTlf(), nuevoUsuario.isEnabled()));
		return "redirect:/admin/lista-usuarios";
	}

	@GetMapping("/admin/nueva-sala")
	public String crearSala(Model model, Principal principal) {
		model.addAttribute("nuevaSala", new Sala());
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/sala-nueva";
	}

	@PostMapping("/aniadirNuevaSala")
	public String aniadirNuevaSala(@ModelAttribute("nuevaSala") Sala nuevaSala, BindingResult bindingresult, Model model) {
		salaService.save(new Sala(nuevaSala.getNombre(), nuevaSala.getAforoMax()));
		return "redirect:/admin/lista-salas";
	}

	@GetMapping("/admin/editar-sala")
	public String editarSala(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/sala-nueva";
	}

	@GetMapping("/admin/editar-usuario")
	public String editarUsuario(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/usuario-nuevo";
	}

	@GetMapping("/admin/editar-reserva")
	public String editarReserva(Model model, Principal principal) {
		model.addAttribute("usuarioLogueado", usuarioService.findFirstByEmail(principal.getName()));
		return "admin/reserva-nueva";
	}

}