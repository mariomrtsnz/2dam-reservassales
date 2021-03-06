package salesianos.triana.dam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.Authorities;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.repository.UsuarioRepository;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {
	@Autowired
	UsuarioRepository repositorio;
	
	@Autowired
	AuthoritiesService authoritiesService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void save(Usuario usuario) {
		usuario.setPass(passwordEncoder.encode(usuario.getPass()));
//		Para asignarle ROLE_USER por defecto al usuario creado.
		repositorio.save(usuario);
		if (usuario.getAuthorities().isEmpty()) {			
			Authorities authorityUser = new Authorities("ROLE_USER", usuario);
			authoritiesService.save(authorityUser);
		}
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
	
	public Usuario findFirstByEmail(String email) {
		return repositorio.findFirstByEmail(email);
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findUsuarioWithAuthorities(email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Email no encontrado");

		}

		return usuario;
	}

}