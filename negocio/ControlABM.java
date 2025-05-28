package negocio;

import datos.Control;
import datos.Empleado;
import datos.Funcion;
import datos.Ticket;
import datos.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.TicketDao;
import dao.UsuarioDao;
import dao.ControlDao;
import dao.EmpleadoDao;

public class ControlABM {
	ControlDao dao = new ControlDao();

	
	public int agregar(Ticket ticket, Funcion funcion, Empleado empleado, LocalDate fechaEntrada,
			LocalDate fechaSalida) throws Exception {

		Control c = new Control(ticket, funcion, empleado, fechaEntrada,
				fechaSalida);
		return dao.agregar(c);
	}
	
	public int agregar(Control control) throws Exception {
		return dao.agregar(control);
	}
	
	
	public void modificar(Control c) throws Exception {
		try {
			dao.actualizar(c);
		} catch (Exception e) {
		    throw new Exception("Error: " + e.getMessage());
		}
	}
	
	public void eliminar(int idControl) throws Exception {
		Control c = dao.traer(idControl);
		if (c == null) throw new Exception("Error: El control no existe.");
		dao.eliminar(c);
	}
	
	
	public Control traerControl(int idControl) {
		return dao.traer(idControl);
	}
	
	public List<Control> traerControles() {
		return dao.traer();
	}
	
	public List<Control> listarControlesPorEmpleado(int idEmpleado) throws Exception {
		EmpleadoABM empleadoABM = new EmpleadoABM();
		//Empleado empleado = empleadoABM.traer(idEmpleado); 
		Empleado empleado = (Empleado) PersonaABM.getInstance().traerId(idEmpleado);
	
		
		 if (empleado == null) throw new Exception("Empleado no encontrado.");
		 
		List<Control> controlLista = new ArrayList<Control>();
		
		for (Control control : traerControles() ) { 
			//if (control.getEmpleado().getIdUsuario() == idEmpleado)
			 if (control.getEmpleado().getIdPersona() == idEmpleado) {
		            controlLista.add(control);
		        }
		    }
		
		return controlLista;
		}

}
