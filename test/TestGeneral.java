package test;

import dao.HibernateUtil;
import datos.EstadoTicket;
import datos.Usuario;
import negocio.AdministradorABM;
import negocio.EmpleadoABM;
import negocio.SistemaTickets;
import negocio.TicketABM;
import negocio.UsuarioABM;

public class TestAgregarUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketABM ticketAbm = new TicketABM();
		UsuarioABM usuarioAbm = new UsuarioABM();
		EmpleadoABM empleadoAbm = new EmpleadoABM();
		AdministradorABM adminAbm = new AdministradorABM();
		SistemaTickets sistemaAbm = new SistemaTickets();
		System.out.println(HibernateUtil.getSessionFactory());
		
		try {
			System.out.println("=== AGREGANDO USUARIO, EMPLEADO Y ADMIN ===");
			int id1=usuarioAbm.agregar("usuariouno", "apellidouser", "11111111", "nom1@gmail.com", "user1", "1111");
			int id2=usuarioAbm.agregar("usuariodos", "apellidodos", "22222222", "nom1@gmail.com", "user2", "2222");
			int id3=empleadoAbm.agregar("empleadouno", "empleado", "33333333", "emple1@gmail.com", "emple1", "3333");
			int id5=empleadoAbm.agregar("empleadodos", "empleadodos", "55555555", "emple2@gmail.com", "emple2", "5555");
			int id4=adminAbm.agregar("admin", "adminapelli", "44444444", "admin1@gmail.com", "admin1", "4444");
			System.out.println("=== LISTA DE USUARIOS ===");
			System.out.println(usuarioAbm.traerUsuarios());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error durante test: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			System.out.println("=== AGREGANDO TICKET ===");
			System.out.println(sistemaAbm.crearTicket("title1", "cuerpo1", usuarioAbm.traer(1)));
			System.out.println(sistemaAbm.crearTicket("title2", "cuerpo2", usuarioAbm.traer(1)));
			System.out.println(sistemaAbm.crearTicket("title3", "cuerpo3", usuarioAbm.traer(1)));
			System.out.println(sistemaAbm.crearTicket("title4", "cuerpo4", usuarioAbm.traer(2)));
			System.out.println(sistemaAbm.crearTicket("title5", "cuerpo5", usuarioAbm.traer(2)));
			System.out.println("=== LISTA DE TICKETS ===");
			System.out.println(ticketAbm.traerTickets());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error durante test: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			System.out.println("=== LISTA DE TICKETS DEL USUARIO 1 ===");
			System.out.println(sistemaAbm.listarTicketsPorUsuario(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error durante test: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			System.out.println("=== ASIGNANDO TICKETS A UN EMPLEADO ===");
			sistemaAbm.asignarTicket(1, empleadoAbm.traer("33333333"));
			sistemaAbm.asignarTicket(4, empleadoAbm.traer("55555555"));
			System.out.println("Tickets del empleaado 3");
			System.out.println(sistemaAbm.listarTicketsPorEmpleado(3));
			System.out.println("Tickets del empleado 4 ");
			System.out.println(sistemaAbm.listarTicketsPorEmpleado(4));
			System.out.println("=== DETALLES DE UN TICKET DEL USUARIO 1 ===");
			System.out.println(sistemaAbm.consultarDetallesTicket(1, 1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error durante test: " + e.getMessage());
			e.printStackTrace();
		}
		
		try {
			System.out.println("=== CAMBIANDO ESTADO DE UN TICKET ===");
			System.out.println("Cambio de estado del ticket 1");
			sistemaAbm.cambiarEstado(1, EstadoTicket.CERRADO);
			System.out.println("=== LISTA DE TICKETS AHORA CON UN TICKET RESUELTO ===");
			System.out.println(sistemaAbm.listarTicketsPorUsuario(1));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error durante test: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
