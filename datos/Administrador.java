package datos;

public class Administrador extends Usuario {	
	public Administrador(){}

	public Administrador(String nombre, String apellido, String dni, String email, String nombreUsuario,
			String contraseña) throws Exception {
		super(nombre, apellido, dni, email, nombreUsuario, contraseña);
	}

	@Override
	public String toString() {
		return "Administrador " + super.toString();
	}

	
	
	
	
	

}
