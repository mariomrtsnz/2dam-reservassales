package salesianos.triana.dam.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import salesianos.triana.dam.model.Authorities;
import salesianos.triana.dam.model.Usuario;
import salesianos.triana.dam.repository.UsuarioRepository;

@Service("userDetailsService")
public class UsuarioService implements UserDetailsService {
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repositorio.findUsuarioWithAuthorities(email);
		if (usuario == null) {
			throw new UsernameNotFoundException("Email no encontrado");
			
		}
		
		return usuario;
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Authorities> authorities){
        return authorities.stream()
                .map(authority -> new SimpleGrantedAuthority(authority.getAuthority()))
                .collect(Collectors.toList());
    }

}