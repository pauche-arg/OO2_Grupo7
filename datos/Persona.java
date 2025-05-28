package datos;

public class Persona {
	private int idPersona;
	private String nombre;
	private String apellido;
	private String dni;
	private String email;
	private String nombreUsuario;
	private String clave;
	
	public Persona() {}
	

	public Persona(String nombre, String apellido, String dni, String email, String nombreUsuario, String clave) throws Exception {
		super();
		validarNombreApellido(nombre, apellido);
		validarDNI(dni);
		validarEmail(email);
		validarNombreUsuario(nombreUsuario);
		this.clave = clave;
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

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + ", email=" + email + "]";
	}
	
	
}
