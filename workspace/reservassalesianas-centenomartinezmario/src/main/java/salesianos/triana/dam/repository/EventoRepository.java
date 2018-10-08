package salesianos.triana.dam.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import salesianos.triana.dam.model.ReservaEvento;

@Repository
public interface EventoRepository extends JpaRepository<ReservaEvento, Long>{
	List<ReservaEvento> findAll();
	ReservaEvento save(ReservaEvento evento);
	void delete(ReservaEvento evento);
	List<ReservaEvento> findByDescription(String usuario);
	
//	@Query("select b from Event b " + "where b.start between ?1 and ?2 and b.end between ?1 and ?2")
//	List<ReservaEvento> findByDatesBetween(LocalDateTime start, LocalDateTime end);

}
