package salesianos.triana.dam.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Event")
public class ReservaEvento {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String title;
	private String description;
	@Column(name="start")
	private LocalDateTime start;
	@Column(name="end")
	private LocalDateTime end;

	public ReservaEvento() {
	}

	public ReservaEvento(Long id, String title, String description, LocalDateTime start, LocalDateTime end) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.start = start;
		this.end = end;
	}

	public ReservaEvento(String title, String description, LocalDateTime start, LocalDateTime end) {
		super();
		this.title = title;
		this.description = description;
		this.start = start;
		this.end = end;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public void setStart(LocalDateTime start) {
		this.start = start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public void setEnd(LocalDateTime end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "ReservaEvento [id=" + id + ", title=" + title + ", description=" + description + ", start=" + start
				+ ", end=" + end + "]";
	}

}
