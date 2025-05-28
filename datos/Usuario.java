package datos;

import java.util.Objects;

public class Usuario extends Persona {

	//private int idUsuario;
	//private String nombreUsuario;
	//private String contraseña;
	private String nrocliente;
	
	public Usuario(){}
	

	public Usuario(String nombre, String apellido, String dni, String email, String nombreUsuario, String clave,
			String nrocliente) throws Exception {
		super(nombre, apellido, dni, email, nombreUsuario, clave);
		this.nrocliente = nrocliente;
	}
	
	
	public static void validarNombreApellido(String nombre, String apellido) throws Exception {
		if (nombre == null || nombre.trim().isEmpty()) {
	        throw new Exception("El nombre no puede estar vacío.");
	    }
	    if (!nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
	        throw new Exception("El nombre contiene caracteres inválidos.");
	    }

	    if (apellido == null || apellido.trim().isEmpty()) {
	        throw new Exception("El apellido no puede estar vacío.");
	    }
	    if (!apellido.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
	        throw new Exception("El apellido contiene caracteres inválidos.");
	    }
	}
	
	public static void validarNombreUsuario(String nombreUsuario) throws Exception {
	    if (nombreUsuario == null || !nombreUsuario.matches("^[a-zA-Z][a-zA-Z0-9_]{3,}$")) {
	        throw new Exception("Nombre de usuario inválido.");
	    }
	}
	
	public static void validarEmail(String email) throws Exception {
	    if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
	        throw new Exception("Email inválido.");
	    }
	}
	
	public static void validarDNI(String dni) throws Exception {
	    if (dni == null || !dni.matches("\\d{7,10}")) {
	        throw new Exception("DNI inválido.");
	    }
	}
	
	

	/*public int getIdUsuario() {
		return idUsuario;
	}

	private void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	private void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}*/
	
	public String getNrocliente() {
		return nrocliente;
	}


	public void setNrocliente(String nrocliente) {
		this.nrocliente = nrocliente;
	}


	@Override
	public String toString() {
		return "Usuario [nrocliente=" + nrocliente + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(nrocliente);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nrocliente, other.nrocliente);
	}

	

	
}
