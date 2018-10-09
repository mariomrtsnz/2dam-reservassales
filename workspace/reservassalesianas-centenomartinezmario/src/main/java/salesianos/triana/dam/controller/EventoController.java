package salesianos.triana.dam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import salesianos.triana.dam.model.ReservaEvento;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.service.ReservaEventoService;

@RestController
public class EventoController {
	@Autowired
	private ReservaEventoService service;
	
	@RequestMapping(value="/events", method=RequestMethod.GET)
	public List<ReservaEvento> events() {
		return service.findAll();
	}
	
	@RequestMapping(value="/userEvents", method=RequestMethod.GET)
	public List<ReservaEvento> userEvents(@AuthenticationPrincipal Usuario usuarioLogueado) {
		return service.findAllByDescription(usuarioLogueado.getNombre());
	}
	
	@RequestMapping(value="/event", method=RequestMethod.POST)
	public ReservaEvento addEvent(@RequestBody ReservaEvento evento) {
		ReservaEvento creado = service.save(evento);
		return creado;
	}
	
	@RequestMapping(value="/event", method=RequestMethod.PATCH)
	public ReservaEvento updateEvent(@RequestBody ReservaEvento evento) {
		return service.save(evento);
	}

	@RequestMapping(value="/event", method=RequestMethod.DELETE)
	public void removeEvent(@RequestBody ReservaEvento evento) {
		service.delete(evento);
	}

}
