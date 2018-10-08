package salesianos.triana.dam.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.ReservaEvento;
import salesianos.triana.dam.repository.EventoRepository;

@Service
public class ReservaEventoService {
	@Autowired
	EventoRepository repositorio;
	
	public ReservaEvento save(ReservaEvento evento) {
		return repositorio.save(evento);
	}
	
	public List<ReservaEvento> findAll() {
		return repositorio.findAll();
	}
	
	public List<ReservaEvento> findAllByDescription(String usuario) {
		return repositorio.findByDescription(usuario);
	}
	
//	public List<ReservaEvento> findByDatesBetween(LocalDateTime start, LocalDateTime end) {
//		return repositorio.findByDatesBetween(start, end);
//	}
	
	public void delete(ReservaEvento evento) {
		repositorio.delete(evento);
	}
}
