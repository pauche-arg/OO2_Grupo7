package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import negocio.EmpleadoABM;
import negocio.TicketABM;
import negocio.UsuarioABM;

import datos.Ticket;
import datos.Empleado;
import datos.EstadoTicket;
import datos.Usuario;

public class SistemaTickets {
	private TicketABM ticketABM = new TicketABM();
    private UsuarioABM usuarioABM = new UsuarioABM();
    private EmpleadoABM empleadoABM = new EmpleadoABM();
	
    
    public int crearTicket(String titulo, String descripcion, Usuario usuarioCreador) throws Exception {
        Ticket ticket = new Ticket(
                titulo,
                descripcion,
                usuarioCreador,
                null // aún no asignado
            );
        
       return ticketABM.agregar(ticket);
    }
    
	//Empleado y Administrador pueden acceder a este metodo
	public void cambiarEstado(int idTicket, EstadoTicket nuevoEstado) throws Exception {
	Ticket ticket = ticketABM.traerTicket(idTicket);
	    if (ticket == null) throw new Exception("Ticket no encontrado.");
	    ticket.setEstado(nuevoEstado);
	    ticketABM.modificar(ticket);
	}
	
	public void asignarTicket(int idTicket, Empleado empleado) throws Exception {
	
		Ticket ticketAux = ticketABM.traerTicket(idTicket);
        if (ticketAux == null) throw new Exception("Ticket no encontrado.");
        
        Empleado empleadoAux = empleadoABM.traer(empleado.getIdUsuario());
        if (empleado == null) throw new Exception("Empleado no encontrado.");
        
        ticketAux.setEmpleadoAsignado(empleado);
        ticketABM.modificar(ticketAux);
	}
	
	
	public Ticket consultarDetallesTicket(int idTicket, int idUsuario) throws Exception {
	    Ticket ticket = traerTicket(idTicket);
	    if (ticket == null)
	        throw new Exception("Ticket no encontrado.");
	    
	    if (ticket.getUsuarioCreador().getIdUsuario() != idUsuario)
	        throw new Exception("No tiene permiso para ver este ticket.");

	    return ticket;
	}
	
	
	
	public Ticket traerTicket(int idTicket) {
		return ticketABM.traerTicket(idTicket);
	}
	
	public List<Ticket> listarTickets() throws Exception {
	    return ticketABM.traerTickets(); 
	}
	
	public List<Ticket> listarTicketsPorEstado(String estado) throws Exception {
	    return ticketABM.traerPorEstado(estado); 
	}
	
	public List<Ticket> listarTicketsPorUsuario(int idUsuario) throws Exception {
		return ticketABM.listarTicketsPorUsuario(idUsuario); 
	}
	
	public List<Ticket> listarTicketsPorEmpleado(int idEmpleado) throws Exception {
		return ticketABM.listarTicketsPorEmpleado(idEmpleado); 
	}
	
	
}
