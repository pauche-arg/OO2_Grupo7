package datos;

public enum Estado {
	ABIERTO("Abierto"),
	PENDIENTE("Pendiente"),
	CERRADO("Cerrado"),
	RESUELTO("Resuelto");
	
	private final String descripcion;
	
	Estado(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	
	

}
