package datos;

import java.time.LocalDate;

public class Ticket {
	private int idTicket;
	private String titulo;
	private String descripcion;
	private LocalDate fechaCreacion;
	private String estado;
	private Usuario usuarioCreador;
	private Empleado empleadoAsignado;
	
	public Ticket() {}
	
	public Ticket(String titulo, String descripcion, LocalDate fechaCreacion,
			Usuario usuarioCreador, Empleado empleadoAsignado) throws Exception {
		validarTitulo(titulo);
		validarDescripcion(descripcion);
		validarUsuario(usuarioCreador);
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = "Pendiente";
		this.usuarioCreador = usuarioCreador;
		this.empleadoAsignado = empleadoAsignado;
	}
	
	public static void validarTitulo(String titulo) throws Exception {
		 if (titulo == null ||titulo.trim().isEmpty()) {
		        throw new Exception("El título no puede estar vacío.");
		    }
		 
		 if (!titulo.matches(".*[a-zA-Z].*")) {
			    throw new Exception("El título debe contener al menos una letra.");
			}
	}
	
	public static void validarDescripcion(String descripcion) throws Exception {
		 if (descripcion == null || descripcion.trim().isEmpty()) {
		        throw new Exception("La descripción no puede estar vacía.");
		    }
		 
		 if (!descripcion.matches(".*[a-zA-Z].*")) {
			    throw new Exception("La descripción debe contener al menos una letra.");
			}
	}
	
	public static void validarUsuario(Usuario usuario) throws Exception {
		if (usuario == null) {
	        throw new Exception("Debe especificarse un usuario creador para el ticket.");
	    }
	}
	
	public static void validarEstado(String estado) throws Exception {
	    if (estado == null || estado.trim().isEmpty()) {
	        throw new Exception("El estado no puede estar vacío.");
	    }

	    String estadoNormalizado = estado.trim().toLowerCase();

	    if (!(estadoNormalizado.equals("pendiente") || 
	          estadoNormalizado.equals("en proceso") || 
	          estadoNormalizado.equals("resuelto"))) {
	        throw new Exception("El estado debe ser: Pendiente, En proceso o Resuelto.");
	    }
	}
	

	public int getIdTicket() {
		return idTicket;
	}

	private void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		
	 this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		
	 this.descripcion = descripcion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {

	    this.estado = estado;
	}

	public Usuario getUsuarioCreador() {
		return usuarioCreador;
	}

	public void setUsuarioCreador(Usuario usuarioCreador) {
		this.usuarioCreador = usuarioCreador;
	}

	public Empleado getEmpleadoAsignado() {
		return empleadoAsignado;
	}

	public void setEmpleadoAsignado(Empleado empleadoAsignado) {
		this.empleadoAsignado = empleadoAsignado;
	}

	@Override
	public String toString() {
		return "Ticket [titulo=" + titulo + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion
				+ ", estado=" + estado + ", usuarioCreador=" + usuarioCreador + ", empleadoAsignadoId=" + (empleadoAsignado != null ? empleadoAsignado.getIdUsuario() : "null")
				+ "]"
				+ ", estado=" + estado + ", usuarioCreador=" + usuarioCreador + "]\n";
	}
	
	public boolean esAsignado() {
		return this.empleadoAsignado != null;
	}
	
	public boolean estaResuelto() {
		return "resuelto".equalsIgnoreCase(this.estado);
	}
	
	public boolean esDelUsuario(Usuario u) {
		return this.usuarioCreador.equals(u);
	}
	
	
	
	
}


