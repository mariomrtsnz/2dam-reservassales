package salesianos.triana.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import salesianos.triana.dam.model.Sala;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long> {

}
