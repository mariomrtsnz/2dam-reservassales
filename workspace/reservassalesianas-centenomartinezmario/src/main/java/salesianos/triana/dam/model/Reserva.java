package salesianos.triana.dam.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reserva_seq")
	@SequenceGenerator(name = "reserva_seq", sequenceName = "seq_reserva", allocationSize = 1)
	private Long id;
	private LocalDateTime fechaInicial;
	private LocalDateTime fechaFinal;
	@ManyToOne
	private Usuario usuario;
	@ManyToOne
	private Sala sala;

	public Reserva(LocalDateTime fechaInicial, LocalDateTime fechaFinal, Usuario usuario, Sala sala) {
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
		this.usuario = usuario;
		this.sala = sala;
	}

	public Reserva(Long id, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
		super();
		this.id = id;
		this.fechaInicial = fechaInicial;
		this.fechaFinal = fechaFinal;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(LocalDateTime fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public LocalDateTime getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(LocalDateTime fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + ", usuario="
				+ usuario + ", sala=" + sala + "]";
	}

}
