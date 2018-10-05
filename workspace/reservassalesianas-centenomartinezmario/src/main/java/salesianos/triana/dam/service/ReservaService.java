package salesianos.triana.dam.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.Reserva;
import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.repository.ReservaRepository;

@Service
public class ReservaService {
	@Autowired
	ReservaRepository repositorio;

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
		return repositorio.save(entidad);
	}

	public Reserva remove(Reserva entidad) {
		Reserva reservaABorrar = findOne(entidad.getId());
		if (reservaABorrar != null)
			repositorio.delete(entidad);
		return reservaABorrar;
	}

	public void edit(Reserva entidad) {
		remove(entidad);
		save(entidad);
	}

	public Iterable<Reserva> findAllByFechaInicialAndFechaFinalBetween(LocalDateTime fechaInicial,
			LocalDateTime fechaFinal) {
		return repositorio.findAllByFechaFinalBetween(fechaInicial, fechaFinal);
	}
	
	public Iterable<Reserva> findBySalaIdAndFechaInicialAndFechaFinalBetween(Long salaId, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		return repositorio.findBySalaIdAndFechaInicialAndFechaFinalBetween(salaId, fechaInicial, fechaFinal);
	}
	
	
	public boolean salaIdAndFechaInicialLaterThanReserva(Long salaId, LocalDateTime fechaFinal) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndFechaInicialLaterThanReserva(salaId, fechaFinal);
		long size = valores.spliterator().getExactSizeIfKnown();
		boolean despuesDeReserva = false;
		if (size == 0) {
			despuesDeReserva = true;
		}
		return despuesDeReserva;
	}
	
	public boolean salaIdAndFechaFinalEarlierThanReserva(Long salaId, LocalDateTime fechaInicial) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndFechaFinalEarlierThanReserva(salaId, fechaInicial);
		long size = valores.spliterator().getExactSizeIfKnown();
		// Se setea en true porque devuelve si NO solapan.
		boolean antesDeReserva = false;
		if (size == 0) {
			antesDeReserva = true;
		}
		return antesDeReserva;
	}
	
	public boolean salaIdAndFechaInicialEarlierThanReserva(Long salaId, LocalDateTime fechaInicial) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndFechaInicialEarlierThanReserva(salaId, fechaInicial);
		long size = valores.spliterator().getExactSizeIfKnown();
		// Se setea en true porque devuelve si NO solapan.
		boolean antesDeReserva = false;
		if (size == 0) {
			antesDeReserva = true;
		}
		return antesDeReserva;
	}
	
	public boolean salaIdAndFechaFinalLaterThanReserva(Long salaId, LocalDateTime fechaFinal) {
		Iterable<Reserva> valores = repositorio.findBySalaIdAndFechaInicialEarlierThanReserva(salaId, fechaFinal);
		long size = valores.spliterator().getExactSizeIfKnown();
		// Se setea en true porque devuelve si NO solapan.
		boolean antesDeReserva = false;
		if (size == 0) {
			antesDeReserva = true;
		}
		return antesDeReserva;
	}

	public Iterable<Reserva> findBySala(Sala sala) {
		return repositorio.findBySala(sala);
	}

	public Iterable<Reserva> findByUsuario(Usuario usuario) {
		return repositorio.findByUsuario(usuario);
	}
}
