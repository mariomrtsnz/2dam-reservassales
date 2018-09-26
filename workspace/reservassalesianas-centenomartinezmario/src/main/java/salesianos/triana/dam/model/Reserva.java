package salesianos.triana.dam.model;

import java.time.LocalDateTime;

public class Reserva {
	private Long id;
	private LocalDateTime fechaInicial;
	private LocalDateTime fechaFinal;

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

	@Override
	public String toString() {
		return "Reserva [id=" + id + ", fechaInicial=" + fechaInicial + ", fechaFinal=" + fechaFinal + "]";
	}

}
