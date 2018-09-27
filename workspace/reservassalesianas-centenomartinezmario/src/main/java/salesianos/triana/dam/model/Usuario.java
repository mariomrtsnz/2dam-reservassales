package salesianos.triana.dam.model;

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

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
	@SequenceGenerator(name = "usuario_seq", sequenceName = "seq_usuario", allocationSize = 1)
	private Long id;

	@Column(unique = true, name = "EMAIL")
	private String email;
	private String pass;
	private String nombre;
	private String numTlf;
	private boolean validado;
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Reserva> reservas = new HashSet<Reserva>();
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
	private Set<Authorities> authorities = new HashSet<>();

	public Usuario(Long id, String email, String pass, String nombre, String numTlf, boolean validado,
			Set<Authorities> authorities) {
		super();
		this.id = id;
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.numTlf = numTlf;
		this.validado = validado;
		this.authorities = authorities;
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

	public Set<Authorities> getAuthorities() {
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
