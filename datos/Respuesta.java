package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Respuesta {
	private int idRespuesta;
	private String contenido;
	private LocalDate fecha;
	private Ticket ticket;
	
	public Respuesta() {}
	
	public Respuesta(String contenido, Ticket ticket) throws Exception {
		validarContenido(contenido);
		validarTicket(ticket);
		this.contenido = contenido;
		this.fecha = LocalDate.now();
		this.ticket = ticket;
	}
	
	public static void validarContenido(String contenido) throws Exception {
		 if (contenido == null ||contenido.trim().isEmpty()) {
		        throw new Exception("El contenido de la respuesta no puede estar vacía.");
		    }
		 
		 if (!contenido.matches(".*[a-zA-Z].*")) {
			    throw new Exception("El contenido de la respuesta debe contener al menos una letra.");
			}
	}
	
	
	public static void validarTicket(Ticket ticket) throws Exception {
	    if (ticket == null) {
	        throw new Exception("Debe especificarse un ticket para la respuesta.");
	    }
	}

	public int getIdRespuesta() {
		return idRespuesta;
	}

	private void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Respuesta [contenido=" + contenido + ", fecha=" + fecha + ", ticket=" + ticket + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Respuesta other = (Respuesta) obj;
		return Objects.equals(contenido, other.contenido) && Objects.equals(fecha, other.fecha)
				&& idRespuesta == other.idRespuesta && Objects.equals(ticket, other.ticket);
	}
	
	
	
	
	
	
	

}
