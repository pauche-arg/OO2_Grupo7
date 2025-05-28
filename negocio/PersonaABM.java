package negocio;

import java.util.List;

import dao.PersonaDao;
import datos.Area;
import datos.Empleado;
import datos.Persona;
import datos.Usuario;

public class PersonaABM {
	private static PersonaABM instancia = null;
	
	protected PersonaABM() {
		
	}
	
	public static PersonaABM getInstance() {
		if(instancia==null)
			instancia = new PersonaABM();
		return instancia;
	}
	
	
	public int agregarUsuario(String nombre, String apellido, String dni, String email, String nombreUsuario, String clave, String nrocliente)throws Exception {
		if (traer(dni) != null) throw new Exception("Error: Una persona con este DNI ya existe.");
			Usuario p = new Usuario(nombre, apellido, dni, email, nombreUsuario, clave, nrocliente);
		return PersonaDao.getInstance().agregar(p);
	}
	
	public int agregarEmpleado(String nombre, String apellido, String dni, String email, String nombreUsuario, String clave, boolean disponibilidad, 
			boolean superior, Area area) throws Exception {
		if (traer(dni) != null) throw new Exception("Error: Una persona con este DNI ya existe.");
			Empleado p = new Empleado(nombre, apellido, dni, email, nombreUsuario, clave, disponibilidad, superior, area);
		return PersonaDao.getInstance().agregar(p);
	}
	
	public void actualizar(Persona p) {
		PersonaDao.getInstance().actualizar(p);
	}
	
	public void eliminar(Persona p) {
		PersonaDao.getInstance().eliminar(p);
	}
	
	public Persona traer(int idPersona) {
		return PersonaDao.getInstance().traer(idPersona);
	}
	
	public Persona traer(String dni) {
		return PersonaDao.getInstance().traer(dni);
	}
	
	public Persona traerId(int idPersona) {
		return PersonaDao.getInstance().traerId(idPersona);
	}
	
	public List<Persona> traerPersonas(){
		return PersonaDao.getInstance().traer();
	}
	
	public List<Usuario> traerUsuarios(){
		return PersonaDao.getInstance().traerUsuarios();
	}
	
	public List<Empleado> traerEmpleados(){
		return PersonaDao.getInstance().traerEmpleados();
	}

}
