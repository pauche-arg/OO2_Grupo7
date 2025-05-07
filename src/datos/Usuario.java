package datos;

public class Usuario extends Persona {

	private int idUsuario;
	private String nombreUsuario;
	private String contraseña;
	
	public Usuario(){}
	
	public Usuario(String nombre, String apellido, String dni, String email,
			String nombreUsuario, String contraseña) {
		super(nombre, apellido, dni, email);
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
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
	
	
}
