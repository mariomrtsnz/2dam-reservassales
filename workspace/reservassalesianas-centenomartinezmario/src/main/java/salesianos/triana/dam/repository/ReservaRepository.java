package salesianos.triana.dam.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import salesianos.triana.dam.model.Reserva;
import salesianos.triana.dam.model.Sala;
import salesianos.triana.dam.model.Usuario;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
	Reserva findByFechaInicial(LocalDateTime fechaInicial);

	Iterable<Reserva> findAllByFechaInicial(LocalDateTime fechaInicial);

	Reserva findByFechaFinal(LocalDateTime fechaFinal);

	Iterable<Reserva> findAllByFechaFinal(LocalDateTime fechaFinal);

	Iterable<Reserva> findBySala(Sala sala);

	Iterable<Reserva> findByUsuario(Usuario usuario);

	Iterable<Reserva> findAllByFechaInicialBetween(LocalDateTime fechaInicial, LocalDateTime fechaFinal);

	Iterable<Reserva> findAllByFechaFinalBetween(LocalDateTime fechaInicial, LocalDateTime fechaFinal);

	@Query("select distinct r from Reserva r where r.fechaInicial >= ?1 and r.fechaFinal <= ?2")
	Iterable<Reserva> findAllByFechaInicialAndFechaFinalBetween(LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
