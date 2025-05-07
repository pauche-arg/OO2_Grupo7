package negocio;

import datos.Empleado;
import datos.Ticket;
import datos.Usuario;

import java.time.LocalDate;
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


}
