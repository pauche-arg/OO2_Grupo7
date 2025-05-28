package datos;

import java.util.List;
import java.util.ArrayList;

public class Empleado extends Persona {
	private boolean disponibilidad;
	private boolean superior;
	private Area area;
	private List<Ticket> tickets;
	
	public Empleado() {}

	public Empleado(String nombre, String apellido, String dni, String email, String nombreUsuario, String clave,
			boolean disponibilidad, boolean superior, Area area) throws Exception {
		super(nombre, apellido, dni, email, nombreUsuario, clave);
		this.disponibilidad = disponibilidad;
		this.superior = superior;
		this.area = area;
	}
	
	public boolean isDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	private void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Empleado" + super.toString() + "[tickets=" + tickets + "]";
	}

	public boolean isSuperior() {
		return superior;
	}

	public void setSuperior(boolean superior) {
		this.superior = superior;
	}


}
