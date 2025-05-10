package negocio;

import datos.Empleado;
import datos.Ticket;
import datos.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDao;
import dao.UsuarioDao;
import dao.EmpleadoDao;

public class TicketABM {
	TicketDao dao = new TicketDao();
	UsuarioDao usuarioDao = new UsuarioDao();
	EmpleadoDao empleadoDao = new EmpleadoDao();

	
	public int agregar(String titulo, String descripcion,
			Usuario usuarioCreador, Empleado empleadoAsignado) throws Exception {
		
		 Usuario usuario = usuarioDao.traer(usuarioCreador.getIdUsuario());
		 Empleado empleado = null;
		 
		 if (empleadoAsignado != null) {
		        empleado = empleadoDao.traer(empleadoAsignado.getIdUsuario());
		    }
		 
		Ticket c = new Ticket(titulo, descripcion, usuario, empleado); //empleadoAsignado puede ser null
		return dao.agregar(c);
	}
	
	public int agregar(Ticket ticket) throws Exception {
		return dao.agregar(ticket);
	}
	
	
	public void modificar(Ticket c) throws Exception {
		try {
			dao.actualizar(c);
		} catch (Exception e) {
		    throw new Exception("Error: " + e.getMessage());
		}
	}
	
	public void eliminar(int idTicket) throws Exception {
		Ticket c = dao.traer(idTicket);
		if (c == null) throw new Exception("Error: El ticket no existe.");
		dao.eliminar(c);
	}
	
	
	public Ticket traerTicket(int idTicket) {
		return dao.traer(idTicket);
	}
	
	public List<Ticket> traerTickets() {
		return dao.traer();
	}

	public List<Ticket> traerPorEstado(String estado){
		return dao.filtrado(estado);
	}
	
	public List<Ticket> listarTicketsPorUsuario(int idUsuario) throws Exception {
		UsuarioABM usuarioABM = new UsuarioABM();
		Usuario usuario = usuarioABM.traer(idUsuario); 
	
		
		 if (usuario == null) throw new Exception("Usuario no encontrado.");
		 
		List<Ticket> ticketLista = new ArrayList<Ticket>();
		
		for (Ticket ticket : traerTickets() ) { 
			 if (ticket.getUsuarioCreador().getIdUsuario() == idUsuario) {
		            ticketLista.add(ticket);
		        }
		    }
		
		return ticketLista;
		}
		 
	public List<Ticket> listarTicketsPorEmpleado(int idEmpleado) throws Exception {
		EmpleadoABM empleadoABM = new EmpleadoABM();
		Empleado empleado = empleadoABM.traer(idEmpleado); 
	
		
		if (empleado == null) throw new Exception("Empleado no encontrado.");
		 
		List<Ticket> ticketLista = new ArrayList<Ticket>();
		
		for (Ticket ticket : traerTickets() ) { 
			if (ticket.getEmpleadoAsignado() != null && ticket.getEmpleadoAsignado().getIdUsuario() == idEmpleado) {
		            ticketLista.add(ticket);
		        }
		    }
		
		return ticketLista;
		}

}
