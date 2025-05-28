package negocio;

import datos.Usuario;

import java.util.List;

import dao.UsuarioDao;

public class UsuarioABM {
	UsuarioDao dao = new UsuarioDao();
	
	public Usuario traer(int idUsuario) {
		return dao.traer(idUsuario);
	}
	
	public Usuario traer(String dni) {
		return dao.traer(dni);
	}
	    
	//Valida un nombre de usuario. No puede empezar con un guion bajo, un numero o tener menos de 3 caracteres.
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
	
	public int agregar(String nombre, String apellido, String dni, String email, String nombreUsuario, String clave,
			String nrocliente) throws Exception {
		if (traer(dni) != null) throw new Exception("Error: Un usuario con este DNI ya existe.");
			Usuario c = new Usuario(nombre, apellido, dni, email, nombreUsuario, clave, nrocliente); //contraseña luego iria encriptado
		return dao.agregar(c);
	}
	
	public void modificar(Usuario c) throws Exception {
		dao.actualizar(c);
	}
	
	public void eliminar(int idUsuario) throws Exception {
		Usuario c = dao.traer(idUsuario);
		if (c == null) throw new Exception("Error: El usuario no existe.");
		dao.eliminar(c);
	}
	
	public void eliminarPorDni(String dni) throws Exception {
		Usuario c = dao.traer(dni);
		if (c == null) throw new Exception("Error: El usuario no existe.");
		dao.eliminar(c);
	}
	
	public List<Usuario> traerUsuarios() {
		return dao.traer();
	}


}
