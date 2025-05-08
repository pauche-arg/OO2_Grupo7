package datos;

import java.time.LocalDate;
import java.util.Objects;

public class Respuesta {
	private int idRespuesta;
	private String contenido;
	private LocalDate fecha;
	private Ticket ticket;
	
	public Respuesta() {}
	
	public Respuesta(String contenido, LocalDate fecha, Ticket ticket) {
		this.contenido = contenido;
		this.fecha = fecha;
		this.ticket = ticket;
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
	public int hashCode() {
		return Objects.hash(contenido, fecha, idRespuesta, ticket);
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
