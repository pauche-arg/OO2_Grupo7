package negocio;

import datos.Administrador;
import datos.Empleado;
import datos.Usuario;

import java.util.List;

import dao.AdministradorDao;

public class AdministradorABM extends UsuarioABM {
	AdministradorDao dao = new AdministradorDao();
	
	@Override
	public Administrador traer(int idUsuario) {
		return dao.traer(idUsuario);
	}
	
	@Override
	public Administrador traer(String dni) {
		return dao.traer(dni);
	}
	
	@Override
	public int agregar(String nombre, String apellido, String dni, String email,
			String nombreUsuario, String contraseña) throws Exception {
		if (traer(dni) != null) throw new Exception("Error: Un administrador con este DNI ya existe.");
		Administrador c = new Administrador(nombre, apellido, dni, email, nombreUsuario, contraseña); //contraseña luego iria encriptado
		return dao.agregar(c);
	}
	
	public void modificar(Administrador c) throws Exception {
		dao.actualizar(c);
	}
	
	@Override
	public void eliminar(int idUsuario) throws Exception {
		Administrador c = dao.traer(idUsuario);
		if (c == null) throw new Exception("Error: El administrador no existe.");
		dao.eliminar(c);
	}
	
	@Override
	public void eliminarPorDni(String dni) throws Exception {
		Administrador c = dao.traer(dni);
		if (c == null) throw new Exception("Error: El administrador no existe.");
		dao.eliminar(c);
	}
	
	public List<Administrador> traerEmpleados() {
		return dao.traer();
	}
	
	public void asignarTicket(int idticket, Empleado emp) throws Exception {
		dao.asignarTicket(idticket, emp);
	}


}
