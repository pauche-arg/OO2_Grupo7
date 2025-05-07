package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.TicketDao;
import datos.Empleado;
import datos.Ticket;
import datos.Usuario;

public class TicketAbm {
	private TicketDao dao = new TicketDao();
	
	public Ticket traerSinUsuario(int id) {
		return dao.traeSinUsuario(id);
	}
	
	public List<Ticket> traer(Usuario u){
		return dao.traer(u);
	}
	
	public int agregar(String titulo, String descripcion,Usuario usuarioCreador) {
		Ticket t = new Ticket(titulo, descripcion, LocalDate.of(2000, 3, 1), "abierto", usuarioCreador, null);
		return dao.agregar(t);
	}
	
	public Ticket traer(int idticket) {
		return dao.traer(idticket);
	}
	
	

}
