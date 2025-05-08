package negocio;

import datos.Respuesta;
import datos.Ticket;

import java.time.LocalDate;
import java.util.List;

import dao.RespuestaDao;

public class RespuestaABM {
	RespuestaDao dao = new RespuestaDao();

	
	public static void validarContenido(String contenido) throws Exception {
		 if (contenido == null ||contenido.trim().isEmpty()) {
		        throw new IllegalArgumentException("El contenido de la respuesta no puede estar vacía.");
		    }
		 
		 if (!contenido.matches(".*[a-zA-Z].*")) {
			    throw new IllegalArgumentException("El contenido de la respuesta debe contener al menos una letra.");
			}
	}
	
	
	public static void validarTicket(Ticket ticket) throws Exception {
	    if (ticket == null) {
	        throw new Exception("Debe especificarse un ticket para la respuesta.");
	    }
	}
	
	
	public int agregar(String contenido, LocalDate fecha, Ticket ticket) throws Exception {
			try {
				validarContenido(contenido);
				validarTicket(ticket);
			} catch (Exception e) {
			    throw new Exception("Error: " + e.getMessage());
			}
		Respuesta c = new Respuesta(contenido, fecha, ticket);
		return dao.agregar(c);
	}
	
	public void modificar(Respuesta c) throws Exception {
		try {
			validarContenido(c.getContenido());
			validarTicket(c.getTicket());
		} catch (Exception e) {
		    throw new Exception("Error: " + e.getMessage());
		}
		dao.actualizar(c);
	}
	
	public void eliminar(int idRespuesta) throws Exception {
		Respuesta c = dao.traer(idRespuesta);
		if (c == null) throw new Exception("Error: La respuesta no existe.");
		dao.eliminar(c);
	}
	
	
	public Respuesta traer(int idRespuesta) {
		return dao.traer(idRespuesta);
	}
	
	public List<Respuesta> traer() {
		return dao.traer();
	}


}
