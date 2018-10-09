package salesianos.triana.dam.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.Reserva;
import salesianos.triana.dam.model.ReservaEvento;
import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	ReservaRepository repositorio;
	
	@Autowired
	ReservaEventoService eventoService;

	public Reserva findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Iterable<Reserva> findAll() {
		return repositorio.findAll();
	}

	public Iterable<Reserva> findAllByFechaInicial(LocalDateTime fechaInicial) {
		return repositorio.findAllByFechaInicial(fechaInicial);
	}

	public Reserva save(Reserva entidad) {
		eventoService.save(new ReservaEvento(entidad.getSala().getNombre(), entidad.getUsuario().getNombre(), entidad.getFechaInicial(), entidad.getFechaFinal()));
		return repositorio.save(entidad);
	}

	public Reserva remove(Reserva entidad) {
		Reserva reservaABorrar = findOne(entidad.getId());
		eventoService.delete(eventoService.findOne(entidad.getId()));
		if (reservaABorrar != null)
			repositorio.delete(entidad);
		return reservaABorrar;
	}

	public void edit(Reserva entidad) {
		eventoService.edit(eventoService.findOne(entidad.getId()));
		save(entidad);
	}

	public Iterable<Reserva> findAllByFechaInicialAndFechaFinalBetween(LocalDateTime fechaInicial,
			LocalDateTime fechaFinal) {
		return repositorio.findAllByFechaFinalBetween(fechaInicial, fechaFinal);
	}
	
	public boolean findBySalaIdAndExistingBetweenReserva(Long salaId, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndExistingBetweenReserva(salaId, fechaInicial, fechaFinal);
		long size = valores.spliterator().getExactSizeIfKnown();
		boolean existenteDuranteReserva = false;
		if (size > 0) {
			existenteDuranteReserva = true;
		}
		return existenteDuranteReserva;
	}
	
	public boolean findBySalaIdAndReservaBetweenExisting(Long salaId, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndReservaBetweenExisting(salaId, fechaInicial, fechaFinal);
		long size = valores.spliterator().getExactSizeIfKnown();
		boolean reservaDuranteExistente = false;
		if (size > 0) {
			reservaDuranteExistente = true;
		}
		return reservaDuranteExistente;
	}
	
	public boolean salaIdAndReservaEarlierThanExisting(Long salaId, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndReservaEarlierThanExisting(salaId, fechaInicial, fechaFinal);
		long size = valores.spliterator().getExactSizeIfKnown();
		boolean reservaAntesDeExistentes = false;
		if (size > 0) {
			reservaAntesDeExistentes = true;
		}
		return reservaAntesDeExistentes;
	}
	
	public boolean salaIdAndReservaLaterThanExisting(Long salaId, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndReservaLaterThanExisting(salaId, fechaInicial, fechaFinal);
		long size = valores.spliterator().getExactSizeIfKnown();
		boolean reservaDespuesDeExistentes = false;
		if (size > 0) {
			reservaDespuesDeExistentes = true;
		}
		return reservaDespuesDeExistentes;
	}

	public Iterable<Reserva> findBySala(Sala sala) {
		return repositorio.findBySala(sala);
	}

	public Iterable<Reserva> findByUsuario(Usuario usuario) {
		return repositorio.findByUsuario(usuario);
	}
}
