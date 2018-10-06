package salesianos.triana.dam.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import salesianos.triana.dam.model.ReservaEvento;
import salesianos.triana.dam.service.ReservaEventoService;

@RestController
public class EventoController {
	@Autowired
	private ReservaEventoService service;
	
	@RequestMapping(value="/events", method=RequestMethod.GET)
	public List<ReservaEvento> events() {
		return service.findAll();
	}
	
//	@RequestMapping(value="/events", method=RequestMethod.GET)
//	public List<ReservaEvento> getEventsInRange(@RequestParam(value = "start", required = true) String start, 
//										@RequestParam(value = "end", required = true) String end) {
//		LocalDateTime startDate = null;
//		LocalDateTime endDate = null;
//		DateTimeFormatter inputDateFormat=DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		
//		startDate = LocalDateTime.parse(start, inputDateFormat);
//		endDate = LocalDateTime.parse(end, inputDateFormat);
//			
//		return service.findByDatesBetween(startDate, endDate); 
//	}
	
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
