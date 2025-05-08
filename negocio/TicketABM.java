package negocio;

import datos.Empleado;
import datos.Ticket;
import datos.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDao;

public class TicketABM {
	TicketDao dao = new TicketDao();

	
	public static boolean validarCampos(String titulo, String descripcion, String estado, Usuario usuario) throws Exception {
		try {
			
			validarTitulo(titulo);
			validarDescripcion(descripcion);
			validarEstado(estado);
			validarUsuarioCreador(usuario);
	    
			return true;
	} catch (Exception e) {
		System.err.println("Error de validación: " + e.getMessage());
		
		return false;
	}
}
	
	public static void validarTitulo(String titulo) throws Exception {
		 if (titulo == null ||titulo.trim().isEmpty()) {
		        throw new Exception("El título no puede estar vacío.");
		    }
		 
		 if (!titulo.matches(".*[a-zA-Z].*")) {
			    throw new Exception("El título debe contener al menos una letra.");
			}
	}
	
	public static void validarDescripcion(String descripcion) throws Exception {
		 if (descripcion == null || descripcion.trim().isEmpty()) {
		        throw new Exception("La descripción no puede estar vacía.");
		    }
		 
		 if (!descripcion.matches(".*[a-zA-Z].*")) {
			    throw new Exception("La descripción debe contener al menos una letra.");
			}
	}
	
	public static void validarEstado(String estado) throws Exception {
	    if (estado == null || estado.trim().isEmpty()) {
	        throw new Exception("El estado no puede estar vacío.");
	    }

	    String estadoNormalizado = estado.trim().toLowerCase();

	    if (!(estadoNormalizado.equals("pendiente") || 
	          estadoNormalizado.equals("en proceso") || 
	          estadoNormalizado.equals("resuelto"))) {
	        throw new Exception("El estado debe ser: Pendiente, En proceso o Resuelto.");
	    }
	}
	
	public static void validarUsuarioCreador(Usuario usuario) throws Exception {
	    if (usuario == null) {
	        throw new Exception("Debe especificarse un usuario creador para el ticket.");
	    }
	}
	
	
	public int agregar(String titulo, String descripcion, LocalDate fechaCreacion, String estado,
			Usuario usuarioCreador, Empleado empleadoAsignado) throws Exception {
				if (!(validarCampos(titulo, descripcion, estado, usuarioCreador)))  throw new Exception("Error en la validación de datos de Ticket.");
		Ticket c = new Ticket(titulo, descripcion, fechaCreacion, estado, usuarioCreador, empleadoAsignado); //empleadoAsignado puede ser null
		return dao.agregar(c);
	}
	
	public int agregar(Ticket ticket) throws Exception {
				if (!(validarCampos(ticket.getTitulo(), ticket.getDescripcion(), ticket.getEstado(), ticket.getUsuarioCreador())))  throw new Exception("Error en la validación de datos de Ticket.");
		return dao.agregar(ticket);
	}
	
	
	public void modificar(Ticket c) throws Exception {
		try {
			validarCampos(c.getTitulo(), c.getDescripcion(), c.getEstado(), c.getUsuarioCreador());
		} catch (Exception e) {
		    throw new Exception("Error: " + e.getMessage());
		}
		dao.actualizar(c);
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
