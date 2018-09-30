package salesianos.triana.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import salesianos.triana.dam.model.Authorities;

@Repository
public interface AuthoritiesRepository extends JpaRepository<Authorities, String>{
	
}
