package negocio;

import datos.Respuesta;
import datos.Ticket;

import java.time.LocalDate;
import java.util.List;

import dao.RespuestaDao;

public class RespuestaABM {
	RespuestaDao dao = new RespuestaDao();

	
	
	public int agregar(String contenido, Ticket ticket) throws Exception {
		Respuesta c = new Respuesta(contenido, ticket);
		return dao.agregar(c);
	}
	
	public void modificar(Respuesta c) throws Exception {
		dao.actualizar(c);
	}
	
	public void eliminar(int idRespuesta) throws Exception {
		Respuesta c = dao.traer(idRespuesta);
		if (c == null) throw new Exception("Error: La respuesta no existe.");
		dao.eliminar(c);
	}
	
	
	public Respuesta traer(int idRespuesta) {
		return dao.traer(idRespuesta);
	}
	
	public List<Respuesta> traer() {
		return dao.traer();
	}


}
