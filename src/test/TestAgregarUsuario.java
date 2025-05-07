package test;

import datos.Usuario;
import negocio.SistemaAbm;
import negocio.TicketAbm;
import negocio.UsuarioAbm;

public class TestAgregarUsuario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//UsuarioABM abm = new UsuarioABM();
		SistemaAbm sis = new SistemaAbm();
		TicketAbm tic = new TicketAbm();
		/*int ultimoID=0;
		try {
			ultimoID = UsuarioAbm.getInstance().agregar("nombre","apellido","12345678","@email","AlexK","15154235");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		int id=2;
		//Usuario user1 = UsuarioAbm.getInstance().traer(id);
		/*int ultimoIDemp = UsuarioABM.getInstance().agregarEmp("nombre","apellido","12345678","@email","AlexK","15154235");
		System.out.printf("Id Empleado %d",ultimoIDemp);*/
		//System.out.println(sis.generarTicket(user1, "title", "cuerpo"));
		System.out.println(tic.traer(2));
		System.out.println(tic.traerSinUsuario(id));
	}

}
