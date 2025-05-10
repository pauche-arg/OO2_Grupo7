package test;

import negocio.*;

import datos.*;

import java.time.LocalDate;

import dao.HibernateUtil;

public class TestABM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioABM usuarioABM = new UsuarioABM();
        EmpleadoABM empleadoABM = new EmpleadoABM();
        AdministradorABM administradorABM = new AdministradorABM();
        TicketABM ticketABM = new TicketABM();
        RespuestaABM respuestaABM = new RespuestaABM();
        
		
		System.out.println(HibernateUtil.getSessionFactory());
        
        try {
            System.out.println("=== AGREGANDO USUARIO ===");
            //int idUsuario = usuarioABM.agregar("Juan", "Pérez", "12345678", "juan@mail.com", "juanito", "1234");
            System.out.println(usuarioABM.traerUsuarios());
            //System.out.println("Usuario agregado con ID: " + idUsuario);
            
        	System.out.println("=== MODIFICANDO USUARIO ===");
            //Usuario u = usuarioABM.traer(idUsuario);
            //u.setEmail("nuevo_correo@mail.com");
            //usuarioABM.modificar(u);
            System.out.println("Usuario modificado.");

            System.out.println("=== LISTA DE USUARIOS ===");
            System.out.println(usuarioABM.traerUsuarios());

            System.out.println("=== LISTA DE EMPLEADOS ===");
            System.out.println(empleadoABM.traerEmpleados());
            
           //System.out.println("=== ELIMINANDO USUARIO ===");
            //usuarioABM.eliminar(idUsuario);
            //System.out.println("Usuario eliminado.");

            System.out.println("=== AGREGANDO EMPLEADO ===");
            int idEmpleado = empleadoABM.agregar("Ana", "García", "87654332", "ana@mail.com", "anita", "abcd");
            //int idEmpleado = empleadoABM.agregar("Maria", "Lopez", "12345679", "maria@mail.com", "mary", "cxfg");
            //int empleadoInv = empleadoABM.agregar("1234", "!!!!", "0", "zzzzzz", "mary", "cxfg");

            System.out.println("Empleado agregado con ID: " + idEmpleado);
            
            //System.out.println("=== ELIMINANDO EMPLEADO ===");
            //empleadoABM.eliminar(idEmpleado);
            //System.out.println("Empleado eliminado.");
        
            
        	System.out.println("=== AGREGANDO ADMINISTRADOR ===");
        	 int idAdministrador = administradorABM.agregar("Ricardo", "Perez", "34642379", "ricardo@mail.com", "ricardito", "fghj");
        	 
        	 System.out.println("Administrador agregado con ID: " + idAdministrador);
        	
        	System.out.println("=== AGREGANDO TICKET ===");
        	
        	Usuario usuarioTest = usuarioABM.traer("12345678");
        	Empleado empleadoTest = empleadoABM.traer("23586453");
        	
        	
        	int idTicket = ticketABM.agregar("test", "t", usuarioTest, empleadoTest);
        	//int ticketInv = ticketABM.agregar("3333", "!!!!", usuarioTest, null);
        	
        	 System.out.println("Ticket agregado con ID: " + idTicket);
        	 
             System.out.println("=== LISTA DE TICKETS ===");
             System.out.println(ticketABM.traerTickets());

        	System.out.println("=== AGREGANDO RESPUESTA ===");
        	
        	int idRespuesta = respuestaABM.agregar("aaa", ticketABM.traerTicket(1));
        	//int respuestaInv = respuestaABM.agregar("1", ticketABM.traerTicket(1));
        	
        	 System.out.println("Respuesta agregada con ID: " + idRespuesta);


        } catch (Exception e) {
            System.out.println("Error durante test: " + e.getMessage());
            e.printStackTrace();
        }
        
        
        
        
        
    }
}