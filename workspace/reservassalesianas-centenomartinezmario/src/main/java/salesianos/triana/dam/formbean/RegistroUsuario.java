package salesianos.triana.dam.formbean;

public class RegistroUsuario {
	private String email;
	private String pass;
	private String nombre;
	private String numTlf;

	public RegistroUsuario() {

	}

	public RegistroUsuario(String email, String pass, String nombre, String numTlf) {
		super();
		this.email = email;
		this.pass = pass;
		this.nombre = nombre;
		this.numTlf = numTlf;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((numTlf == null) ? 0 : numTlf.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroUsuario other = (RegistroUsuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (numTlf == null) {
			if (other.numTlf != null)
				return false;
		} else if (!numTlf.equals(other.numTlf))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "RegistroUsuario [email=" + email + ", pass=" + pass + ", nombre=" + nombre + ", numTlf=" + numTlf + "]";
	}

}
