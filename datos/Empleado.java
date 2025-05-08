package datos;

import java.util.List;
import java.util.ArrayList;

public class Empleado extends Usuario {
	private List<Ticket> tickets;
	
	public Empleado() {}

	public Empleado(String nombre, String apellido, String dni, String email,
			String nombreUsuario, String contraseña) {
		super(nombre, apellido, dni, email, nombreUsuario, contraseña);
		this.tickets = new ArrayList<Ticket>();
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
	
	
	
	
	

}
