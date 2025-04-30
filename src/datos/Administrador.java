package datos;

public class Administrador extends Usuario {
	private int idAdministrador;

	public Administrador(String nombre, String apellido, String dni, String email, String nombreUsuario,
			String contraseña) {
		super(nombre, apellido, dni, email, nombreUsuario, contraseña);
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	private void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}
	
	
	

}
