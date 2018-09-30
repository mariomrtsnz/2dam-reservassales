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
	@Column(name= "ID")
	private Long id;

	@Column(unique = true)
	private String email;
	private String pass;
	private String nombre;
	@Column(unique = true, name = "NUM_TLF")
	private String numTlf;
	private boolean validado;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Reserva> reservas = new HashSet<Reserva>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<Authorities> authorities = new HashSet<>();

	public Usuario() {
	};

	public Usuario(String email, String pass, String nombre, String numTlf, boolean validado, Set<Authorities> authorities) {
		super();
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.numTlf = numTlf;
		this.validado = validado;
		this.authorities = authorities;
	}

	public Usuario(String email, String pass, String nombre, String numTlf, boolean validado) {
		super();
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.numTlf = numTlf;
		this.validado = validado;
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

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
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
				+ ", validado=" + validado + ", reservas=" + reservas + "]";
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
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

}
