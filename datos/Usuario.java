package datos;

import java.util.Objects;

public class Usuario extends Persona {

	private int idUsuario;
	private String nombreUsuario;
	private String contraseña;
	
	public Usuario(){}
	
	public Usuario(String nombre, String apellido, String dni, String email,
			String nombreUsuario, String contraseña) throws Exception {
		super(nombre, apellido, dni, email);
		validarNombreApellido(nombre, apellido);
		validarNombreUsuario(nombreUsuario);
		validarEmail(email);
		validarDNI(dni);
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
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

	public int getIdUsuario() {
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
	}
	
	@Override
	public String toString() {
		return "Usuario [nombreUsuario=" + nombreUsuario + ", contraseña=" + contraseña + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(contraseña, idUsuario, nombreUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(contraseña, other.contraseña) && idUsuario == other.idUsuario
				&& Objects.equals(nombreUsuario, other.nombreUsuario);
	}
	
	
	
	
}
