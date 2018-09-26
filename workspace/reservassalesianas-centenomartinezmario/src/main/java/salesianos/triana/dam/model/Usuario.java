package salesianos.triana.dam.model;

public class Usuario {
	private Long id;
	private String email;
	private String pass;
	private String nombre;
	private String numTlf;
	private boolean validado;

	public Usuario(Long id, String email, String pass, String nombre, String numTlf, boolean validado) {
		super();
		this.id = id;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", pass=" + pass + ", nombre=" + nombre + ", numTlf=" + numTlf
				+ ", validado=" + validado + "]";
	}

}
