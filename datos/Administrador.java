package datos;

public class Administrador extends Persona {	
	public Administrador(){}

	public Administrador(String nombre, String apellido, String dni, String email, String nombreUsuario, String clave) throws Exception {
		super(nombre, apellido, dni, email, nombreUsuario, clave);
	}

	@Override
	public String toString() {
		return "Administrador " + super.toString();
	}

	
	
	
	
	

}
