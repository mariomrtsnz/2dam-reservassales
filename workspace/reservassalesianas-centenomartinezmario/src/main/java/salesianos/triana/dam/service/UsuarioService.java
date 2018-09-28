package salesianos.triana.dam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.repository.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	UsuarioRepository repositorio;
	
	public Usuario save(Usuario usuario) {
		return repositorio.save(usuario);
	}
	
	public Usuario findOne(Long id) {
		return repositorio.findById(id).orElse(null);
	}
	
	public Iterable<Usuario> findAll() {
		return repositorio.findAll();
	}
	
	public Usuario findFirstByEmailAndPass(String email, String pass) {
		return repositorio.findFirstByEmailAndPass(email, pass);
	}
	
	public Usuario remove(Usuario usuario) {
		Usuario usuarioEliminado = findOne(usuario.getId());
		if (usuarioEliminado != null)
			repositorio.delete(usuario);
		return usuarioEliminado;
	}
	
	public void edit(Usuario usuario) {
		save(usuario);
	}
}