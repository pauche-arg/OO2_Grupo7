package test;

import java.time.LocalDate;

import datos.Ticket;
import datos.Usuario;
import datos.Estado;
import negocio.TicketABM;
import negocio.UsuarioABM;
import negocio.EmpleadoABM;

public class TestTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try { 
			UsuarioABM usuarioABM = new UsuarioABM();
			TicketABM ticketABM = new TicketABM();
			
			
			Usuario usuarioTest = usuarioABM.traer("12345678");
			Ticket ticketTest = new Ticket("a", "bbb", usuarioTest);
			
			int idTicket = ticketABM.agregar("Test Ticket 1", "123", usuarioTest);
			
			System.out.println("Ticket agregado con ID: " + idTicket);
			
			
			System.out.println(ticketABM.traerTickets());
			
			//traer por usuario
			 System.out.println("=== TRAER TICKETS POR USUARIO ===");
			int idUsuario = usuarioTest.getIdPersona();
			System.out.println(ticketABM.listarTicketsPorUsuario(idUsuario));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
