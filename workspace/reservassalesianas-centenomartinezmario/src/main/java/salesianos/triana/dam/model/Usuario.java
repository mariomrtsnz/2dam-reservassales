package salesianos.triana.dam.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
	@SequenceGenerator(name = "usuario_seq", sequenceName = "seq_usuario", allocationSize = 1)
	private Long id;

	@Column(unique = true)
	private String email;
	private String pass;
	private String nombre;
	@Column(unique = true, name = "NUM_TLF")
	private String numTlf;
	private boolean enabled;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Reserva> reservas = new HashSet<Reserva>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<Authorities> authorities = new HashSet<>();
	private String foto;

	public Usuario() {
	};

	public Usuario(String email, String pass, String nombre, String numTlf, boolean enabled,
			Set<Authorities> authorities, String foto) {
		super();
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.numTlf = numTlf;
		this.enabled = enabled;
		this.authorities = authorities;
		this.foto = foto;
	}

	public Usuario(String email, String pass, String nombre, String numTlf, boolean enabled, String foto) {
		super();
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.numTlf = numTlf;
		this.enabled = enabled;
		this.foto = foto;
	}
	
	public Usuario(String email, String pass, String nombre, String numTlf, boolean enabled) {
		super();
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.numTlf = numTlf;
		this.enabled = enabled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNumTlf() {
		return numTlf;
	}

	public void setNumTlf(String numTlf) {
		this.numTlf = numTlf;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", pass=" + pass + ", nombre=" + nombre + ", numTlf=" + numTlf
				+ ", validado=" + enabled + ", reservas=" + reservas + ", authorities=" + authorities + ", foto" + foto + "]";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return pass;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void addReserva(Reserva r) {
		if (r != null) {
			r.setUsuario(this);
			this.getReservas().add(r);
		}
	}

	public void removeReserva(Reserva r) {
		if (r != null) {
			r.setUsuario(null);
			this.getReservas().remove(r);
		}
	}

//	public void addRole(Authorities a) {
//		if (a != null) {
//			a.setUsuario(this);
//			this.getAuthorities().add(a);
//		}
//	}

	public void removeAuthority(Authorities a) {
		if (a != null) {
			a.setUsuario(null);
			this.getAuthorities().remove(a);
		}
	}

}
