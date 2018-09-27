package salesianos.triana.dam.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Sala {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_seq")
	@SequenceGenerator(name = "sala_seq", sequenceName = "seq_sala", allocationSize = 1)
	private Long id;
	private String nombre;
	private int aforoMax;
	@OneToMany(mappedBy = "sala", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	Set<Reserva> reservas = new HashSet<Reserva>();

	public Sala(Long id, String nombre, int aforoMax) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.aforoMax = aforoMax;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getAforoMax() {
		return aforoMax;
	}

	public void setAforoMax(int aforoMax) {
		this.aforoMax = aforoMax;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + ", aforoMax=" + aforoMax + ", reservas=" + reservas + "]";
	}

	public void addReserva(Reserva r) {
		if (r != null) {
			r.setSala(this);
			this.getReservas().add(r);
		}
	}

	public void removeReserva(Reserva r) {
		if (r != null) {
			r.setSala(null);
			this.getReservas().remove(r);
		}
	}

}
