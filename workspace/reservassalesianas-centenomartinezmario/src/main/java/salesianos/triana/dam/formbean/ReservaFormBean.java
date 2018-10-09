package salesianos.triana.dam.formbean;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ReservaFormBean {
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horaInicio;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaInicio;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horaFin;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaFin;
	private Long salaId;
	private Long usuarioId;
	private boolean semanal;
	private int numSemanas;

	public ReservaFormBean() {
	}

	public ReservaFormBean(LocalTime horaInicio, LocalDate fechaInicio, LocalTime horaFin, LocalDate fechaFin,
			Long salaId, Long usuarioId, boolean semanal, int numSemanas) {
		super();
		this.horaInicio = horaInicio;
		this.fechaInicio = fechaInicio;
		this.horaFin = horaFin;
		this.fechaFin = fechaFin;
		this.salaId = salaId;
		this.usuarioId = usuarioId;
		this.semanal = semanal;
		this.numSemanas = numSemanas;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Long getSalaId() {
		return salaId;
	}

	public void setSalaId(Long salaId) {
		this.salaId = salaId;
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public boolean isSemanal() {
		return semanal;
	}

	public void setSemanal(boolean semanal) {
		this.semanal = semanal;
	}

	public int getNumSemanas() {
		return numSemanas;
	}

	public void setNumSemanas(int numSemanas) {
		this.numSemanas = numSemanas;
	}

	@Override
	public String toString() {
		return "ReservaFormBean [horaInicio=" + horaInicio + ", fechaInicio=" + fechaInicio + ", horaFin=" + horaFin
				+ ", fechaFin=" + fechaFin + ", salaId=" + salaId + ", usuarioId=" + usuarioId + "]";
	}

}
