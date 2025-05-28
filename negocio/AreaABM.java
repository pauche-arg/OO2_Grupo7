package negocio;

import dao.AreaDao;
import datos.Area;

public class AreaABM {
	AreaDao dao = new AreaDao();
	
	public int agregarArea(String nombre, String descripcion) {
		Area nuevo = new Area(nombre, descripcion);
		return dao.agregar(nuevo);
	}
	
	public void actualizarArea(Area area) {
		dao.actualizar(area);
	}
	
	public void eliminarArea(Area area) {
		dao.eliminar(area);
	}
	
	public Area traerArea(int idArea) {
		return dao.traer(idArea);
	}

}
