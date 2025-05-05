package datos;

import java.util.List;
import java.util.ArrayList;

public class Empleado extends Usuario {
	private int idEmpleado;
	private List<Ticket> tickets;

	public Empleado(String nombre, String apellido, String dni, String email,
			String nombreUsuario, String contraseña) {
		super(nombre, apellido, dni, email, nombreUsuario, contraseña);
		this.tickets = new ArrayList<Ticket>();
	}
	
	public Empleado() {
		
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	private void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	private void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return super.toString() + "Empleado [idEmpleado=" + idEmpleado + ", tickets=" + tickets + "]";
	}
	
	
	
	
	

}
