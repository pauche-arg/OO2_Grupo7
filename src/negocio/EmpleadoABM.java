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
		if (!(validarCampos(nombre, apellido, nombreUsuario, dni, email))) throw new Exception("Error en la validación de datos de Empleado.");
		if (traer(dni) != null) throw new Exception("Error: Un empleado con este DNI ya existe.");
		Empleado c = new Empleado(nombre, apellido, dni, email, nombreUsuario, contraseña); //contraseña luego iria encriptado
		return dao.agregar(c);
	}
	
	public void modificar(Empleado c) throws Exception {
		try {
			validarCampos(c.getNombre(), c.getApellido(), c.getNombreUsuario(), c.getDni(), c.getEmail());
		} catch (IllegalArgumentException e) {
		    throw new Exception("Error: " + e.getMessage());
		}
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


}
