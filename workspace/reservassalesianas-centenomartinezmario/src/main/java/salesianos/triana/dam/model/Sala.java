package salesianos.triana.dam.model;

public class Sala {
	private Long id;
	private String nombre;
	private int aforoMax;

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

	@Override
	public String toString() {
		return "Sala [id=" + id + ", nombre=" + nombre + ", aforoMax=" + aforoMax + "]";
	}

}
