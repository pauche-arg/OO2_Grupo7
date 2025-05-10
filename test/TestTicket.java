package test;

import java.time.LocalDate;

import datos.Ticket;
import datos.Usuario;
import negocio.SistemaTickets;
import datos.Empleado;
import datos.EstadoTicket;
import negocio.TicketABM;
import negocio.UsuarioABM;
import negocio.EmpleadoABM;

public class TestTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try { 
			UsuarioABM usuarioABM = new UsuarioABM();
			TicketABM ticketABM = new TicketABM();
			EmpleadoABM empleadoABM = new EmpleadoABM();
			SistemaTickets sistemaTicket = new SistemaTickets();
			
			//Empleado empleadoTest = new Empleado("Ana", "García", "87654321", "ana@mail.com", "anita", "abcd");
			
			//empleadoABM.agregar(empleadoTest.getNombre(), empleadoTest.getApellido(), empleadoTest.getDni(), empleadoTest.getEmail(), empleadoTest.getNombreUsuario(), empleadoTest.getContraseña());
			
			Empleado empleadoTest = empleadoABM.traer("87654321");
			Usuario usuarioTest = usuarioABM.traer("12345678");
			Ticket ticketTest = new Ticket("a", "bbb", usuarioTest, null);
			
			int idTicket = ticketABM.agregar("Test Ticket 1", "123", usuarioTest, empleadoTest);
			
			System.out.println("Ticket agregado con ID: " + idTicket);
			
			sistemaTicket.cambiarEstado(idTicket, EstadoTicket.RESUELTO);
			
			System.out.println(ticketABM.traerTickets());
			
			//Intentar cambiar el estado de un ticket a algo no valido
			//sistemaTicket.cambiarEstado(idTicket, "test");
			
			
			//Intentar crear un ticket
			int ticketAsignar = sistemaTicket.crearTicket("test", "test", usuarioTest);
			
			System.out.println(ticketABM.traerTicket(ticketAsignar));
			
			//Intentar asignar un empleado a un ticket
			sistemaTicket.asignarTicket(ticketAsignar, empleadoTest);
		
			
			System.out.println(sistemaTicket.traerTicket(ticketAsignar));
			
			//traer por usuario
			 System.out.println("=== TRAER TICKETS POR USUARIO ===");
			int idUsuario = usuarioTest.getIdUsuario();
			System.out.println(ticketABM.listarTicketsPorUsuario(idUsuario));
			
			
			System.out.println("=== TRAER TICKETS POR EMPLEADO ===");
			int idEmpleado = empleadoTest.getIdUsuario();
			System.out.println(sistemaTicket.listarTicketsPorEmpleado(idEmpleado));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
