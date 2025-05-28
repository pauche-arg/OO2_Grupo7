package datos;

import java.util.Set;

public class Area {
	private int idArea;
	private String nombre;
	private String descripcion;
	private Set<Empleado> empleados;
	
	public Area() {
		
	}
	public Area(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Set<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(Set<Empleado> empleados) {
		this.empleados = empleados;
	}

	@Override
	public String toString() {
		return "Area [idArea=" + idArea + ", nombre=" + nombre + ", descripcion=" + descripcion + ", empleados="
				+ empleados + "]\n";
	}
	
	

}
