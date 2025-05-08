package test;

import datos.Usuario;
import negocio.TicketABM;
import negocio.UsuarioABM;

public class TestAgregarUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TicketABM tic = new TicketABM();
		UsuarioABM us = new UsuarioABM();
		/*int ultimoID=0;
		try {
			ultimoID = UsuarioAbm.getInstance().agregar("nombre","apellido","12345678","@email","AlexK","15154235");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		int id=2;
		System.out.println(us.traer(1));
		
		/*int ultimoIDemp = UsuarioABM.getInstance().agregarEmp("nombre","apellido","12345678","@email","AlexK","15154235");
		System.out.printf("Id Empleado %d",ultimoIDemp);*/
		//System.out.println(sis.generarTicket(user1, "title", "cuerpo"));
		System.out.println(tic.traerTicket(2));
	}

}
