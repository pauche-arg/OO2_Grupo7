package negocio;

import java.util.List;

import dao.TicketDao;
import dao.UsuarioDao;
import datos.Empleado;
import datos.Usuario;

public class UsuarioAbm {
	private static UsuarioAbm instancia = null;
	
	protected UsuarioAbm() {
		
	}
	
	public static UsuarioAbm getInstance() {
		if(instancia == null)
			instancia = new UsuarioAbm();
		return instancia;
	}
	
	public Usuario traer(int idUsuario) {
		return UsuarioDao.getInstance().traer(idUsuario);
	}
	
	public List<Usuario> traer(){
		return UsuarioDao.getInstance().traer();
	}
	
	public int agregar(String nombre, String apellido, String dni, String email,
		String nombreUsuario, String contraseña) throws Exception{
		Usuario u = UsuarioDao.getInstance().traerDni(dni);
		if(u!=null){
			throw new Exception("Usuario ya agregado");
		}else {
			u = new Usuario(nombre, apellido, dni, email, nombreUsuario, contraseña);
		}
		
		return UsuarioDao.getInstance().agregar(u);
	}
	
	public int agregarEmp(String nombre, String apellido, String dni, String email,
			String nombreUsuario, String contraseña) {
		Empleado e = new Empleado(nombre, apellido, dni, email, nombreUsuario, contraseña);
		return UsuarioDao.getInstance().agregarEmpl(e);
	}
	
	public void eliminar(Usuario objeto){
		UsuarioDao.getInstance().eliminar(objeto);
	}
	
	public Usuario traerDni(String dni) {
		return UsuarioDao.getInstance().traerDni(dni);
	}
	
	
	public void asignarTicket(int id, Empleado emp) {
		TicketDao dao = new TicketDao();
		dao.asignarTicket(id, emp);
	}
	
	public void cambiarEstado(int idTicket) {
		TicketAbm abm = new TicketAbm();
		abm.traerSinUsuario(idTicket).setEstado("cerrado");
	
	}

}