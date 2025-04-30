package datos;

import java.util.ArrayList;
import java.util.List;

public class SistemaTickets {
	private List<Ticket> tickets;
	private List<Usuario> usuarios;
	public SistemaTickets() {
		this.tickets = new ArrayList<Ticket>();
		this.usuarios = new ArrayList<Usuario>();
	}
	
	
	public List<Ticket> getTickets() {
		return tickets;
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	
	
	
	
	
}
