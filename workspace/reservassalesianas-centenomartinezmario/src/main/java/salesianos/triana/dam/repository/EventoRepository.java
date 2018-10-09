package salesianos.triana.dam.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import salesianos.triana.dam.model.ReservaEvento;

@Repository
public interface EventoRepository extends JpaRepository<ReservaEvento, Long>{
	List<ReservaEvento> findAll();
	ReservaEvento save(ReservaEvento evento);
	void delete(ReservaEvento evento);
	List<ReservaEvento> findByDescription(String usuario);

}
