package salesianos.triana.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import salesianos.triana.dam.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findFirstByEmailAndPassword(String email, String password);
	Usuario findFirstByEmail(String email);
}