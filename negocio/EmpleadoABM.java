package negocio;

import datos.Empleado;

import java.util.List;

import dao.EmpleadoDao;

public class EmpleadoABM extends UsuarioABM {
	EmpleadoDao dao = new EmpleadoDao();
	
	@Override
	public Empleado traer(int idUsuario) {
		return dao.traer(idUsuario);
	}
	
	@Override
	public Empleado traer(String dni) {
		return dao.traer(dni);
	}
	
	@Override
	public int agregar(String nombre, String apellido, String dni, String email,
			String nombreUsuario, String contraseña) throws Exception {
		if (traer(dni) != null) throw new Exception("Error: Un empleado con este DNI ya existe.");
		Empleado c = new Empleado(nombre, apellido, dni, email, nombreUsuario, contraseña); //contraseña luego iria encriptado
		return dao.agregar(c);
	}
	
	public void modificar(Empleado c) throws Exception {
		dao.actualizar(c);
	}
	
	@Override
	public void eliminar(int idUsuario) throws Exception {
		Empleado c = dao.traer(idUsuario);
		if (c == null) throw new Exception("Error: El empleado no existe.");
		dao.eliminar(c);
	}
	
	@Override
	public void eliminarPorDni(String dni) throws Exception {
		Empleado c = dao.traer(dni);
		if (c == null) throw new Exception("Error: El empleado no existe.");
		dao.eliminar(c);
	}
	
	public List<Empleado> traerEmpleados() {
		return dao.traer();
	}
	
	public void cambiarEstado(int idticket, Empleado emp) throws Exception {
		dao.cambiarEstado(idticket, emp);
	}


}
